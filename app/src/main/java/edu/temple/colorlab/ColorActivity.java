package edu.temple.colorlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.ListofColors);

        String colors[] = {"Green", "Red", "Blue", "Yellow", "Cyan", "Magenta", "Black", "Gray",
                "LightGray", "DarkGray"};

        ColorAdapter adapter = new ColorAdapter(ColorActivity.this, colors);

        spinner.setAdapter(adapter);
    }
}
