package com.example.cinek.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class ResultBmiActivity extends AppCompatActivity {

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);
        setupToolbar();
        changeBackgroundColor();
        setResultText();

    }

    private void setupToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void changeBackgroundColor() {
        Intent intent = getIntent();
        String result = intent.getStringExtra(MainActivity.EXTRA_BMI_RESULT);
        int colorCode = intent.getIntExtra(MainActivity.EXTRA_COLOR, 0);
        findViewById(R.id.bmi_screen).setBackgroundColor(colorCode);
    }

    private void setResultText() {
        Intent intent = getIntent();
        String result = intent.getStringExtra(MainActivity.EXTRA_BMI_RESULT);
        resultView = findViewById(R.id.resultView);
        resultView.setText(result);
    }

}
