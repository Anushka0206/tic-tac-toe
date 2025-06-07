package com.example.tictacto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
    }

    public void check(View view) {
        Button btnCurr = (Button) view;
        if (btnCurr.getText().toString().equals("")) {
            if (flag == 0) {
                btnCurr.setText("X");
                flag = 1;
            } else {
                btnCurr.setText("O");
                flag = 0;
            }
            checkWinner();
        }
    }

    private void checkWinner() {
        // Check rows
        if (checkLine(btn1, btn2, btn3) || checkLine(btn4, btn5, btn6) || checkLine(btn7, btn8, btn9)) {
            return;
        }

        // Check columns
        if (checkLine(btn1, btn4, btn7) || checkLine(btn2, btn5, btn8) || checkLine(btn3, btn6, btn9)) {
            return;
        }

        // Check diagonals
        if (checkLine(btn1, btn5, btn9) || checkLine(btn3, btn5, btn7)) {
            return;
        }
    }

    private boolean checkLine(Button btn1, Button btn2, Button btn3) {
        if (!btn1.getText().toString().equals("") &&
                btn1.getText().toString().equals(btn2.getText().toString()) &&
                btn2.getText().toString().equals(btn3.getText().toString())) {
            Toast.makeText(this, btn1.getText() + " wins!", Toast.LENGTH_SHORT).show();
            resetBoard();
            return true;
        }
        return false;
    }

    private void resetBoard() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
    }
}
