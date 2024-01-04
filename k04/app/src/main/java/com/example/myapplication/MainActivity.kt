package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mFlowerList: ArrayList<Flower>
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var mAdapter:FlowerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFlowerList()
        buildRecyclerView()
    }

    private fun buildRecyclerView() {
        mRecyclerView= findViewById(R.id.recyclerView)
        mLayoutManager= LinearLayoutManager(this)
        mAdapter= FlowerAdapter(mFlowerList)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter


        mAdapter.setOnItemClickListener(object : FlowerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity,  mAdapter.getCountryItem(position).userName, Toast.LENGTH_SHORT).show()

            }

            override fun onDeleteClick(position: Int) {
                mAdapter.removeCountryItem(position)
            }
        })
    }

    private fun createFlowerList(){

        mFlowerList= ArrayList()

        mFlowerList.add(Flower( userName = "Rose",image = R.drawable.rose,description ="Rose comes from the Latin word Rosa. There are over 100..."))
        mFlowerList.add(Flower( userName = "Freesia",image = R.drawable.freesia,description="Freesias bloom during spring and are native to Africa."))
        mFlowerList.add(Flower( userName = "Lily",image = R.drawable.lily,description = "Lilies have the longest in vase lifespan of any cut bloom."))


    }

    }





