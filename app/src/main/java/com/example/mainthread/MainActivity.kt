package com.example.mainthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler() {
            hello.text = it.data.getString("file_name")
            true
        }

        val newThread = Thread {
            val msg = handler?.obtainMessage()
            msg?.data = downloadFile()
            handler?.sendMessage(msg!!)
        }
        newThread.start()
    }

    private fun downloadFile(): Bundle {
        Thread.sleep(5000)
        val file = Bundle()
        file.putString("file_name", "ПРИВЕТ МИР!")
        return file
    }
}
