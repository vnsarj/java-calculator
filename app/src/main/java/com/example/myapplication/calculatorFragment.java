package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class calculatorFragment extends Fragment {

    double num1 = 0;
    double num2 = 0;
    String operator = "";


    public calculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        Button bt01 = view.findViewById(R.id.bt01);
        Button bt02 = view.findViewById(R.id.bt02);
        Button bt03 = view.findViewById(R.id.bt03);
        Button bt04 = view.findViewById(R.id.bt04);
        Button bt05 = view.findViewById(R.id.bt05);
        Button bt06 = view.findViewById(R.id.bt06);
        Button bt07 = view.findViewById(R.id.bt07);
        Button bt08 = view.findViewById(R.id.bt08);
        Button bt09 = view.findViewById(R.id.bt09);
        Button bt0 = view.findViewById(R.id.bt0);
        Button btSoma = view.findViewById(R.id.btSoma);
        Button btSub = view.findViewById(R.id.btSub);
        Button btDel = view.findViewById(R.id.btDel);
        Button btX = view.findViewById(R.id.btX);
        Button btDiv= view.findViewById(R.id.btDiv);
        Button btIgual= view.findViewById(R.id.btIgual);
        TextView operation = view.findViewById(R.id.operation);
        TextView total = view.findViewById(R.id.total);

        bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("1");
            }
        });

        bt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("2");
            }
        });

        bt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("3");
            }
        });

        bt04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("4");
            }
        });

        bt05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("5");
            }
        });

        bt06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("6");
            }
        });

        bt07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("7");
            }
        });

        bt08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("8");
            }
        });

        bt09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("9");
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.append("0");
            }
        });

        btSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.length() > 0) {
                    num1 = Double.parseDouble(operation.getText().toString());
                    operator = "+";
                    operation.append("+");
                }
            }
        });

        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.length() > 0) {
                    num1 = Double.parseDouble(operation.getText().toString());
                    operator = "-";
                    operation.append("-");
                }
            }
        });

        btX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.length() > 0) {
                    num1 = Double.parseDouble(operation.getText().toString());
                    operator = "*";
                    operation.append("*");
                }
            }
        });

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.length() > 0) {
                    num1 = Double.parseDouble(operation.getText().toString());
                    operator = "/";
                    operation.append("/");
                }
            }
        });

        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText("");
                num1 = 0;
                num2 = 0;
                operator = "";
            }
        });

        btIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator.length() > 0 && operation.length() > 0) {
                    String[] parts = operation.getText().toString().split(Pattern.quote(operator));
                    if (parts.length == 2) {
                        num2 = Double.parseDouble(parts[1]);
                        double result = 0;
                        switch (operator) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                if (num2 != 0) {
                                    result = num1 / num2;
                                } else {
                                    Toast.makeText(getContext(), "Divisão por zero!", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                break;
                        }
                        total.setText(String.valueOf(result));
                    }
                }
            }
        });

        return view;
    }
}