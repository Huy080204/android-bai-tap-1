package com.example.baitap01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai5Activity extends AppCompatActivity {
    EditText edtInput;
    TextView tvResult;
    Button btnReverse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai5);
        edtInput = findViewById(R.id.edtInput);
        tvResult = findViewById(R.id.tvResult);
        btnReverse = findViewById(R.id.btnReverse);
        btnReverse.setOnClickListener(v -> handleStringReverse());
    }

    private void handleStringReverse() {
        String input = edtInput.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(Bai5Activity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
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

            Toast.makeText(Bai5Activity.this, "Chuỗi đảo ngược: " + reversed, Toast.LENGTH_SHORT).show();
        }
    }
}
