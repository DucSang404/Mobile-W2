package com.example.assignment1v2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private EditText numberInput;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        numberInput = findViewById(R.id.numberInput);
        checkButton = findViewById(R.id.checkButton);
        resultTextView = findViewById(R.id.resultTextView);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = numberInput.getText().toString().trim();

                if (inputText.isEmpty()) {
                    Toast.makeText(ThirdActivity.this, "Vui lòng nhập số phần tử", Toast.LENGTH_SHORT).show();
                    return;
                }

                int numberOfElements = Integer.parseInt(inputText);
                String result = getPerfectSquares(numberOfElements);
                resultTextView.setText(result);
            }
        });
    }

    private String getPerfectSquares(int numberOfElements) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 1; i * i < 1000; i++) {
            if (count >= numberOfElements) {
                break;
            }
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(i * i);
            count++;
        }


        if (count == 0) {
            result.append("Không có số chính phương nào.");
        }

        return result.toString();
    }
}
