package com.akash.androidlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.akash.androidlibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout = binding.drawerLayout
        val navigationView = binding.drawerNavigationView
        val buttonDrawerToggle = findViewById<ImageButton>(R.id.button_drawer_toggle)

        // to programmatically change values in navigation view header
        // val headerView = navigationView.getHeaderView(0)
        // headerView.findViewById<>()

        buttonDrawerToggle.setOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.glide -> Toast.makeText(this, "Glide Screen Clicked", Toast.LENGTH_SHORT).show()
                R.id.recyclerView -> Toast.makeText(this, "Recycler View Screen Clicked", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this, "Section is under development", Toast.LENGTH_SHORT).show()
            }

            drawerLayout.close()

            false
        }
    }
}