package com.example.suma2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText numero1, numero2;
    Button suma;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma= (Button)findViewById(R.id.btnSuma);
        suma.setOnClickListener(Sumar);
    }
    public View.OnClickListener Sumar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        CalculoSuma();
        }
    };
    public void CalculoSuma(){
        numero1=(EditText)findViewById(R.id.txtNum1);
        numero2=(EditText)findViewById(R.id.txtNum2);
        resultado=(TextView)findViewById(R.id.lblResultado);
        int n1=Integer.parseInt(numero1.getText().toString());
        int n2=Integer.parseInt(numero1.getText().toString());
        int sumaT=n1+n2;
        resultado.setText(String.valueOf(sumaT));
        Toast.makeText(this, "Resulado:" + sumaT, Toast.LENGTH_LONG).show();


    }


}
