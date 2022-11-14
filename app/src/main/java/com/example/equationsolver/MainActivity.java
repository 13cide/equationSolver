package com.example.equationsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Edita;
    private EditText Editb;
    private EditText Editc;

    private TextView x1;
    private TextView x2;

    private Switch switcher;
    private Button button;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edita = findViewById(R.id.textA);
        Editb = findViewById(R.id.textB);
        Editc = findViewById(R.id.textC);

        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);

        switcher = findViewById(R.id.switcher);
        button = findViewById(R.id.button);
        layout = findViewById(R.id.lay);
    }

    public void mode(View view) {
        if (switcher.isChecked()) {
            switcher.setText("\uD83C\uDF1A");
            layout.setBackgroundResource(R.drawable.night_background);
            button.setBackgroundColor(Color.parseColor("#0D51C6"));
        }
        else {
            switcher.setText("\uD83C\uDF1E");
            layout.setBackgroundResource(R.drawable.day_background);
            button.setBackgroundColor(Color.parseColor("#67CD1F"));
        }
    }

    public void click(View view) {
        Edita.setBackgroundColor(Color.parseColor("#00000000"));
        Editb.setBackgroundColor(Color.parseColor("#00000000"));
        Editc.setBackgroundColor(Color.parseColor("#00000000"));

        String Texta = Edita.getText().toString();
        String Textb = Editb.getText().toString();
        String Textc = Editc.getText().toString();
        if (Texta.isEmpty() || Textb.isEmpty() || Textc.isEmpty()) {
            Toast.makeText(this, "Не все аргументы введены", Toast.LENGTH_SHORT).show();
            if (Texta.isEmpty()) {
                Edita.setBackgroundColor(Color.parseColor("#CF1616"));
            }
            if (Textb.isEmpty()) {
                Editb.setBackgroundColor(Color.parseColor("#CF1616"));
            }
            if (Textc.isEmpty()) {
                Editc.setBackgroundColor(Color.parseColor("#CF1616"));
            }
        }
        else {

            double a = Double.parseDouble(Texta);
            double b = Double.parseDouble(Textb);
            double c = Double.parseDouble(Textc);

            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        x1.setText("Ты что, тупой? Все коэфиценты по 0? Правда непонятно, какой результат?");
                        x2.setText("x - любое число, идиот");
                    }
                    else {
                        x1.setText("Решений не существует");
                        x2.setText("");
                    }
                }
                else if (c == 0) {
                    x1.setText("x = 0");
                    x2.setText("");
                }
                else {
                    double x = (-c) / b;
                    x1.setText("x = " + x);
                    x2.setText("");
                }
            }
            else if (b == 0) {
                if (c == 0) {
                    x1.setText("x = 0");
                    x2.setText("");
                }
                else {
                    if (c > 0) {
                        x1.setText("Решений не существует");
                        x2.setText("");
                    }
                    else {
                        double firstX = Math.sqrt((-c)/a);
                        double secondX = -Math.sqrt((-c)/a);
                        x1.setText("x1 = " + firstX);
                        x2.setText("x2 = " + secondX);
                    }
                }
            }
            else if (c == 0) {
                double x = (-b)/a;
                x1.setText("x1 = 0");
                x2.setText("x2 = " + x);
            }
            else {
                double d = b*b - 4*a*c;
                if (d < 0) {
                    x1.setText("Решений не существует");
                    x2.setText("");
                }
                else if (d == 0) {
                    double x = (-b) / (2*a);
                    x1.setText("x = " + x);
                    x2.setText("");
                }
                else {
                    double firstX = ((-b) + Math.sqrt(d)) / (2*a);
                    double secondX = ((-b) - Math.sqrt(d)) / (2*a);
                    x1.setText("x1 = " + firstX);
                    x2.setText("x2 = " + secondX);
                }
            }
        }
    }
}