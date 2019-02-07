package com.sample.dynamicthemeapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val receiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val powerManager = context.getSystemService( Context.POWER_SERVICE ) as PowerManager
            Toast.makeText(context, "Power Saver Mode ${powerManager.isPowerSaveMode}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver( receiver, IntentFilter( PowerManager.ACTION_POWER_SAVE_MODE_CHANGED ) )
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver( receiver )
    }
}
