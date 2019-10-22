package edu.temple.colorchooser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PaletteFragment extends Fragment
{
    public static final String ARG_COLORS = "argColors";

    public static PaletteFragment newInstance(String[] colors)
    {
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_COLORS, colors);
        paletteFragment.setArguments(args);
        return paletteFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette_layout, container, false);
        return view;
    }
}
