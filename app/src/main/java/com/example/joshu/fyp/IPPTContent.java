package com.example.joshu.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class IPPTContent extends AppCompatActivity {

    CardView ipptCalculator, ipptResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipptcontent);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        ipptCalculator = findViewById(R.id.cardview_ipptCalculator);
        ipptResult = findViewById(R.id.cardview_ipptResult);

        setIpptCalculator();
        setIpptResult();
    }

    public void setIpptCalculator(){

        ipptCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectAgeGroup.class);
                startActivity(intent);
            }
        });
    }

    public void setIpptResult(){

        ipptResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewIPPT.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
