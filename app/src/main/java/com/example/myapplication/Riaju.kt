package com.example.myapplication

class Riaju {
    val list = listOf(R.drawable.riajuu_1, R.drawable.riajuu_2)
    var kakuritu=10
    var pop = false

    fun hantei():Boolean{
        val random=(1..100).random()
        pop = random<=kakuritu
        return pop
    }
}