package edu.temple.colorchooser;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class PaletteFragment extends Fragment
{
    public static final String ARG_NAMES = "argNames";
    public static final String ARG_VALUES = "argValues";

    public String[] names;
    public String[] values;
    public Context parent;
    public FragmentCommunicator callback;

    public static PaletteFragment newInstance(String[] names, String[] values)
    {
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_NAMES, names);
        args.putStringArray(ARG_VALUES, values);
        paletteFragment.setArguments(args);
        return paletteFragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        this.parent = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette_layout, container, false);
        final ConstraintLayout layout = view.findViewById(R.id.paletteFragment_layout);
        Spinner spinner = view.findViewById(R.id.ListOfColors);

        if (getArguments() != null)
        {
            names = getArguments().getStringArray(ARG_NAMES);
            values = getArguments().getStringArray(ARG_VALUES);
        }

        ColorAdapter adapter = new ColorAdapter(parent, names, values);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (i > 0)
                {
                    ((FragmentCommunicator) parent).sendColor(values[i]);
                }
                else
                    layout.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        return view;
    }

    public interface FragmentCommunicator
    {
        void sendColor(String color);
    }

    public void setFragmentCommunicator(FragmentCommunicator callback)
    {
        this.callback = callback;
    }
}
