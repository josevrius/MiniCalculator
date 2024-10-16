package org.jvrb.java.minicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView viewer;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonComa;
    Button buttonAdd;
    Button buttonSubtract;
    Button buttonMultiply;
    Button buttonSplit;
    Button buttonEqual;
    Button buttonAC;

    double memory;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        viewer = findViewById(R.id.textView);
        button0 = findViewById(R.id.btnNum0);
        button1 = findViewById(R.id.btnNum1);
        button2 = findViewById(R.id.btnNum2);
        button3 = findViewById(R.id.btnNum3);
        button4 = findViewById(R.id.btnNum4);
        button5 = findViewById(R.id.btnNum5);
        button6 = findViewById(R.id.btnNum6);
        button7 = findViewById(R.id.btnNum7);
        button8 = findViewById(R.id.btnNum8);
        button9 = findViewById(R.id.btnNum9);
        buttonComa = findViewById(R.id.btnComa);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonSubtract = findViewById(R.id.btnSubtract);
        buttonMultiply = findViewById(R.id.btnMultiply);
        buttonSplit = findViewById(R.id.btnSplit);
        buttonEqual = findViewById(R.id.btnEqual);
        buttonAC = findViewById(R.id.btnAC);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + "9");
            }
        });

        buttonComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText(getViewer() + ",");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateOperator();
                operator = '+';
                viewer.setText("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateOperator();
                operator = '-';
                viewer.setText("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateOperator();
                operator = '×';
                viewer.setText("×");
            }
        });

        buttonSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateOperator();
                operator = '÷';
                viewer.setText("÷");
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateOperator();
                operator = 0;

                if (String.valueOf(memory).endsWith(".0")) {
                    viewer.setText(String.valueOf((int) memory));
                } else {
                    viewer.setText(String.valueOf(memory).replace('.', ','));
                }
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewer.setText("0");
                memory = 0;
                operator = 0;
            }
        });
    }

    private String getViewer() {
        String text = viewer.getText().toString();

        if (text.equals("0") || text.equals("+") || text.equals("-") || text.equals("×") || text.equals("÷")) {
            text = "";
        }
        return text;
    }

    private double getNumericValue(String viewer) {
        double number = 0;

        try {
            number = Double.parseDouble(viewer.replace(',', '.'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return number;
    }

    private void evaluateOperator() {
        switch (operator) {
            case '+':
                memory = memory + getNumericValue(getViewer());
                break;
            case '-':
                memory = memory - getNumericValue(getViewer());
                break;
            case '×':
                memory = memory * getNumericValue(getViewer());
                break;
            case '÷':
                memory = memory / getNumericValue(getViewer());
                break;
            default:
                memory = getNumericValue(getViewer());
        }
    }
}