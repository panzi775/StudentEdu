package com.example.demo.adapter;

// 创建recyclerView的适配器
//      * Get a View that displays the data at the specified position in the data set.
//      *
//      * You can either create a View manually or inflate it from an XML layout file.


import android.icu.text.IDNA
import android.util.Log
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.CheckBox
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView;
import com.example.demo.R
import java.util.zip.Inflater

//自定义CustomAdapter类，继承自RecyclerView.Adapter

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    private var createHolderCount = 0
    private val items = mutableListOf<String>()
    private val selectedPositions = mutableSetOf<Int>() // 错误：使用position记录选中状态

    init {
        // 初始化10条数据
        for (i in 0..100) {
            items.add("Item $i")
        }
    }

    // 创建ViewHolder类
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 在这里可以定义item的视图组件
        val textView: TextView = itemView.findViewById(R.id.contentDesc) // 假设item布局中有一个TextView
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox) // 假设item布局中有一个CheckBox
    }

    // 返回item的数量
    override fun getItemCount(): Int {
        return items.size
    }


    // 绑定数据到ViewHolder
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Log.i("pangao", "onBindViewHolder: $position")

        //刷新
        val item = items[position]
        holder.textView.text = item

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedPositions.add(position)
            } else {
                selectedPositions.remove(position)
            }
            Log.i("pangao", "Position $position checked: $isChecked")
        }

        holder.checkBox.isChecked = position in selectedPositions

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
//        Log.i("pangao", "onCreateViewHolder: createHolderCount = ${++createHolderCount}")
        return CustomViewHolder(view)
    }

}
