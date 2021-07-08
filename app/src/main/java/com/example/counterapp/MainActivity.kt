package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var count_btn: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count_btn= findViewById(R.id.increment_btn)
        result= findViewById(R.id.counter_res)

        count_btn.setOnClickListener{
            var res= result.text.toString().toInt()
            res++
            var formattedRes= String.format("%04d", res)
            result.text= formattedRes
        }
    }
    override fun onSaveInstanceState(outState: Bundle) { 
        super.onSaveInstanceState(outState)
        outState.putString("result", result.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { 
        super.onRestoreInstanceState(savedInstanceState)
        result.text= savedInstanceState.getString("result")

    }

}
