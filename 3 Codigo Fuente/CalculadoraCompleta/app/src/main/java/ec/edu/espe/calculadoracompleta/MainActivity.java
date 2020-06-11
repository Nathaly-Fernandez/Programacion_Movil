package ec.edu.espe.calculadoracompleta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button suma,resta,multi,div,mmas,mmenos,m,igual,borrar,eliminar,factorial,exponencial;
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,punto,modulo,signo,raiz,logaritmo;
    EditText display;
    Numero numero= new Numero();
    Operacion operacion = new Operacion();
    double total=0,memoria=0;
    int op=0,op1=1;
    String ingreso ="";
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
        modulo=(Button)findViewById(R.id.btnMod);
        signo=(Button)findViewById(R.id.btnSigno);
        raiz=(Button)findViewById(R.id.btnRaiz);
        logaritmo=(Button) findViewById(R.id.btnLog);

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
        modulo.setOnClickListener(this);
        signo.setOnClickListener(this);
        raiz.setOnClickListener(this);
        logaritmo.setOnClickListener(this);
    }

        public double log(int b,double n) {
            double val = 0;
            int i,accurate = 10,reps=0;
            while(n != 1 && accurate>=0) {
                for(i=0;n>=b;i++) n /= b;
                n = p(n,10);
                val = 10*(val+i);
                accurate--; reps++;
            }
            return (double)val/p(10,reps);
        }
        public double p(double x,int i) {
            double r = 1.0;
            r = Math.pow(x, i);
            return r;
        }



    public static void parseNumber(String n) {
        List result = new ArrayList();
        String number = n.trim();
        char[] numberChars = number.toCharArray();
        int length = numberChars.length;
        int i = 0;
        if (length % 2 != 0) {
            // si hay un numero impar de dígitos se toma el primer dígito
            result.add(new Integer(new Character(numberChars[0]).toString()));
            i = 1;
        }
    }
    public static HashMap minimoPositivo(List<HashMap> lista){
        Integer minimo=Integer.MAX_VALUE;
        int indice=0;
        HashMap result=new HashMap();
        for(HashMap elem:lista){// se recorre toda la lista
            Integer elemento=Integer.parseInt(elem.get("resto").toString());
            if(minimo>elemento && elemento>=0){// se obtiene el minimo positivo
                minimo=elemento;
                indice=Integer.parseInt(elem.get("indice").toString());
            }
        }
        result.put("indice",indice);
        result.put("resto",minimo);
        return result;
    }
    public static HashMap procesarRadicacion(Integer tupla, Integer raiz, Integer resto){
        HashMap result=new HashMap();
        List lista=new ArrayList();
        result.put("raiz",0);
        result.put("resto",0);
        Integer radical=raiz*2;
        Integer nuevoresto;
        Integer numero=0;
        try{
            numero=new Integer(resto.toString()+tupla.toString());
        }catch(Exception ex){
            System.err.println("El numero es demasiado grande no se puede procesar ...");
        }
        Integer nuevaraiz;
        Integer operando;
        for(Integer i=0;i<=9;i++){// se calcula los restos posibles
            operando=raiz*2;
            operando=Integer.parseInt(operando.toString()+i.toString());
            nuevoresto=numero-(operando*i);
            HashMap hash=new HashMap();
            hash.put("resto",nuevoresto);
            hash.put("indice",i);
            lista.add(hash);
        }
        HashMap Minimo=minimoPositivo(lista);//se obtiene el minimo
        nuevaraiz=new Integer(raiz.toString()+Minimo.get("indice").toString());
        result.put("raiz",nuevaraiz.toString());
        result.put("resto",Minimo.get("resto").toString());
        return result;
    }
    public void  raiz(int numero){

    }
    public int logaritmo(int numero){
        String num = Integer.toString(numero);
        if(num.contains(".")){
            String[] parts = num.split("-");
            num=parts[0];
        }
        int cantidad = num.length();

        return 0;
    }
    public int modulo(int divisor, int dividendo){
        int num=0;
        int aux;
        if(divisor==dividendo){
            return 0;
        }
        if(divisor>0 && dividendo>0){
            if(divisor>dividendo){
                num=divisor%dividendo;
            }else{
                num=divisor;
            }
        }else{
            if(divisor<0 && dividendo<0){
                divisor=divisor*(-1);
                dividendo=dividendo*(-1);
                if(divisor<dividendo){
                    num=divisor*(-1);
                }else{
                    num=divisor%dividendo;
                }

            }else{
                if(divisor<0 && dividendo>0){
                    divisor=divisor*-1;
                    num=divisor%dividendo;
                    if(num==0){
                        num=0;
                    }else{
                        aux=dividendo-num;
                        num=aux;
                    }
                }else{
                    if(divisor>0 && dividendo<0){
                        dividendo=dividendo*-1;
                        num=divisor%dividendo;
                        if(num==0){
                            num=0;
                        }else{
                            aux=(dividendo-num)*-1;
                            num=aux;
                        }
                    }else{
                        return 0;
                    }
                }
            }
        }
        return num;
    }
    public double sumar(double a,double b){
        return a+b;
    }
    public double restar(double a,double b){
        return a-b;
    }
    public double multiplicar(double a,double b){
        return a*b;
    }
    public double dividir(double a,double b){
        return a/b;
    }
    public String dividirCero(){
        AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage("No divida para 0");
        AlertDialog titulo = alerta.create();
        titulo.setTitle("ERROR");
        titulo.show();
        display.setText("");
        ingreso="";
        total=0;
        String mensaje="";
        return mensaje;
    }
    public double mMas(double a,double b){
        return a+b;
    }
    public double mMenos(double a,double b){
        return a-b;
    }
    public double m(double a){
        return a;
    }
    public double borrar(){
        return 0;
    }
    public double factorial (double numer) {
        if (numer==0) {
            return 1;
        }
        else {
            return numer * factorial(numer - 1);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSigno:
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else{
                    double cambio = Double.parseDouble(display.getText().toString());
                    cambio=cambio*(-1);
                    display.setText(cambio+"");
                }

                break;
            case R.id.btnMod:
                op=11;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {

                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        total = modulo((int) total, Integer.parseInt(display.getText().toString()));
                        display.setText("");
                    }
                }
                break;
            case R.id.btnSuma:
                op=1;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero \n Use el boton +/- para asignar el signo");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        total = sumar(Double.parseDouble(display.getText().toString()), total);
                        display.setText("");
                    }
                }
                break;
            case R.id.btnResta:
                op=2;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero \n Use el boton +/- para asignar el signo");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        total = restar(total, Double.parseDouble(display.getText().toString()));
                        display.setText("");
                    }
                }
                break;
            case R.id.btnMulti:
                op=3;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        total = multiplicar(total, Double.parseDouble(display.getText().toString()));
                        display.setText("");
                    }
                }
                break;
            case R.id.btnDiv:
                op=4;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        if (display.getText().toString().equals("0")) {
                            try {
                                String mensaje = dividirCero();
                                display.setText(mensaje + "");
                                total = 0;
                            } catch (Exception e) {
                                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                                alerta.setMessage("No divida para 0");
                                AlertDialog titulo = alerta.create();
                                titulo.setTitle("ERROR");
                                titulo.show();
                                display.setText("");
                                ingreso = "";
                            }
                        } else {
                            total = dividir(total, Double.parseDouble(display.getText().toString()));
                            display.setText("");
                        }
                    }
                }
                break;
            case R.id.btnMmas:
                op=5;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero ");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (memoria == 0) {
                        memoria = Double.parseDouble(display.getText().toString());
                        display.setText("");
                    } else {
                        memoria = mMas(memoria, Double.parseDouble(display.getText().toString()));
                        display.setText("");
                    }
                }
                break;
            case R.id.btnMmenos:
                op=6;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (memoria == 0) {
                        memoria = Double.parseDouble(display.getText().toString());
                        display.setText("");
                    } else {
                        memoria = mMenos(memoria, Double.parseDouble(display.getText().toString()));
                        display.setText("");
                    }
                }
                break;
            case R.id.btnM:
                op=7;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    memoria = m(Double.parseDouble(display.getText().toString()));
                    numero.setNum(memoria);
                    display.setText("");
                }
                break;
            case R.id.btnIgual:
                if(display.getText().toString().equals("")){

                }else{
                    switch (op){
                        case 11:
                            double aux = Double.parseDouble(display.getText().toString());
                            total=modulo((int)total,(int)aux);
                            break;
                        case 1:
                            total=(total+Double.parseDouble(display.getText().toString()));
                            break;
                        case 2:
                            total=total-Double.parseDouble(display.getText().toString());
                            break;
                        case 3:
                            total=total*Double.parseDouble(display.getText().toString());
                            break;
                        case 4:
                            if(display.getText().toString().equals("0")) {
                                total=0;
                                op=9;
                            }else {
                                total=total/Double.parseDouble(display.getText().toString());
                            }
                            break;
                        case 5:
                            total=total+Double.parseDouble(display.getText().toString());
                            break;
                        case 6:
                            total=total-Double.parseDouble(display.getText().toString());
                            break;
                        case 7:
                            total=memoria;
                            break;
                        case 8:
                            total=Math.pow(total,Double.parseDouble(display.getText().toString()));
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
                ingreso ="";
                total=borrar();
                memoria=borrar();
                display.setText("");
                break;
            case R.id.btnPotencia:
                op=8;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        total = Math.pow(total, Double.parseDouble(display.getText().toString()));
                        display.setText(total + "");
                    }
                }
                break;
            case R.id.btnFactorial:
                op=10;
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    ingreso = display.getText().toString();
                    if (display.getText().equals("")) {
                        total = 0;
                        display.setText(total + "");
                        op1 = 0;
                    } else {
                        if (ingreso.contains(".")) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                            alerta.setMessage("Ingrese valores enteros");
                            AlertDialog titulo = alerta.create();
                            titulo.setTitle("ERROR");
                            titulo.show();
                            display.setText("");
                            ingreso = "";
                            total = 0;
                        } else {
                            total = factorial(Double.parseDouble(display.getText().toString()));
                            display.setText(total + "");

                        }
                    }
                }
                break;
            case R.id.btnBorrar:
                if (ingreso.length()!=0){
                    ingreso=display.getText().toString();
                    ingreso = ingreso.substring(0,ingreso.length()-1);;
                    display.setText(ingreso+"");
                } else{

                }
                break;
            case R.id.btnNum0:
                ingreso = ingreso +"0";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum1:
                ingreso = ingreso +"1";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum2:
                ingreso = ingreso +"2";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum3:
                ingreso = ingreso +"3";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum4:
                ingreso = ingreso +"4";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum5:
                ingreso = ingreso +"5";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum6:
                ingreso = ingreso +"6";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum7:
                ingreso = ingreso +"7";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum8:
                ingreso = ingreso +"8";
                display.setText(ingreso +"");
                break;
            case R.id.btnNum9:
                ingreso = ingreso +"9";
                display.setText(ingreso +"");
                break;
            case R.id.btnPunto:
                if(ingreso.contains(".")){

                }else{
                    ingreso = ingreso +".";
                    display.setText(ingreso +"");
                }
                break;
            case R.id.btnLog:
                op=12;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    total= log(10,Integer.parseInt(display.getText().toString()));
                    display.setText(total+"");
                }
                break;
            case R.id.btnRaiz:
                op=13;
                ingreso ="";
                if(display.getText().toString().equals("")){
                    AlertDialog.Builder alerta =  new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                }else {
                    //total=raiz(Integer.parseInt(display.getText().toString()));

                }
                break;




        }


    }
}

