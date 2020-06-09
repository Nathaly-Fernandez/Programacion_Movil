package ec.edu.espe.calculadoracompleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button suma,resta,multi,div,mmas,mmenos,m,igual,borrar,eliminar,factorial,exponencial;
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,punto;
    EditText display;
    Numero numero= new Numero();
    Operacion operacion = new Operacion();
    float total=0,memoria=0;
    int op=0,op1=1;
    String contenido="";
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
        borrar=(Button)findViewById(R.id.btnBorrar);
        display=(EditText)findViewById(R.id.txtNumero);
        eliminar=(Button)findViewById(R.id.btnEliminar);
        factorial=(Button)findViewById(R.id.btnFactorial);
        exponencial=(Button)findViewById(R.id.btnPotencia);
        num1=(Button)findViewById(R.id.btnNum1);
        num2=(Button)findViewById(R.id.btnNum2);
        num3=(Button)findViewById(R.id.btnNum3);
        num4=(Button)findViewById(R.id.btnNum4);
        num5=(Button)findViewById(R.id.btnNum5);
        num6=(Button)findViewById(R.id.btnNum6);
        num7=(Button)findViewById(R.id.btnNum7);
        num8=(Button)findViewById(R.id.btnNum8);
        num9=(Button)findViewById(R.id.btnNum9);
        num0=(Button)findViewById(R.id.btnNum0);
        punto=(Button)findViewById(R.id.btnPunto);

        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multi.setOnClickListener(this);
        div.setOnClickListener(this);
        mmas.setOnClickListener(this);
        mmenos.setOnClickListener(this);
        m.setOnClickListener(this);
        igual.setOnClickListener(this);
        borrar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        factorial.setOnClickListener(this);
        exponencial.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);
        punto.setOnClickListener(this);
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
                    display.setText("");
                }else{
                    memoria=mMas(memoria,Float.parseFloat(display.getText().toString()));
                    display.setText("");
                }
                break;
            case R.id.btnMmenos:
                op=6;
                if(memoria == 0){
                    memoria=Float.parseFloat(display.getText().toString());
                    display.setText("");
                }else{
                    memoria=mMenos(memoria,Float.parseFloat(display.getText().toString()));
                    display.setText("");
                }
                break;
            case R.id.btnM:
                op=7;
                memoria=m(Float.parseFloat(display.getText().toString()));
                numero.setNum(memoria);
                display.setText("");
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
                            total=memoria;
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
            case R.id.btnEliminar:
                contenido="";
                total=borrar();
                memoria=borrar();
                display.setText("");
                break;
            case R.id.btnPotencia:
                if(total==0){

                }else{
                    double tot=0;
                    tot=Math.pow(tot,Double.parseDouble(display.getText().toString()));
                }
                break;
            case R.id.btnBorrar:
                if (contenido.length()!=0){
                    contenido = contenido.replace(contenido.substring(contenido.length()-1), "");
                    display.setText(contenido+"");
                } else{

                }
                break;
            case R.id.btnNum0:
                contenido=contenido+"0";
                display.setText(contenido+"");
                break;
            case R.id.btnNum1:
                contenido=contenido+"1";
                display.setText(contenido+"");
                break;
            case R.id.btnNum2:
                contenido=contenido+"2";
                display.setText(contenido+"");
                break;
            case R.id.btnNum3:
                contenido=contenido+"3";
                display.setText(contenido+"");
                break;
            case R.id.btnNum4:
                contenido=contenido+"4";
                display.setText(contenido+"");
                break;
            case R.id.btnNum5:
                contenido=contenido+"5";
                display.setText(contenido+"");
                break;
            case R.id.btnNum6:
                contenido=contenido+"6";
                display.setText(contenido+"");
                break;
            case R.id.btnNum7:
                contenido=contenido+"7";
                display.setText(contenido+"");
                break;
            case R.id.btnNum8:
                contenido=contenido+"8";
                display.setText(contenido+"");
                break;
            case R.id.btnNum9:
                contenido=contenido+"9";
                display.setText(contenido+"");
                break;



        }


    }
}
