package com.example.cinek.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private EditText massInput;
    private EditText heightInput;
    private Button countButton;
    public static final String EXTRA_BMI_RESULT = "result";
    public static final String EXTRA_COLOR = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupOnClickListener();


    }

    private void setupViews() {
        massInput = findViewById(R.id.massInput);
        heightInput = findViewById(R.id.heightInput);
        countButton = findViewById(R.id.countButton);
    }

    private void setupOnClickListener() {
        countButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               try {
                                                   double mass = Double.parseDouble(massInput.getText().toString());
                                                   double height = Double.parseDouble(heightInput.getText().toString());
                                                   BMI bmiCounter = new BmiForKg(mass, height) {
                                                   };
                                                   double bmi = bmiCounter.countBMI();
                                                   int color = bmiCounter.getColorInt();
                                                   startDisplayBmiScreen(String.format("%.2f", bmi), color);
                                               } catch (IllegalArgumentException ex) {
                                                   Toast.makeText(view.getContext(), "Wrong input", Toast.LENGTH_SHORT).show();
                                               }


                                           }
                                       }

        );
    }

    private void startDisplayBmiScreen(String resultBMI, int colorCode) {
        Intent intent = new Intent(this, ResultBmiActivity.class);
        intent.putExtra(EXTRA_BMI_RESULT, resultBMI);
        intent.putExtra(EXTRA_COLOR, colorCode);
        startActivity(intent);

    }


}