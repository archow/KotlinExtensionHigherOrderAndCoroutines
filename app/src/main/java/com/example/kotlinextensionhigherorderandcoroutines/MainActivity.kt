package com.example.kotlinextensionhigherorderandcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mCurrentTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCurrentTime = findViewById(R.id.current_time_tv)
        displayTime()

//        Toast.makeText(this,
//            "This is just a message",
//            Toast.LENGTH_LONG
//        ).show()
        this.showToast("This is just a message")

        //this scope is responsible for launching our coroutine
        //how long it lasts depends on the type of scope
        //the argument it takes determines which thread it
        //launches on (using Dispatchers object)
//        CoroutineScope(Dispatchers.Main).launch {
//            while (isActive) {
//                delay(1000L)
//                displayTime()
//            }
//        }
        myCoroutine {
            displayTime()
        }


        //What are scope functions?
        //they are methods (usually done after a variable,
        //more often right after a null-safety operator, like
        //? or !!) that perform some action on the variable
        //5 main scope functions:
        //let - usually done with a variable that can be null,
        //      so, usually after a questionmark;
        //      if the variable is NOT null, perform the code
        //      within the let block
        //run - usually done right after the let block
        //apply - used for modifying the member variables of an
        //      object; (this means that it's usually used after
        //      non-primitive variables)
        //also - tba
        //with - similar to apply, except it does not return a value

        //let example:
        var name: String? = "wil"
        //this is equivalent to an if statement for checking
        //if the variable is not null
        //basically: if(name != null) { do this }
        name?.let {
            this.showToast(
                "this is not null, and it's called ${it}")
        }.run {
            //executes if this is null
        }
    }

    private fun displayTime() {
        val dt = Date()
        val hours = dt.hours
        val minutes = dt.minutes
        val seconds = dt.seconds
        val curTime = "$hours:$minutes:$seconds"
        mCurrentTime.text = curTime
    }
}