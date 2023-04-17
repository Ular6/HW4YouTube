package com.example.less2_6.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.less2_6.R
import com.example.less2_6.databinding.ActivityMainBinding
import com.example.less2_6.databinding.NetworkErrorLayoutBinding
import com.example.less2_6.network.NetworkConnection

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val playlist = findViewById<RecyclerView>(R.id.rv_playlist)
        val inflateLayout = findViewById<View>(R.id.networkError)
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) {
            if (it) {
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
                playlist.visibility = View.VISIBLE
                inflateLayout.visibility = View.GONE
            } else {
                inflateLayout.visibility = View.VISIBLE
                playlist.visibility = View.GONE
                Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}