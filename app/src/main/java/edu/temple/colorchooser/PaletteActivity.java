package edu.temple.colorchooser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Locale;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.FragmentCommunicator{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.palette_label));

        Spinner spinner = findViewById(R.id.ListofColors);
        final ConstraintLayout layout = findViewById(R.id.myLayout);
        final String colorNames[] = getResources().getStringArray(R.array.colors);
        final String colorValues[] = getResources().getStringArray(R.array.color_values);

        /* Fragment section begin */

        PaletteFragment paletteFragment = PaletteFragment.newInstance(colorNames, colorValues);
        getSupportFragmentManager().beginTransaction().replace(R.id.myLayout, paletteFragment).commit();

        /* Fragment section end*/

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

    @Override
    public void sendColor(String color)
    {
        CanvasFragment canvasFragment = CanvasFragment.newInstance(color);
        getSupportFragmentManager().beginTransaction().replace(R.id.myLayout, canvasFragment).addToBackStack(null).commit();
    }
}
