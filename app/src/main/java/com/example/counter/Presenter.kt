package com.example.counter

class Presenter {

    private var model = CounterModel()
    private lateinit var counterView: CounterView

    fun increment(){
        model.increment()
        counterView.showNewCount(model.count)
        equatingNumbers()
    }

    fun decrement(){
        model.decrement()
        counterView.showNewCount(model.count)
        equatingNumbers()
    }

    fun fillCounterView(counterView: CounterView){
        this.counterView = counterView
    }

    fun equatingNumbers(){
        if (model.count == 10){
            counterView.showToast()
        }

        if (model.count == 15){
            counterView.setGreenColor()
        }
        else{
            counterView.setGreyColor()
        }
    }
}