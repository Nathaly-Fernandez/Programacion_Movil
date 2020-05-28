package ec.edu.espe.sumanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button suma;
    TextView resultado;
    EditText numero1, numero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1=(EditText)findViewById(R.id.editText);
        numero2=(EditText)findViewById(R.id.editText2);
        resultado=(TextView)findViewById(R.id.textView5);
        suma=(Button)findViewById(R.id.button);
        suma.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1=Integer.parseInt(numero1.getText().toString());
        int num2=Integer.parseInt(numero2.getText().toString());
        resultado.setText(num1+num2+"");
    }
}
