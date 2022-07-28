package com.neppplus.jickbangcopy_20220727.datas

import android.util.Log
import java.io.Serializable
import java.text.DecimalFormat

class RoomData (
    val price : Int,
    val address : String,
    val level : Int,
    val description : String
        ) : Serializable {

    fun getFormattedPrice() : String {
//        어떤 모양(format)으로 꾸밀건지에 대한 변수화
        val formatter = DecimalFormat("#,###")

        var resultPrice = ""

        if (price < 10000) {
           resultPrice  = formatter.format(price)
        } else {
//            ex. price = 28500
//            over = 2
            val over : Int = price / 10000
//            remain = 8500
            val remain = price % 10000

//            resultPrice = over.toString() + "억" + formatter.format(remain)   // 2억8,500

            resultPrice = "${over}억${formatter.format(remain)}"
        }
        return resultPrice
    }

    fun getFormattedLevel() : String {
        var resultLevel = ""

//        로직을 거치고
//        양수, 0일때, 음수일때 -> 조건식 (if / else if / else)
//        양수일때
//        if (level > 0) {
//            resultLevel = "${level}층"
//        }
//        else if (level == 0) {
//            resultLevel = "반지층"
//        }
//        else {
//            resultLevel = "지하 ${level * -1}층"
//        }

//        조건식 when
        when {
            level > 0 -> {
//                level이 양수일 경우의 로직
                resultLevel = "${level}층"
            }
            level < 0 -> {
//                level이 음수일 경우
                resultLevel = "지하 ${level * -1}층"

            }
            else -> {
//                level이 음수도, 양수도 아닌 경우 -> level == 0
                resultLevel = "반지층"
            }
        }

//        완성된 resultLevel return
        return resultLevel
    }
}