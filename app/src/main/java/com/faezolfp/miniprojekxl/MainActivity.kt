package com.faezolfp.miniprojekxl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.faezolfp.miniprojekxl.databinding.ActivityMainBinding
import com.faezolfp.miniprojekxl.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        setDisplay()
    }

    private fun setDisplay() {
        binding?.rvSample?.layoutManager = LinearLayoutManager(this)
        viewModel.getListDataGempaTerkini().observe(this) { data ->
            if (data.isNotEmpty()) {
                adapter = MainAdapter()
                adapter.setDataGempaTerkini(data)
                binding?.rvSample?.adapter = adapter

            }
        }
    }
}