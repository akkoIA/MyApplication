package com.example.myapplication

class Riaju {
    val list = listOf(R.drawable.riajuu_1, R.drawable.riajuu_2,R.drawable.riajuu_3,R.drawable.riajuu_4,R.drawable.riajuu_5)
    var kakuritu=10
    var pop = false

    fun hantei():Int{
        val random=(1..100).random()
        pop = random<=kakuritu

        if(pop){
            var random2=(1..5).random()
            when(random2){
                1->return R.drawable.riajuu_1
                2->return R.drawable.riajuu_2
                3->return R.drawable.riajuu_3
                4->return R.drawable.riajuu_4
                5->return R.drawable.riajuu_5
                else -> return R.drawable.doa
            }



        }else{
            return R.drawable.doa

        }
    }
}