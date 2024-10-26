package com.example.midtermfouzanahmed;

import android.app.Fragment;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.example.midtermfouzanahmed.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText radiusInput;
    private TextView areaOutput;
    private static final String TAG = "TAG";

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radiusInput = binding.editTextRadius;
        areaOutput = binding.textViewForArea;

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radiusStr = radiusInput.getText().toString().trim();

                if (radiusStr.isEmpty()) {
                    areaOutput.setText("Please enter radius.");
                    Log.i(TAG,"Cant be empty");
                    return;
                }

                try {
                    double radiusInput = Double.parseDouble(radiusStr);
                    double area = 3.14 * radiusInput * radiusInput;
                    areaOutput.setText(String.format("%.2f area", area));
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