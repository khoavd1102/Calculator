package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void numberEvent(View view) {
        if (isNewOp)
            edt.setText("");
        isNewOp = false;
        String number = edt.getText().toString();

        switch (view.getId()) {
            case R.id.one_btn:
                number += "1";
                break;
            case R.id.two_btn:
                number += "2";
                break;
            case R.id.three_btn:
                number += "3";
                break;
            case R.id.four_btn:
                number += "4";
                break;
            case R.id.five_btn:
                number += "5";
                break;
            case R.id.six_btn:
                number += "6";
                break;
            case R.id.seven_btn:
                number += "7";
                break;
            case R.id.eight_btn:
                number += "8";
                break;
            case R.id.nine_btn:
                number += "9";
                break;
            case R.id.zero_btn:
                number += "0";
                break;
        }
        edt.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = edt.getText().toString();
        switch (view.getId()) {
            case R.id.division_btn:
                op = "/";
                break;
            case R.id.multiplication_btn:
                _btn:
                op = "*";
                break;
            case R.id.plus_btn:
                op = "+";
                break;
            case R.id.minus_btn:
                op = "-";
                break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = edt.getText().toString();
        long result = 0;
        switch (op){
            case "+":
                result = Long.parseLong(oldNumber) + Long.parseLong(newNumber);
                break;
            case "-":
                result = Long.parseLong(oldNumber) - Long.parseLong(newNumber);
                break;
            case "*":
                result = Long.parseLong(oldNumber) * Long.parseLong(newNumber);
                break;
            case "/":
                result = Long.parseLong(oldNumber) / Long.parseLong(newNumber);
                break;
        }
        edt.setText(result + "");
    }

    public void clearEntryEvent(View view) {
    }

    public void clearEvent(View view) {
        edt.setText("0");
    }
}