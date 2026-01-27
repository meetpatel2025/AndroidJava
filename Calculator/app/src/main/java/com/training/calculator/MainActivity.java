package com.training.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button  number0, number1, number2, number3, number4, number5, number6, number7, number8, number9;
    EditText resultText;
    double num1=0;
    String current="";
    String operation="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void numberClick(View v){
        Button b = (Button) v;
        current += b.getText().toString();
        resultText.setText(current);
    }

    public void mathOperation(View v){
        Button b = (Button) v;
        num1 = Double.parseDouble(current);
        operation += b.getText().toString();
        current = "";
    }

    public void equalsClick(View view) {
        double num2 = Double.parseDouble(current);
        double result = 0;

        switch(operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
        }

        resultText.setText(String.valueOf(result));
        current = "";
    }

    public void clearClick(View view) {
        current = "";
        resultText.setText("0");
    }

    public void ceClick(View view) {
        resultText.setText("0");
    }


}