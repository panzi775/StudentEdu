package com.example.demo

import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.adapter.CustomAdapter
import com.example.demo.databinding.MainActivityLlBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityLlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView.adapter = CustomAdapter()
        binding.recycleView.layoutManager = LinearLayoutManager(this)
    }

}