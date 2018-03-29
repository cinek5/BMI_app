package com.example.cinek.bmi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText massInput;
    private EditText heightInput;
    private Switch unitSwitch;
    private TextView massText;
    private TextView heightText;
    private Button countButton;
    public static final String EXTRA_BMI_RESULT = "result";
    public static final String EXTRA_COLOR = "color";
    public static final String SHARED_MASS_INPUT = "massInput";
    public static final String SHARED_HEIGHT_INPUT = "sharedInput";
    public static final String SHARED_IS_IMPERIAL_UNIT = "isImperialUnit";
    public static final String WRONG_INPUT_MESSAGE = "Wrong input. Check values you have typed.";
    boolean isImperialUnit = false;

    @Override
    protected void onStart() {
        super.onStart();
        restoreState();
    }

    private void saveState() {
        SharedPreferences myPreferences
                = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        if (!massInput.getText().toString().trim().equals("")) {
            myEditor.putFloat(SHARED_MASS_INPUT, Float.parseFloat(massInput.getText().toString()));
        } else {
            myEditor.putFloat(SHARED_MASS_INPUT, 0);
        }
        if (!heightInput.getText().toString().trim().equals("")) {
            myEditor.putFloat(SHARED_HEIGHT_INPUT, Float.parseFloat(heightInput.getText().toString()));
        } else {
            myEditor.putFloat(SHARED_HEIGHT_INPUT, 0);
        }
        myEditor.putBoolean(SHARED_IS_IMPERIAL_UNIT, isImperialUnit);
        myEditor.commit();


    }

    private void restoreState() {
        SharedPreferences myPreferences
                = getPreferences(Context.MODE_PRIVATE);
        isImperialUnit = myPreferences.getBoolean(SHARED_IS_IMPERIAL_UNIT, false);
        if (isImperialUnit) {
            switchUnitsToImperial();
            unitSwitch.setChecked(true);
        }
        float mass = myPreferences.getFloat(SHARED_MASS_INPUT, 0);
        float height = myPreferences.getFloat(SHARED_HEIGHT_INPUT, 0);
        if (mass != 0 && height != 0) {
            massInput.setText(String.valueOf(mass));
            heightInput.setText(String.valueOf(height));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupOnClickCountButtonListener();
        setupOnClickSwitchListener();


    }

    private void switchUnitsToImperial() {
        massText.setText(R.string.mass_lb);
        heightText.setText(R.string.height_ft);
        isImperialUnit = !isImperialUnit;
        heightInput.setText("");
        massInput.setText("");
    }

    private void switchUnitsToNormal() {
        massText.setText(R.string.mass_kg);
        heightText.setText(R.string.height_m);
        isImperialUnit = !isImperialUnit;
        heightInput.setText("");
        massInput.setText("");
    }



    private void setupViews() {
        massInput = findViewById(R.id.massInput);
        heightInput = findViewById(R.id.heightInput);
        countButton = findViewById(R.id.countButton);
        unitSwitch = findViewById(R.id.unitSwitch);
        massText = findViewById(R.id.massText);
        heightText = findViewById(R.id.heightText);
    }

    private void setupOnClickSwitchListener() {
        unitSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (unitSwitch.isChecked()) {
                    if (!isImperialUnit) {
                        switchUnitsToImperial();
                    }
                } else {
                    if (isImperialUnit) {
                        switchUnitsToNormal();
                    }

                }
            }
        });
    }

    private void setupOnClickCountButtonListener() {
        countButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               try {
                                                   double mass = Double.parseDouble(massInput.getText().toString());
                                                   double height = Double.parseDouble(heightInput.getText().toString());
                                                   BMI bmiCounter = isImperialUnit ? new BmiForImperial(mass, height) : new BmiForKg(mass, height);
                                                   double bmi = bmiCounter.countBMI();
                                                   int color = bmiCounter.getColorInt();
                                                   startDisplayBmiScreen(String.format("%.2f", bmi), color);
                                               } catch (IllegalArgumentException ex) {
                                                   Toast.makeText(view.getContext(), WRONG_INPUT_MESSAGE, Toast.LENGTH_SHORT).show();
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

    private void startAboutAuthorScreen() {
        Intent intent = new Intent(this, AboutAuthorActivity.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_about_author:
                startAboutAuthorScreen();

                return true;
            case R.id.action_save:
                saveState();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}