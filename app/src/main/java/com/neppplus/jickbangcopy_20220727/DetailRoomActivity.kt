package com.neppplus.jickbangcopy_20220727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_room.*

class DetailRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_room)

//        MainActivity의 ListView 클릭 이벤트 바탕으로 전달된 Extra를 받아오기
        val price = intent.getIntExtra("price", 0)
        val address = intent.getStringExtra("address")
        val level = intent.getIntExtra("level", 0)
        val description = intent.getStringExtra("description")

//        받아온 Data를 바탕으로 UI 반영
        priceTxt.text = price.toString()
        addressTxt.text = "${address}, ${level}"
        descriptionTxt.text = description
    }
}