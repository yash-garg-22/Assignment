package com.yash.assignmentui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var viewpager: ViewPager
    lateinit var tab: TabLayout
    lateinit var refine: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        viewpager = findViewById(R.id.viewpager)
        tab= findViewById(R.id.tab)
        refine = findViewById(R.id.refine)
        setSupportActionBar(toolbar)

        val adapter = adapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(Personal(), "Personal")
        adapter.addFragment(Business(), "Business")
        adapter.addFragment(Merchant(), "Merchant")

        // Adding the Adapter to the ViewPager
        viewpager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(viewpager)

        refine.setOnClickListener {
            val intent = Intent(this, Refine::class.java)
            startActivity(intent)
        }
    }
}