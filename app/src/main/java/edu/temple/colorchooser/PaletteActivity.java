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

        final String colorNames[] = getResources().getStringArray(R.array.colors);
        final String colorValues[] = getResources().getStringArray(R.array.color_values);

        /* Fragment section begin */

        PaletteFragment paletteFragment;

        paletteFragment = PaletteFragment.newInstance(colorNames, colorValues);
        getSupportFragmentManager().beginTransaction().replace(R.id.myLayout, paletteFragment).commit();

        /* Fragment section end*/
    }

    @Override
    public void sendColor(String color)
    {
        CanvasFragment canvasFragment = CanvasFragment.newInstance(color);
        getSupportFragmentManager().beginTransaction().add(R.id.myLayout, canvasFragment).addToBackStack(null).commit();
    }
}
