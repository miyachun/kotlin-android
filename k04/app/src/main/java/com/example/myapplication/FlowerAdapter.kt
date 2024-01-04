package com.example.myapplication
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class FlowerAdapter(flowerList: ArrayList<Flower>) :
    RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

    private var mFlowerList: ArrayList<Flower> = flowerList

      private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onDeleteClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.flower_item, parent, false)
        return FlowerViewHolder(v, mListener)
    }

    override fun getItemCount(): Int {
        return mFlowerList.size
    }

    fun removeCountryItem(mPosition: Int){
        mFlowerList.removeAt(mPosition)
        notifyItemRemoved(mPosition)
    }

    fun getCountryItem(mPosition: Int):Flower{
        return mFlowerList[mPosition]
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val currentItem: Flower = mFlowerList[position]
        holder.mTextView.text = currentItem.userName
        holder.mTextView01.text = currentItem.description
        currentItem.image?.let { holder.flowerImage.setImageResource(it) }
    }

    class FlowerViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var mTextView: TextView = itemView.findViewById(R.id.flower_text)
        var mTextView01: TextView = itemView.findViewById(R.id.flower_text01)
        var flowerImage: ImageView = itemView.findViewById(R.id.flower_image)
        var mDeleteImage: ImageView = itemView.findViewById(R.id.image_delete)

        init {

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }

            mDeleteImage.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onDeleteClick(position)
                }



            }
        }

    }
}

