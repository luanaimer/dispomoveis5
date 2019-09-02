package br.edu.ifsc.imc_luana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edPeso, edAltura;
    String peso, altura;
    Button button;
    TextView imcLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPeso = findViewById(R.id.pesoEdit);
        edAltura = findViewById(R.id.alturaEdit);
        button = findViewById(R.id.calcImc);

        imcLabel = findViewById(R.id.imcLabel);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peso = edPeso.getText().toString();
                altura = edAltura.getText().toString();
                calculaIMC(Double.parseDouble(peso), Double.parseDouble(altura));
            }
        });
    }

    public void calculaIMC(double peso, double altura) {

        String calculo = String.valueOf(peso / (altura * altura));

        imcLabel.setText(calculo);

    }

    public void openCredito(View view) {
        Intent i = new Intent(this, CreditosActivity.class);

        startActivity(i);
    }
}
