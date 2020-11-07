package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result: Result?=read()

        val score = intent.getIntExtra("score", 0)

        if(result !=null){
            realm.executeTransaction {
                //1位を2位に
                if (score>=result.firsttext){
                    result.thirdtext=result.secondtext
                    result.secondtext=result.firsttext
                    result.firsttext=score
                }else if (result.secondtext<=score){
                    result.thirdtext=result.secondtext
                    result.secondtext=score
                }else if (score>=result.thirdtext){
                    result.thirdtext=score
                }
            }

            firsttext.text = result.firsttext.toString()
            secondtext.text = result.secondtext.toString()
            thirdtext.text = result.thirdtext.toString()
            scoreText.text = score.toString()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun read(): Result?{
        return realm.where(Result::class.java).findFirst()
    }

}
