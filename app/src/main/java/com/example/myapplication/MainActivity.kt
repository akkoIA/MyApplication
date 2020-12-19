package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val realm:Realm=Realm.getDefaultInstance()

    var addPoint = 10
    var score = 0
    var time: Int = 30
    var count: Int = 30
    val handler = Handler()
    lateinit var riajuArray: Array<Array<Riaju>>
    lateinit var doaArray: Array<Array<ImageView>>


    inner class MYCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        var isRunning = false


        override fun onTick(millisUntilFisished: Long) {
            val sec = (millisUntilFisished / 1000L) % 60L

            //配列中の全ての要素に対して処理を行うための二重のfor文
            for(i in 0..2){
                for(j in 0..3){


                    doaArray[i][j].setImageResource(riajuArray[i][j].hantei())


                    // 独自クラスから値を出力
                    val tempValue = riajuArray[i][j]
                }
            }

            //timerText.text = "%1l:%2$02l"
            timerText.text = "${sec}"

        }

        override fun onFinish() {
             for (i in 0..2) {
                 for(j in 0..3) {
                     doaArray[i][j].setImageResource(R.drawable.doa)
                     riajuArray[i][j].pop = false
                 }

             }
            timerText.text = "0"
            start.isClickable = true
            val toResultActivityIntent= Intent(applicationContext, ResultActivity::class.java)
            toResultActivityIntent.putExtra("score", score)
            startActivity(toResultActivityIntent)
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンを押すと3行4列で並んでいるTextViewに独自クラスで定義した値が表示されて，ついでに値によって色が変わるアプリ

        val realm= Realm.getDefaultInstance()
        if(realm.where(Result::class.java).findFirst() == null) {
            realm.executeTransaction {
                val newResult :Result =it. createObject(Result::class.java)
                newResult.firsttext=0
                newResult.secondtext=0
                newResult.thirdtext=0

            }
        }
        
        val koukaon=MediaPlayer.create(this,R.raw.game_explosion5)

        riajuArray = arrayOf(
            arrayOf(Riaju(), Riaju(), Riaju(),Riaju()),
            arrayOf(Riaju(), Riaju(),Riaju(), Riaju()),
            arrayOf(Riaju(), Riaju(),Riaju(), Riaju())
        )
        doaArray = arrayOf(
            arrayOf(doa1,doa2,doa3,doa4),
            arrayOf(doa5,doa6,doa7,doa8),
            arrayOf(doa9,doa10,doa11,doa12)
        )

        for (i in 0..2){
            for (j in 0..3){
                doaArray[i][j].setOnClickListener {
                    if (riajuArray[i][j].pop){
                        doaArray[i][j].setImageResource(R.drawable.bakuhatu)
                        koukaon.seekTo(0)
                        koukaon.start()
                        score=score+addPoint
                        point.text=score.toString()
                        riajuArray[i][j].pop = false
                    }
                }

            }


        }

        timerText.text = "0"
        val timer = MYCountDownTimer(1 * 60 * 1000, 1000)


        start.setOnClickListener{
                    val game_explosion5= MediaPlayer.create(this,R.raw.scream1)

            game_explosion5.seekTo(0)
            game_explosion5.start()

            for (i in 0..2) {
                for(j in 0..3) {
                    doaArray[i][j].setImageResource(R.drawable.doa)
                }

            }
            timerText.text = "0"
            score = 0

            timer.start()
            start.isClickable = false
        }




        }



    }