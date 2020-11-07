package com.example.myapplication

import io.realm.RealmObject

open class Result(
    open var firsttext:Int=0,
    open var secondtext:Int=0,
    open var thirdtext:Int =0
): RealmObject()

