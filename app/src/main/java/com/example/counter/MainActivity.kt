package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.fillCounterView(this)
        initClicker()

    }

    private fun initClicker() {
        with(binding){
            btnIncrement.setOnClickListener {
                presenter.increment()
            }

            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showNewCount(count: Int){
        binding.tvResult.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(applicationContext, "Congratulations!", Toast.LENGTH_SHORT).show()
    }

    override fun setGreenColor() {
        binding.tvResult.setTextColor(resources.getColor(R.color.green))

    }

    override fun setGreyColor() {
        binding.tvResult.setTextColor(resources.getColor(R.color.grey))

    }
}