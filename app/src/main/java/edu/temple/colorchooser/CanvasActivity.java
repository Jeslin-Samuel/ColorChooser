package edu.temple.colorchooser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        ConstraintLayout canvasLayout = findViewById(R.id.CanvasLayout);
        Intent getLaunchIntent = getIntent();
        String color = getLaunchIntent.getStringExtra("color");
        canvasLayout.setBackgroundColor(Color.parseColor(color));
    }
}
