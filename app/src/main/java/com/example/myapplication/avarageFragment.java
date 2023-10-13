package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

public class avarageFragment extends Fragment {
    public avarageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avarage, container, false);

        TextView resultado = view.findViewById(R.id.resultado);
        EditText nota1 = view.findViewById(R.id.nota1);
        EditText nota2 = view.findViewById(R.id.nota2);
        EditText nota3 = view.findViewById(R.id.nota3);
        Button calculateButton = view.findViewById(R.id.button2);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float nota01 = Float.parseFloat(nota1.getText().toString());
                float nota02 = Float.parseFloat(nota2.getText().toString());
                float nota03 = Float.parseFloat(nota3.getText().toString());
                float media = (nota01+nota02+nota03)/3;

                if (media >= 7) {
                    resultado.setText("Aprovado: " + media);
                } else if (media < 7 && media >= 5) {
                    resultado.setText("Aprovado por nota: " + media);
                } else if (media < 5 && media >= 3) {
                    resultado.setText("Recuperação: " + media);
                } else {
                    resultado.setText("Reprovado: " + media);
                }
            }
        });

        return view;
    }

}