package ec.edu.espe.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button suma,resta,multi,div,mmas,mmenos,m,igual,borrar;
    EditText display;
    float total=0;
    int op=0;
    int op1=1;
    float memoria=0;
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

    public float sumar(float a,float b){
        return a+b;
    }
    public float restar(float a,float b){
        return a-b;
    }
    public float multiplicar(float a,float b){
        return a*b;
    }
    public float dividir(float a,float b){
        return a/b;
    }
    public String dividirCero(){
        String mensaje="Math Error";
        return mensaje;
    }
    public float mMas(float a,float b){
        return a+b;
    }
    public float mMenos(float a,float b){
        return a-b;
    }
    public float m(float a){
        return a;
    }
    public float borrar(){
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSuma:
                op=1;
                if(total==0 || op1==8) {
                    total=Float.parseFloat(display.getText().toString());
                    display.setText("");
                    op1=0;
                }else {
                    total=sumar(Float.parseFloat(display.getText().toString()),total);
                    display.setText("");
                }
                break;
            case R.id.btnResta:
                op=2;
                if(total==0 || op1==8) {
                    total=Float.parseFloat(display.getText().toString());
                    display.setText("");
                    op1=0;
                }else {
                    total=restar(total,Float.parseFloat(display.getText().toString()));
                    display.setText("");
                }
                break;
            case R.id.btnMulti:
                op=3;
                if(total==0 || op1==8) {
                    total=Float.parseFloat(display.getText().toString());
                    display.setText("");
                    op1=0;
                }else {
                    total=multiplicar(total,Float.parseFloat(display.getText().toString()));
                    display.setText("");
                }
                break;
            case R.id.btnDiv:
                op=4;
                if(total==0 || op1==8) {
                    total=Float.parseFloat(display.getText().toString());
                    display.setText("");
                    op1=0;
                }else {
                    if(display.getText().toString().equals("0")){
                        try{
                            String mensaje = dividirCero();
                            display.setText(mensaje+"");
                            total=0;
                        }catch (Exception e){
                            display.setText("");
                        }
                    }else{
                        total=dividir(total,Float.parseFloat(display.getText().toString()));
                        display.setText("");
                    }
                }
                break;
            case R.id.btnMmas:
                op=5;
                if(memoria == 0){
                    memoria=Float.parseFloat(display.getText().toString());
                }else{
                    memoria=mMas(memoria,Float.parseFloat(display.getText().toString()));
                }
                break;
            case R.id.btnMmenos:
                op=6;
                if(memoria == 0){
                    memoria=Float.parseFloat(display.getText().toString());
                }else{
                    memoria=mMenos(memoria,Float.parseFloat(display.getText().toString()));
                }
                break;
            case R.id.btnM:
                op=7;
                memoria=m(Float.parseFloat(display.getText().toString()));
                break;
            case R.id.btnIgual:
                if(display.getText().toString().equals("")){

                }else{
                    switch (op){
                        case 1:
                            total=total+Float.parseFloat(display.getText().toString());
                            break;
                        case 2:
                            total=total-Float.parseFloat(display.getText().toString());
                            break;
                        case 3:
                            total=total*Float.parseFloat(display.getText().toString());
                            break;
                        case 4:
                            if(display.getText().toString().equals("0")) {
                                total=0;
                                op=9;
                            }else {
                                total=total/Float.parseFloat(display.getText().toString());
                            }
                            break;
                        case 5:
                            total=total+Float.parseFloat(display.getText().toString());
                            break;
                        case 6:
                            total=total-Float.parseFloat(display.getText().toString());
                            break;
                        case 7:
                            total=Float.parseFloat(display.getText().toString());
                            break;
                    }
                }
                if(op==9){
                    String mensaje=dividirCero();
                    display.setText(mensaje+"");
                    op=0;
                }else{
                    display.setText(total+"");
                    op1=8;
                }

                break;
            case R.id.btnBorrado:
                total=borrar();
                memoria=borrar();
                display.setText("");
                break;



        }

    }
}
