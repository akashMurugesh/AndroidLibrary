package com.akash.androidlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.akash.androidlibrary.databinding.ActivityMainBinding
import com.akash.androidlibrary.fragments.GlideFragment
import com.akash.androidlibrary.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout = binding.drawerLayout
        val navigationView = binding.drawerNavigationView
        val buttonDrawerToggle = binding.buttonDrawerToggle

        // to programmatically change values in navigation view header
        // val headerView = navigationView.getHeaderView(0)
        // headerView.findViewById<>()

        // Set onClick functionality to toolbar menu button
        buttonDrawerToggle.setOnClickListener {
            drawerLayout.open()
        }

        // Set the default fragment in the main Activity as Home Fragment
        replaceFragment(HomeFragment())

        // Set clickListeners for the navigation drawer menu items
        navigationView.setNavigationItemSelectedListener { item ->
            fragmentNavigationOnItemSelected(item)
            drawerLayout.close()
            false
        }
    }

    private fun fragmentNavigationOnItemSelected(item: MenuItem) {

        when (item.itemId) {
            R.id.home -> {
                replaceFragment(HomeFragment())
                Toast.makeText(this, "Welcome Back To Home", Toast.LENGTH_SHORT).show()
            }
            R.id.glide -> {
                replaceFragment(GlideFragment())
                Toast.makeText(this, "Built With Glide", Toast.LENGTH_SHORT).show()
            }
            R.id.recyclerView -> Toast.makeText(this, "Recycler View Screen Clicked", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Section is under development", Toast.LENGTH_SHORT).show()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}