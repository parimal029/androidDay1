package com.example.bmiapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etHeight, etWeight, etbmi;
    TextView etRem;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText) findViewById(R.id.heighgt);
        etWeight = (EditText) findViewById(R.id.wight);
        etbmi = (EditText) findViewById(R.id.etbmi);
        etRem = (TextView) findViewById(R.id.rem);
        btnCalculate = (Button) findViewById(R.id.button);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height = Integer.parseInt(etHeight.getText().toString());
                int weight = Integer.parseInt(etWeight.getText().toString());
                double heightm = (double) height/100;
                double Bmi = weight / (heightm*heightm);
                Double bmi = new Double(Bmi);
                etbmi.setText(bmi.toString());
                String cat;
                if (Bmi > 30) {
                    cat = "Obesity";
                    etRem.setText(cat);
                } else if (Bmi < 30 && Bmi > 25) {
                    cat = "Overweight";
                    etRem.setText(cat);
                } else if (Bmi < 25 && Bmi > 18.5) {
                    cat = "Normal weight";
                    etRem.setText(cat);
                } else {
                    cat = "Under Weight";
                    etRem.setText(cat);

                }
            }
        });
    }
}