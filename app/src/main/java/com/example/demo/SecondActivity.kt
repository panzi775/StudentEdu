package com.example.demo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import com.example.demo.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    private val mHandler: Handler = object : Handler() {
        // 非静态内部类
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                0 -> {
                    Log.i("pangao", "handleMessage: 处理消息")
                    // 处理消息
                }
                else -> {
                    Log.i("pangao", "handleMessage: 未知消息")
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mHandler.postDelayed(Runnable {}, 10000)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            Log.i("pangao", "onCreate: toolbar setNavigationOnClickListener")
            // 处理返回按钮点击事件
            onBackPressedDispatcher.onBackPressed()
        }

        val navController = findNavController(R.id.nav_host_fragment_content_second)
        appBarConfiguration = AppBarConfiguration(setOf())
        setupActionBarWithNavController(this, navController, appBarConfiguration)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).setAnchorView(R.id.fab).show()
            AlertDialog.Builder(this)
                // 设置风格
                .setIcon(R.drawable.ic_launcher_foreground).setCancelable(false)
                .setSingleChoiceItems(arrayOf("pangao", "pangao1", "pangao2"), 0, { dialog, which ->
                    Log.i("pangao", "onCreate: selected item $which")
                }).setTitle("提示")
                .show()


            saveDataWithSp()

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_second)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun saveDataWithSp() {
        // 模拟保存数据到 SharedPreferences
        val sharedPreferences = getSharedPreferences("demo_prefs", MODE_PRIVATE)
        sharedPreferences.edit(commit = false) {
            putString("key", "value")
        }
    }
}