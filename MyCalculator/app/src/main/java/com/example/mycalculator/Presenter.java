package com.example.mycalculator;

import android.view.View;


class Presenter implements View.OnClickListener {


    calculatorView calculatorView;

    public Presenter(CalculatorView calculatorView){
        this.calculatorView = calculatorView;
    }


    @Override
    public void onClick(View v) {

    }
}
