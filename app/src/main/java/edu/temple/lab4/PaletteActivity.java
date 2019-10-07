package edu.temple.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.ListofColors);
        final ConstraintLayout layout = findViewById(R.id.myLayout);

        final String colors[] = {"Select A Color", "Green", "Red", "Blue", "Yellow", "Cyan", "Magenta", "Black", "Gray",
                "LightGray", "DarkGray"};

        ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (i > 0)
                {
                    view.setBackgroundColor(Color.WHITE);
                    layout.setBackgroundColor(Color.parseColor(colors[i]));
                }
                else
                    layout.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
