package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bai4Activity extends AppCompatActivity {
    EditText edtListNumber;
    EditText edtOddNumber;
    EditText edtEvenNumber;
    Button btnRandom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        edtListNumber = findViewById(R.id.edtListNumber);
        edtOddNumber = findViewById(R.id.edtOddNumber);
        edtEvenNumber = findViewById(R.id.edtEvenNumber);
        btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(v -> handleArrayListNumbers());
    }
    private void handleArrayListNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        edtListNumber.setText(numbers.toString());
        edtEvenNumber.setText(evenNumbers.toString());
        edtOddNumber.setText(oddNumbers.toString());

        Log.d("EvenNumbers", "Số chẵn: " + evenNumbers);
        Log.d("OddNumbers", "Số lẻ: " + oddNumbers);
    }

}
