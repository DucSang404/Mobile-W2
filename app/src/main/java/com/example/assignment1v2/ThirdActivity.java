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
    private TextView resultTextView;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        numberInput = findViewById(R.id.numberInput);
        resultTextView = findViewById(R.id.resultTextView);
        checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = numberInput.getText().toString();
                if (!inputText.isEmpty()) {
                    int numberOfElements = Integer.parseInt(inputText);
                    ArrayList<Integer> numbers = new ArrayList<>();

                    for (int i = 1; i <= numberOfElements; i++) {
                        numbers.add(i);
                    }

                    ArrayList<Integer> perfectSquares = new ArrayList<>();
                    for (int num : numbers) {
                        if (isPerfectSquare(num)) {
                            perfectSquares.add(num);
                            Toast.makeText(ThirdActivity.this, "Số chính phương: " + num, Toast.LENGTH_SHORT).show();
                        }
                    }

                    if (perfectSquares.isEmpty()) {
                        resultTextView.setText("Không có số chính phương");
                    } else {
                        resultTextView.setText("Số chính phương: " + perfectSquares.toString());
                    }
                } else {
                    Toast.makeText(ThirdActivity.this, "Vui lòng nhập số phần tử!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return number == sqrt * sqrt;
    }
}
