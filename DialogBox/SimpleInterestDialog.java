package com.example.myapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SimpleInterestDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_simple_interest, null);
        EditText principalEdit = view.findViewById(R.id.principal);
        EditText rateEdit = view.findViewById(R.id.rate);
        EditText timeEdit = view.findViewById(R.id.time);
        Button calculateButton = view.findViewById(R.id.calculate_button);
        TextView resultText = view.findViewById(R.id.result_text);

        calculateButton.setOnClickListener(v -> {
            try {
                double principal = Double.parseDouble(principalEdit.getText().toString());
                double rate = Double.parseDouble(rateEdit.getText().toString());
                double time = Double.parseDouble(timeEdit.getText().toString());
                double si = (principal * rate * time) / 100;
                resultText.setText("Simple Interest: " + si);
            } catch (NumberFormatException e) {
                resultText.setText("Invalid input");
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Calculate Simple Interest")
                .setNegativeButton("Close", null)
                .create();
    }
}
