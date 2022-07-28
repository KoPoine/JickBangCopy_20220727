package com.neppplus.jickbangcopy_20220727.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.neppplus.jickbangcopy_20220727.datas.RoomData
import kotlinx.android.synthetic.main.room_list_item.view.*

class RoomAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<RoomData>
) : ArrayAdapter<RoomData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }
        val row = tempRow!!

        val roomData = mList[position]

        row.priceTxt.text = roomData.getFormattedPrice()
        row.addressTxt.text = "${ roomData.address }, "
        row.levelTxt.text = roomData.getFormattedLevel()
        row.descriptionTxt.text = roomData.description

        return row
    }

}