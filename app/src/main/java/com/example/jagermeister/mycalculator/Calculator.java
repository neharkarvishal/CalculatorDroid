package com.example.jagermeister.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener
{
    private enum OPERATOR { ADD,SUB,MUL,DIV,EQUAL  }
    TextView txtClac;
    TextView txtResults;

    private String currentNum;
    private String NumAtleft;
    private String NumAtRight;
    private OPERATOR currentOperator;
    private int calculationResult;
    private String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        currentNum = "";
        calculationResult = 0;
        calculationString = "";

        txtClac = findViewById(R.id.txtClac);
        txtResults = findViewById(R.id.txtResults);

        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnAdd).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSub).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMul).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDiv).setOnClickListener(Calculator.this);
        findViewById(R.id.btnC).setOnClickListener(Calculator.this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btn9: numberIsTapped(9);  break;
            case R.id.btn8: numberIsTapped(8);  break;
            case R.id.btn7: numberIsTapped(7);  break;
            case R.id.btn6: numberIsTapped(6);  break;
            case R.id.btn5: numberIsTapped(5);  break;
            case R.id.btn4: numberIsTapped(4);  break;
            case R.id.btn3: numberIsTapped(3);  break;
            case R.id.btn2: numberIsTapped(2);  break;
            case R.id.btn1: numberIsTapped(1);  break;
            case R.id.btn0: numberIsTapped(0);  break;
            case R.id.btnAdd:
                operatorIsTapped(OPERATOR.ADD);
                calculationString += " + ";
                break;
            case R.id.btnSub:
                operatorIsTapped(OPERATOR.SUB);
                calculationString += " - ";
                break;
            case R.id.btnMul:
                operatorIsTapped(OPERATOR.MUL);
                calculationString += " * ";
                break;
            case R.id.btnDiv:
                operatorIsTapped(OPERATOR.DIV);
                calculationString += " / ";
                break;
            case R.id.btnC:
                clearTapped();
                break;

        }
        txtClac.setText(calculationString);
    }

    private void numberIsTapped(int tappedNumber)
    {
        currentNum = currentNum + String.valueOf(tappedNumber);
        txtResults.setText(currentNum);
        calculationString = currentNum;
        txtClac.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator)
    {
        if (currentOperator != null)
        {
            if (currentNum != "") {

                NumAtRight = currentNum;
                currentNum = "";
                switch (currentOperator) {
                    case ADD:
                        calculationResult = Integer.parseInt(NumAtleft) + Integer.parseInt(NumAtRight);
                        break;
                    case SUB:
                        calculationResult = Integer.parseInt(NumAtleft) - Integer.parseInt(NumAtRight);
                        break;
                    case MUL:
                        calculationResult = Integer.parseInt(NumAtleft) * Integer.parseInt(NumAtRight);
                        break;
                    case DIV:
                        calculationResult = Integer.parseInt(NumAtleft) / Integer.parseInt(NumAtRight);
                        break;
                }
                NumAtleft = String.valueOf(calculationResult);
                txtResults.setText(NumAtleft);
                calculationString = NumAtleft;
            }
        }
        else
        {
            NumAtleft = currentNum;
            currentNum = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        NumAtleft = "";
        NumAtRight = "";
        calculationResult = 0;
        currentNum = "";
        currentOperator = null;
        txtResults.setText("0");
        calculationString = "0.0";
        //txtClac.setText("0.0");

    }
}