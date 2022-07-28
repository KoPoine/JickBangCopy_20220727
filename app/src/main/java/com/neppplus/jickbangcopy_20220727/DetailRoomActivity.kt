package com.neppplus.jickbangcopy_20220727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.jickbangcopy_20220727.datas.RoomData
import kotlinx.android.synthetic.main.activity_detail_room.*
import java.text.DecimalFormat

class DetailRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_room)

//        MainActivity의 ListView 클릭 이벤트 바탕으로 전달된 Extra를 받아오기
//        val price = intent.getIntExtra("price", 0)
//        val address = intent.getStringExtra("address")
//        val level = intent.getIntExtra("level", 0)
//        val description = intent.getStringExtra("description")

        val roomData = intent.getSerializableExtra("roomData") as RoomData

//        받아온 Data를 바탕으로 UI 반영
        priceTxt.text = roomData.getFormattedPrice()
        addressTxt.text = "${roomData.address}, ${roomData.getFormattedLevel()}"
        descriptionTxt.text = roomData.description
    }
}