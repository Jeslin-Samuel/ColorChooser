package edu.temple.colorchooser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

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
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof PaletteFragment) {
            PaletteFragment paletteFragment = (PaletteFragment) fragment;
            paletteFragment.setFragmentCommunicator(this);
        }
        else
            throw new RuntimeException("Need to implement the FragmentCommunicator interface!");
    }

    @Override
    public void sendColor(String color)
    {
        CanvasFragment canvasFragment = CanvasFragment.newInstance(color);
        getSupportFragmentManager().beginTransaction().add(R.id.myLayout, canvasFragment).addToBackStack(null).commit();
    }
}
