package ec.edu.espe.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button suma,resta,multi,div,mmas,mmenos,m,igual,borrar;
    EditText display;
    int total=0;
    int op=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma=(Button)findViewById(R.id.btnSuma);
        resta=(Button)findViewById(R.id.btnResta);
        multi=(Button)findViewById(R.id.btnMulti);
        div=(Button)findViewById(R.id.btnDiv);
        mmas=(Button)findViewById(R.id.btnMmas);
        mmenos=(Button)findViewById(R.id.btnMmenos);
        m=(Button)findViewById(R.id.btnM);
        igual=(Button)findViewById(R.id.btnIgual);
        borrar=(Button)findViewById(R.id.btnBorrado);
        display=(EditText)findViewById(R.id.txtNumero);


        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multi.setOnClickListener(this);
        div.setOnClickListener(this);
        mmas.setOnClickListener(this);
        mmenos.setOnClickListener(this);
        m.setOnClickListener(this);
        igual.setOnClickListener(this);
        borrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSuma:
                op=1;
                total=Integer.parseInt(display.getText().toString())+total;
                display.setText("");
                break;
            case R.id.btnResta:
                op=2;
                if(total==0) {
                    total=Integer.parseInt(display.getText().toString());
                    display.setText("");
                }else {
                    total=total-Integer.parseInt(display.getText().toString());
                    display.setText("");
                }
                break;
            case R.id.btnMulti:
                op=3;
                if(total==0) {
                    total=Integer.parseInt(display.getText().toString());
                    display.setText("");
                }else {
                    total=total*Integer.parseInt(display.getText().toString());
                    display.setText("");
                }
                break;
            case R.id.btnDiv:
                op=4;
                if(total==0) {
                    total=Integer.parseInt(display.getText().toString());
                    display.setText("");
                }else {
                    total=total/Integer.parseInt(display.getText().toString());
                    display.setText("");
                }
                break;
            case R.id.btnMmas:
                op=5;
                break;
            case R.id.btnMmenos:
                op=6;
                break;
            case R.id.btnM:
                op=7;
                break;
            case R.id.btnIgual:
                switch (op){
                    case 1:
                        total=total+Integer.parseInt(display.getText().toString());
                        break;
                    case 2:
                        total=total-Integer.parseInt(display.getText().toString());
                        break;
                    case 3:
                        total=total*Integer.parseInt(display.getText().toString());
                        break;
                    case 4:
                        total=total/Integer.parseInt(display.getText().toString());
                        break;
                    case 5:
                        total=total+Integer.parseInt(display.getText().toString());
                        break;
                    case 6:
                        total=total-Integer.parseInt(display.getText().toString());
                        break;
                    case 7:
                        total=Integer.parseInt(display.getText().toString());
                        break;
                }


                display.setText(total+"");
                break;
            case R.id.btnBorrado:
                break;



        }

    }
}
