package com.example.assignment1v2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        Log.d("ArrayValues", "Mảng số: " + numbers.toString());

        for (int num : numbers) {
            if (isPrime(num)) {
                Log.d("PrimeNumber", "Số nguyên tố: " + num);
            }
        }

        if(numbers.isEmpty()) {
            Log.d("NonPrimeNumber", "Trong mảng không có số nguyên tố nào");
        }

        Button openThirdActivityButton = findViewById(R.id.openThirdActivityButton);

        openThirdActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
