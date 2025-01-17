package com.example.baitap01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnBai4;
    EditText edtInput;
    TextView tvResult;
    Button btnBai5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBai4 = findViewById(R.id.btnBai4);
        btnBai4.setOnClickListener(v -> handleArrayListNumbers());

        edtInput = findViewById(R.id.edtInput);
        tvResult = findViewById(R.id.tvResult);
        btnBai5 = findViewById(R.id.btnBai5);

        btnBai5.setOnClickListener(v -> {
            handleStringReverse();
        });


    }
    private void handleArrayListNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100) + 1;
            numbers.add(randomNumber);
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        Log.d("EvenNumbers", "Số chẵn: " + evenNumbers);
        Log.d("OddNumbers", "Số lẻ: " + oddNumbers);
    }

    private void handleStringReverse() {
        String input = edtInput.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
        } else {
            String[] words = input.split(" ");
            StringBuilder reversed = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                reversed.append(words[i].toUpperCase());
                if (i > 0) {
                    reversed.append(" ");
                }
            }

            tvResult.setText(reversed.toString());

            Toast.makeText(MainActivity.this, "Chuỗi đảo ngược: " + reversed, Toast.LENGTH_SHORT).show();
        }
    }
}