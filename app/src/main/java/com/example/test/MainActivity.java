package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView rs;
    EditText N1,N2;

    float result;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btnplus);
        b2 = findViewById(R.id.btnmin);
        b3 = findViewById(R.id.btnmulti);
        b4 = findViewById(R.id.btndiv);

        rs = findViewById(R.id.result);
        N1 = findViewById(R.id.number1);
        N2 = findViewById(R.id.number2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = Integer.parseInt(N1.getText().toString());
                num2 = Integer.parseInt(N2.getText().toString());

                result = num1 + num2;

                rs.setText(String.valueOf(result));

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = Integer.parseInt(N1.getText().toString());
                num2 = Integer.parseInt(N2.getText().toString());

                result = num1 - num2;

                rs.setText(String.valueOf(result));

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = Integer.parseInt(N1.getText().toString());
                num2 = Integer.parseInt(N2.getText().toString());

                result = num1 * num2;

                rs.setText(String.valueOf(result));

            }
        });

        /*b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = Integer.parseInt(N1.getText().toString());
                num2 = Integer.parseInt(N2.getText().toString());

                result = num1 / num2;

                rs.setText(String.valueOf(result));

            }
        });*/

        //Updated
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = N1.getText().toString();
                String num2Str = N2.getText().toString();

                // Input validation (prevent crashes for empty or non-numeric input)

                Context context = null;
                if (num1Str.isEmpty() || num2Str.isEmpty()) {
                    // Handle empty input (e.g., display a toast message)
                    Toast.makeText(context, "Please enter both numbers.", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int num1 = Integer.parseInt(num1Str);
                    int num2 = Integer.parseInt(num2Str);

                    // Safe division handling division by zero
                    if (num2 == 0) {
                        Toast.makeText(context, "Cannot divide by zero.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double result = (double) num1 / num2; // Use double for potentially decimal results
                    String formattedResult = String.format("%.2f", result);
                    rs.setText(formattedResult);
                } catch (NumberFormatException e) {
                    // Handle non-numeric input (e.g., display a toast message)
                    Toast.makeText(context, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}