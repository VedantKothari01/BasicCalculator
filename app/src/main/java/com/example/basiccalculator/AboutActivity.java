package com.example.basiccalculator;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class AboutActivity extends AppCompatActivity {

    private boolean isHeartFilled = false;
    private ImageButton heartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        heartButton = findViewById(R.id.heart_button);
        heartButton.setOnClickListener(v -> {
            vibrate();
            toggleHeart();
            showFeedback(v);
        });

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            vibrate();
            finish();
        });
    }

    private void toggleHeart() {
        if (isHeartFilled) {
            heartButton.setImageResource(R.drawable.ic_heart_outline);
        } else {
            heartButton.setImageResource(R.drawable.ic_heart_filled);
        }
        isHeartFilled = !isHeartFilled;
    }

    private void showFeedback(View view) {
        String message = isHeartFilled ? "Thank you for your support!" : "Support removed";
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        }
    }
}
