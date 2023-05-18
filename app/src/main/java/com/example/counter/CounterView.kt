package com.example.counter

interface CounterView {
    fun showNewCount(count: Int)

    fun showToast()

    fun setGreenColor()

    fun setGreyColor()
}