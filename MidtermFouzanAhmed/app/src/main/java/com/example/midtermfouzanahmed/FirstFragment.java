package com.example.midtermfouzanahmed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.midtermfouzanahmed.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText radiusInput;
    private TextView areaOutput;
    private static final String TAG = "TAG";
    private static final double PI = 3.14;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radiusInput = binding.editTextRadius; // Assuming you renamed this EditText for radius
        areaOutput = binding.textViewForArea; // Assuming you renamed this TextView for area output

        binding.buttonCalculateArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radiusStr = radiusInput.getText().toString().trim();

                if (radiusStr.isEmpty()) {
                    areaOutput.setText("Please enter the radius.");
                    Log.i(TAG, "Radius cannot be empty");
                    return;
                }

                try {
                    double radius = Double.parseDouble(radiusStr);
                    double area = PI * radius * radius;
                    areaOutput.setText(String.format("Area: %.2f", area));
                } catch (NumberFormatException e) {
                    areaOutput.setText("Invalid input. Please enter a valid number.");
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
