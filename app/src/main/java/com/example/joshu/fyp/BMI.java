package com.example.joshu.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    EditText eHeight , eWeight;
    TextView results, status;
    Button calulate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        eHeight = findViewById(R.id.txt_height);
        eWeight = findViewById(R.id.txt_weight);
        results = findViewById(R.id.txt_result);
        calulate = findViewById(R.id.btn_BmiCal);
        status = findViewById(R.id.txt_status);

        calulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    double bmi;
                    double height;
                    double weight;

                    height = Double.parseDouble(eHeight.getText().toString());
                    weight = Double.parseDouble(eWeight.getText().toString());

                    bmi = weight / (height * height);

                    results.setText(String.format("%.1f", bmi).toString());

                    if (bmi > 27.5) {
                        status.setText("You are severely overweight");
                        status.setTextColor(getResources().getColor(R.color.Red));
                        results.setTextColor(getResources().getColor(R.color.Red));
                    } else if (bmi > 23) {
                        status.setText("You are overweight");
                        status.setTextColor(getResources().getColor(R.color.Orange));
                        results.setTextColor(getResources().getColor(R.color.Orange));
                    } else if (bmi > 18.5) {
                        status.setText("You are healthy");
                        status.setTextColor(getResources().getColor(R.color.Green));
                        results.setTextColor(getResources().getColor(R.color.Green));
                    } else {
                        status.setText("You are underweight");
                        status.setTextColor(getResources().getColor(R.color.Red));
                        results.setTextColor(getResources().getColor(R.color.Red));
                    }
                }
                catch (Exception e) {
                    Toast.makeText(BMI.this, "Please enter something", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
