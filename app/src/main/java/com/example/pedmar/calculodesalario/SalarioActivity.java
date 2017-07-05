package com.example.pedmar.calculodesalario;

import android.support.v7.app.*;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.widget.*;
import android.view.*;
import android.app.*;

public class SalarioActivity extends AppCompatActivity {
    RadioGroup rgopcoes;
    Button btcalcular;
    EditText edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);
        edSalario = (EditText) findViewById(R.id.edtSalario);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        btcalcular = (Button) findViewById(R.id.btCalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salario = Double.parseDouble(edSalario.getText().toString());
                int op = rgopcoes.getCheckedRadioButtonId();
                double novo_salario = 0.0;

                if(op == R.id.rb40)
                    novo_salario = salario + (salario * 0.4);
                else if (op == R.id.rb45)
                    novo_salario = salario + (salario * 0.45);
                else
                    novo_salario = salario + (salario * 0.5);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(SalarioActivity.this);
                dialogo.setTitle("Informaçaão de salário");
                dialogo.setMessage("Novo salário = " + String.valueOf(novo_salario));
                dialogo.setNeutralButton("Ok", null);
                AlertDialog show = dialogo.show();
            }
        });
    }
}
