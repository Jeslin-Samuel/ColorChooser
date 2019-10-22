package edu.temple.colorchooser;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class CanvasFragment extends Fragment
{
    public static final String ARG_COLOR = "argColor";

    public String color;

    public static CanvasFragment newInstance(String color)
    {
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COLOR, color);
        canvasFragment.setArguments(args);
        return canvasFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canvas_layout, container, false);
        ConstraintLayout layout = view.findViewById(R.id.canvasFragment_layout);

        if (getArguments() != null)
            color = getArguments().getString(ARG_COLOR);

        layout.setBackgroundColor(Color.parseColor(color));
        return view;
    }
}
