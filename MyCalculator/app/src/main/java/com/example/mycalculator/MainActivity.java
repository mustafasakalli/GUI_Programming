package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    EditText txtNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = findViewById(R.id.txtNumber);

        TableLayout table = findViewById(R.id.numpad);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            for (int j = 0; i < table.getChildCount(); j++) {
                Button btn = (Button) row.getChildAt(j);
                btn.setOnClickListener(new Presenter(this));
            }
        }


    }

    @Override
    public void setNumber(String number) {
        txtNum.setText(number);

    }

    @Override
    public String setNumber() {
        return txtNum.getText().toString();

    }
}