package com.example.myapplication

class Riaju {
    val list = listOf(R.drawable.riajuu_1, R.drawable.riajuu_2,R.drawable.riajuu_3,R.drawable.riajuu_4,R.drawable.riajuu_5)
    var kakuritu=10
    var pop = false
    var isRiaju=true

    fun hantei():Int{
        val random=(1..100).random()
        pop = random<=kakuritu

        if(pop){
            var random2=(1..6).random()
            when(random2){
                1->{
                    isRiaju=true
                    return R.drawable.riajuu_1
                }
                2->{
                    isRiaju=true
                    return R.drawable.riajuu_2
                }
                3->{
                    isRiaju=true
                    return R.drawable.riajuu_3
                }
                4->{
                    isRiaju=true
                    return R.drawable.riajuu_4
                }
                5->{
                    isRiaju=true
                    return R.drawable.riajuu_5
                }
                6->{
                    isRiaju=false
                    return R.drawable.christmas_hitori_bocchi
                }
                else -> return R.drawable.doa
            }



        }else{
            return R.drawable.doa

        }
    }
}