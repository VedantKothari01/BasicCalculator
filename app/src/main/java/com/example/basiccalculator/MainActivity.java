package com.example.basiccalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;
    private Spinner operators;
    private TextView resultTextView;
    private Button equalButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_BasicCalculator);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        operators = findViewById(R.id.operators);
        resultTextView = findViewById(R.id.result);
        equalButton = findViewById(R.id.equal);
        clearButton = findViewById(R.id.clear);

        // Initialize the spinner with the operators array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operators_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operators.setAdapter(adapter);

        Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(v -> {
            vibrate();
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        equalButton.setOnClickListener(v -> {
            vibrate();
            // Perform the calculation
            String result = calculate();

            // Update the result TextView with animation
            resultTextView.setText(result);
            resultTextView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in));

            // Show feedback
            Snackbar.make(v, "Calculation done", Snackbar.LENGTH_SHORT).show();
        });

        clearButton.setOnClickListener(v -> {
            vibrate();
            clearFields();
        });

        // Set touch listener on the root view to hide keyboard when touching outside EditTexts
        ConstraintLayout mainLayout = findViewById(R.id.main);
        mainLayout.setOnTouchListener((v, event) -> {
            hideKeyboard();
            if (event.getAction() == MotionEvent.ACTION_UP) {
                v.performClick();
            }
            return false;
        });
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null && vibrator.hasVibrator()) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(50);
            }
        }
    }

    private String calculate() {
        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(number1.getText().toString());
            num2 = Double.parseDouble(number2.getText().toString());
        } catch (NumberFormatException e) {
            return "Invalid input";
        }

        String operator = operators.getSelectedItem().toString();
        double result;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    return "Cannot divide by zero";
                }
                break;
            default:
                return "Invalid operator";
        }

        // Check if both inputs and the result are integers
        if (isInteger(num1) && isInteger(num2) && isInteger(result)) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    private boolean isInteger(double number) {
        return number == (int) number;
    }

    // Method to clear the input fields and result
    private void clearFields() {
        number1.setText("");
        number2.setText("");
        resultTextView.setText("");
    }

    // Method to hide the keyboard
    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
