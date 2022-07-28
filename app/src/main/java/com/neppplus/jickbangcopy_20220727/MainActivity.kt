package com.neppplus.jickbangcopy_20220727

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.neppplus.jickbangcopy_20220727.adapters.RoomAdapter
import com.neppplus.jickbangcopy_20220727.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<RoomData>()
    lateinit var mRoomAdapter : RoomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomList.add( RoomData(8000, "마포구 서교동", 1, "망원/홍대역 풀옵션 넓은 원룸") )
        mRoomList.add( RoomData(28000, "마포구 서교동", 5, "홍대입구역 풀옵션 투룸") )
        mRoomList.add( RoomData(12000, "마포구 서교동", 2, "망원/홍대역 인근 신축 원룸 전세") )
        mRoomList.add( RoomData(12000, "마포구 망원동", 3, "홍대역 풀옵션 넓은 원룸") )
        mRoomList.add( RoomData(15000, "마포구 망원동", 5, "테라스가 넓은 풀옵션 넓은 원룸") )
        mRoomList.add( RoomData(13000, "마포구 망원동", 3, "넓고 반듯한 신축 원룸") )
        mRoomList.add( RoomData(9000, "마포구 연남동", 2, "홍대역 풀옵션 넓은 원룸") )
        mRoomList.add( RoomData(7500, "마포구 연남동", -2, "연남동 연습 가능 연습실") )
        mRoomList.add( RoomData(26000, "마포구 연남동", 3, "강추!! 홍대역 테라스 넓은 원룸") )
        mRoomList.add( RoomData(5500, "마포구 연남동", 0, "홍대역 풀옵션 원룸") )

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mRoomAdapter

//        ListView 클릭 이벤트 처리
        roomListView.setOnItemClickListener { adapterView, view, i, l ->
            val myIntent = Intent(this, DetailRoomActivity::class.java)
//            한 방에 대한 정보를 가지고 Intent 실행
//            한 방의 데이터 => 변수
            val roomData = mRoomList[i]  // 한 방의 정보를 담고있는 RoomData
//            myIntent.putExtra("price", roomData.price)
//                .putExtra("address", roomData.address)
//                .putExtra("level", roomData.level)
//                .putExtra("description", roomData.description)

            myIntent.putExtra("roomData", roomData)

            startActivity(myIntent)
        }

        roomListView.setOnItemLongClickListener { adapterView, view, position, l ->

//            실제로 삭제 처리 할 건지? 경고문 팝업(AlertDialog)
            val alert = AlertDialog.Builder(this)
                .setTitle("제목")
                .setMessage("물어볼 내용")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
//                    확인버튼을 눌렀을때 해줄 로직
                    mRoomList.removeAt(position)
                    mRoomAdapter.notifyDataSetChanged()
                    Toast.makeText(this, "목록이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("취소", null)
                .show()

            return@setOnItemLongClickListener true
        }

    }
}