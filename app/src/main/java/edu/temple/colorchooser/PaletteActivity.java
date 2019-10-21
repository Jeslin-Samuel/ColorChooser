package edu.temple.colorchooser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Locale;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Test
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.palette_label));

        Spinner spinner = findViewById(R.id.ListofColors);
        final ConstraintLayout layout = findViewById(R.id.myLayout);
        final String colorNames[] = getResources().getStringArray(R.array.colors);
        final String colorValues[] = getResources().getStringArray(R.array.color_values);

        ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colorNames, colorValues);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (i > 0)
                {
                    Intent launchIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    launchIntent.putExtra("color", colorValues[i]);
                    startActivity(launchIntent);
                }
                else
                    layout.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}
