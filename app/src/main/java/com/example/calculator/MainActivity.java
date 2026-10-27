package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int[] DIGIT_IDS = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
    };

    private final CalculatorEngine engine = new CalculatorEngine();
    private TextView tvExpression;
    private TextView tvDisplay;

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

        tvExpression = findViewById(R.id.tvExpression);
        tvDisplay = findViewById(R.id.tvDisplay);

        for (int i = 0; i < DIGIT_IDS.length; i++) {
            final int digit = i;
            bind(DIGIT_IDS[i], () -> engine.inputDigit(digit));
        }
//        bind(R.id.btnAdd, engine::add);
//        bind(R.id.btnEquals, engine::calculate);
    }

    private void bind(int id, Runnable action) {
        findViewById(id).setOnClickListener(v -> {action.run(); updateScreen(); });
    }

    private void updateScreen() {
        tvDisplay.setText(engine.getDisplay());
//        tvExpression.setText(engine.getExpression());
    }
}