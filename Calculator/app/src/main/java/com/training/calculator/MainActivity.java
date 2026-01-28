package com.training.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    String calculation="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });
        resultText = findViewById(R.id.resultText);
        resultText.setText("0");
    }
    public void numberClick(View v){
        Button b = (Button) v;
        String text = b.getText().toString();

        if(current.equals("0") && !current.equals(".")){
            current = "";
        }
        if(text.equals(".")){
            if(current.isEmpty()){
                current = "0";
            }else if(current.contains(".")){
                current +=".";
            }
        }else{
            current +=text;
        }

//        current += b.getText().toString();
        resultText.setText(calculation.concat(current));
    }

    public void mathOperation(View v){
        Button b = (Button) v;
        num1 = Double.parseDouble(current);
        operation = b.getText().toString();
        calculation = current.concat(operation);
        resultText.setText(calculation);
        current = "";
    }

    public void equalsClick(View view) {
        double num2 = Double.parseDouble(current);
        double result = 0;
//        resultText.setText(calculation.concat(String.valueOf(num2)));
        switch(operation) {
            case "+": {
                result = num1 + num2;
                break;
            }
            case "-": {
                result = num1 - num2;
                break;
            }
            case "*": {
                result = num1 * num2;
                break;
            }
            case "/": {
                if(num2 ==0){
                    Toast.makeText(this, "Can't devide by zeo", Toast.LENGTH_SHORT).show();
                    current = "";
                    operation = "";
                    return;

                }
                result = num1 / num2;
                break;
            }
        }

        resultText.setText(String.valueOf(result));
        current = "";
        calculation="";
    }

    public void clearClick(View view) {
        current = "";
        operation = "";
        calculation="";
        num1 = 0;
        resultText.setText("0");
    }

    public void ceClick(View view) {
        current = "";
        operation = "";
        calculation="";
        num1 = 0;
        resultText.setText("0");
    }


}