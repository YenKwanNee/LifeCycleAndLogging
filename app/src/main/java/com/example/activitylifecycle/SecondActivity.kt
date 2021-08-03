package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.models.QuestionModel

class SecondActivity : AppCompatActivity() {

  private lateinit var myModel : QuestionModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("LifeCycle", "onCreate")

        val btn : Button = findViewById(R.id.btnAdd)
        val tv : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

        //myModel = QuestionModel()

      //  myModel = ViewModelProvider(this).get(QuestionModel::class.java)
        myModel = QuestionModel.getInstance()
        tv.text = myModel.getQuestion()
        tvName.text = myModel.name
       // if(savedInstanceState != null)
        //tv.text =  savedInstanceState?.getString("question")



        btn.setOnClickListener() {
           tv.text = myModel.generateQuestion()
        }
    }



    override fun onStart(){
        super.onStart()
        Log.i("LifeCycle", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.i("LifeCycle", "onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("LifeCycle", "onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("LifeCycle", "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("LifeCycle", "onDestroy")
    }

   override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    val tvQ : TextView = findViewById(R.id.tvQuestion)
    outState.putString("question", tvQ.text.toString())

    }
}