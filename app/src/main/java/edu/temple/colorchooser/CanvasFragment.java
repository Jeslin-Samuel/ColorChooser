package edu.temple.colorchooser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CanvasFragment extends Fragment
{
    public static final String ARG_COLOR = "argColor";

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
        return view;
    }
}
