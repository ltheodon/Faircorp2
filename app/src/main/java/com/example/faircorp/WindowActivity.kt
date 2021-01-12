package com.example.faircorp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.faircorp.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WindowActivity : BasicActivity() {
    val windowService = WindowService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getLongExtra(WINDOW_NAME_PARAM, 0)
        var window = WindowDto(1, "Entry Window", Status.CLOSED, "Room EF 6.10", 1)

        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiServices().windowsApiService.findById(id).execute() } // (2)
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (3)
                        findViewById<TextView>(R.id.txt_window_name).text = it.body()!!.name
                        findViewById<TextView>(R.id.txt_room_name).text = it.body()!!.roomName
                        findViewById<TextView>(R.id.txt_window_status).text = it.body()!!.windowStatus.toString()

                    }
                }
            runCatching { ApiServices().roomsApiService.findById(id).execute() } // (2)
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (3)
                        findViewById<TextView>(R.id.txt_window_current_temperature).text = it.body()!!.currentTemperature.toString()
                        findViewById<TextView>(R.id.txt_window_target_temperature).text = it.body()!!.targetTemperature.toString()
                    }
                }
        }


        if (window != null) {
            /*findViewById<TextView>(R.id.txt_window_name).text = window.name
            findViewById<TextView>(R.id.txt_room_name).text = window.roomName*/
            findViewById<TextView>(R.id.txt_window_current_temperature).text = "TODO"
            findViewById<TextView>(R.id.txt_window_target_temperature).text = "TODO"
            //findViewById<TextView>(R.id.txt_window_status).text = window.windowStatus.toString()
            /*findViewById<TextView>(R.id.txt_window_current_temperature).text = window.room.currentTemperature?.toString()
            findViewById<TextView>(R.id.txt_window_target_temperature).text = window.room.targetTemperature?.toString()
            findViewById<TextView>(R.id.txt_window_status).text = window.status.toString()*/
        }else{
            findViewById<TextView>(R.id.txt_window_name).text = id.toString()
        }
    }
}