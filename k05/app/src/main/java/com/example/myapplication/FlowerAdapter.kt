/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.recyclersample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class FlowerAdapter(val flowerList: ArrayList<String>) :

    RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {
    inner class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flowerTextView: TextView = itemView.findViewById(R.id.flower_text)
        val mDeleteImage:ImageView = itemView.findViewById(R.id.image_delete)

        fun bind(word: String,index:Int) {
            flowerTextView.text = word
            mDeleteImage.setOnClickListener {
                   deleteItem(index)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flower_item, parent, false)
        return FlowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(flowerList[position],position)

    }
    fun deleteItem(position: Int){
        flowerList.removeAt(position)
        notifyDataSetChanged()
    }


}



