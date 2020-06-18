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

/*
Autores:
    - Nicole Arias
    - Nathaly Fernandez
    - Oscar Taco
Tutor:
    - ING. EDGAR FERNANDO SOLIS ACOSTA
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button suma, resta, multi, div, mmas, mmenos, m, igual, borrar, eliminar, factorial, exponencial, sin, cos, tan;
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, punto, modulo, signo, raiz, logaritmo, oct, dec, hex, bin;
    EditText display;
    Numero numero = new Numero();
    Operacion operacion = new Operacion();
    double total = 0, memoria = 0;
    int op = 0, op1 = 1;
    String ingreso = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suma = (Button) findViewById(R.id.btnSuma);
        resta = (Button) findViewById(R.id.btnResta);
        multi = (Button) findViewById(R.id.btnMulti);
        div = (Button) findViewById(R.id.btnDiv);
        mmas = (Button) findViewById(R.id.btnMmas);
        mmenos = (Button) findViewById(R.id.btnMmenos);
        m = (Button) findViewById(R.id.btnM);
        igual = (Button) findViewById(R.id.btnIgual);
        borrar = (Button) findViewById(R.id.btnBorrar);
        display = (EditText) findViewById(R.id.txtNumero);
        eliminar = (Button) findViewById(R.id.btnEliminar);
        factorial = (Button) findViewById(R.id.btnFactorial);
        exponencial = (Button) findViewById(R.id.btnPotencia);
        num1 = (Button) findViewById(R.id.btnNum1);
        num2 = (Button) findViewById(R.id.btnNum2);
        num3 = (Button) findViewById(R.id.btnNum3);
        num4 = (Button) findViewById(R.id.btnNum4);
        num5 = (Button) findViewById(R.id.btnNum5);
        num6 = (Button) findViewById(R.id.btnNum6);
        num7 = (Button) findViewById(R.id.btnNum7);
        num8 = (Button) findViewById(R.id.btnNum8);
        num9 = (Button) findViewById(R.id.btnNum9);
        num0 = (Button) findViewById(R.id.btnNum0);
        punto = (Button) findViewById(R.id.btnPunto);
        modulo = (Button) findViewById(R.id.btnMod);
        signo = (Button) findViewById(R.id.btnSigno);
        raiz = (Button) findViewById(R.id.btnRaiz);
        logaritmo = (Button) findViewById(R.id.btnLog);
        sin = (Button) findViewById(R.id.btnSin);
        cos = (Button) findViewById(R.id.btnCos);
        tan = (Button) findViewById(R.id.btnTan);
        oct = (Button) findViewById(R.id.btnOct);
        dec = (Button) findViewById(R.id.btnDec);
        hex = (Button) findViewById(R.id.btnHex);
        bin = (Button) findViewById(R.id.btnBin);

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
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        oct.setOnClickListener(this);
        dec.setOnClickListener(this);
        hex.setOnClickListener(this);
        bin.setOnClickListener(this);
    }

    /**
     * @param  decimal
     * @return
     */
    public String decimalAHexadecimal(int decimal) {
        String hexadecimal = "";
        String caracteresHexadecimales = "0123456789abcdef";
        while (decimal > 0) {
            int residuo = decimal % 16;
            hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal; // Agregar a la izquierda
            decimal /= 16;
        }
        return hexadecimal;
    }

    /**
     * @param decimal
     * @return
     */
    public String decimalAOctal(int decimal) {
        String octal = "";// Almacenamos el número octal que será el resultad
        String caracteresOctales = "01234567";
        while (decimal > 0) {
            int residuo = decimal % 8;
            octal = (caracteresOctales.charAt(residuo) + octal);
            decimal /= 8;
        }
        return octal;
    }

    /**
     * @param decimal
     * @return
     */
    public static String DecimalBinario(long decimal) {
        if (decimal <= 0) {
            return "0";
        }
        StringBuilder binario = new StringBuilder();
        while (decimal > 0) {
            short residuo = (short) (decimal % 2);
            decimal = decimal / 2;// Insertar el dígito al inicio de la cadena
            binario.insert(0, String.valueOf(residuo));
        }
        return binario.toString();
    }

    /**
     * @param b
     * @param n
     * @return
     */
    public double log(int b, double n) {
        double val = 0;
        int i, accurate = 10, reps = 0;
        while (n != 1 && accurate >= 0) {
            for (i = 0; n >= b; i++) n /= b;
            n = p(n, 10);
            val = 10 * (val + i);
            accurate--;
            reps++;
        }
        return (double) val / p(10, reps);
    }

    /**
     *
     * @param x
     * @param i
     * @return
     */
    public double p(double x, int i) {
        double r = 1.0;
        r = Math.pow(x, i);
        return r;
    }
    /**
     *
     * @param x
     * @return
     */
    static double serieTaylorSin(double x) {
        x = x * (Math.PI / 180);
        double sumando, sumatoria = 0, precision = 0.0001d;

        // limite superior, iteracion de la sumatoria
        int n = 0;

        do {
            sumando = Math.pow(-1, n) / factorial(((2 * n) + 1)) * Math.pow(x, (2 * n) + 1);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }

    /**
     *
     * @param x
     * @return
     */
    static double serieTaylorCos(double x) {
        x = x * (Math.PI / 180);
        double sumando, sumatoria = 0, precision = 0.0001d;

        // limite superior, iteracion de la sumatoria
        int n = 0;

        do {
            sumando = Math.pow(-1, n) / factorial(2 * n) * Math.pow(x, 2 * n);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);

        return sumatoria;
    }

    /**
     *
     * @param numero
     * @return
     */
    static double factorial(int numero) {
        double factorial = 1.0d;

        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }

    /**
     *
     * @param base
     * @param elevado
     * @return
     */
    static double potencia(int base, int elevado) {
        double poten = base;
        for (int i = 1; i <= elevado; i++) {
            poten = poten * base;
        }
        return poten;
    }

    /**
     *
     * @param numero
     * @return
     */
    public double raiz(double numero) {
        double x = 1.0;
        double a = numero;
        int k;
        if (a >= 0) {

            for (k = 1; k < 10; k++) {
                x = (x + a / x) / 2;
            }
        } else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setMessage("No existe la raiz");
            AlertDialog titulo = alerta.create();
            titulo.setTitle("ERROR");
            titulo.show();
            x = 0;
        }

        return x;
    }

    /**
     *
     * @param divisor
     * @param dividendo
     * @return modulo
     */
    public int modulo(int divisor, int dividendo) {
        int num = 0;
        int aux;
        if (divisor == dividendo) {
            return 0;
        }
        if (divisor > 0 && dividendo > 0) {
            if (divisor > dividendo) {
                num = divisor % dividendo;
            } else {
                num = divisor;
            }
        } else {
            if (divisor < 0 && dividendo < 0) {
                divisor = divisor * (-1);
                dividendo = dividendo * (-1);
                if (divisor < dividendo) {
                    num = divisor * (-1);
                } else {
                    num = divisor % dividendo;
                }

            } else {
                if (divisor < 0 && dividendo > 0) {
                    divisor = divisor * -1;
                    num = divisor % dividendo;
                    if (num == 0) {
                        num = 0;
                    } else {
                        aux = dividendo - num;
                        num = aux;
                    }
                } else {
                    if (divisor > 0 && dividendo < 0) {
                        dividendo = dividendo * -1;
                        num = divisor % dividendo;
                        if (num == 0) {
                            num = 0;
                        } else {
                            aux = (dividendo - num) * -1;
                            num = aux;
                        }
                    } else {
                        return 0;
                    }
                }
            }
        }
        return num;
    }

    /**
     *
     * @param base
     * @param exponente
     * @return
     */
    public double elevado(double base, double exponente) {
        double x = base;
        for (int i = 1; i <= exponente; i++) {
            x = base * x;
        }
        return x;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double restar(double a, double b) {
        return a - b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double dividir(double a, double b) {
        return a / b;
    }

    /**
     *
     * @return
     */
    public String dividirCero() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage("No divida para 0");
        AlertDialog titulo = alerta.create();
        titulo.setTitle("ERROR");
        titulo.show();
        display.setText("");
        ingreso = "";
        total = 0;
        String mensaje = "";
        return mensaje;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double mMas(double a, double b) {
        return a + b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double mMenos(double a, double b) {
        return a - b;
    }

    /**
     *
     * @param a
     * @return
     */
    public double m(double a) {
        return a;
    }

    /**
     *
     * @return
     */
    public double borrar() {
        return 0;
    }

    /**
     *
     * @param numer
     * @return
     */
    public double factorial(double numer) {
        if (numer == 0) {
            return 1;
        } else {
            return numer * factorial(numer - 1);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSigno:
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    double cambio = Double.parseDouble(display.getText().toString());
                    cambio = cambio * (-1);
                    display.setText(cambio + "");
                }

                break;
            case R.id.btnMod:
                op = 11;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {

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
                op = 1;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero \n Use el boton +/- para asignar el signo");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
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
                op = 2;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero \n Use el boton +/- para asignar el signo");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
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
                op = 3;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
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
                op = 4;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
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
                op = 5;
                ingreso = "";

                if (memoria == 0) {
                    memoria = Double.parseDouble(display.getText().toString());
                    display.setText("");
                } else {
                    memoria = mMas(memoria, Double.parseDouble(display.getText().toString()));
                    display.setText(memoria + "");
                }

                break;
            case R.id.btnMmenos:
                op = 6;
                ingreso = "";

                if (memoria == 0) {
                    memoria = Double.parseDouble(display.getText().toString());
                    display.setText("");
                } else {
                    memoria = mMenos(memoria, Double.parseDouble(display.getText().toString()));
                    display.setText(memoria + "");
                }

                break;
            case R.id.btnM:
                op = 7;
                ingreso = "";

                if (memoria == 0) {
                    memoria = m(Double.parseDouble(display.getText().toString()));
                    numero.setNum(memoria);
                    display.setText("");
                } else {
                    display.setText(memoria + "");
                }


                break;
            case R.id.btnIgual:
                if (display.getText().toString().equals("")) {

                } else {
                    switch (op) {
                        case 11:
                            double aux = Double.parseDouble(display.getText().toString());
                            total = modulo((int) total, (int) aux);
                            break;
                        case 1:
                            total = (total + Double.parseDouble(display.getText().toString()));
                            break;
                        case 2:
                            total = total - Double.parseDouble(display.getText().toString());
                            break;
                        case 3:
                            total = total * Double.parseDouble(display.getText().toString());
                            break;
                        case 4:
                            if (display.getText().toString().equals("0")) {
                                total = 0;
                                op = 9;
                            } else {
                                total = total / Double.parseDouble(display.getText().toString());
                            }
                            break;
                        case 5:
                            total = total + Double.parseDouble(display.getText().toString());
                            break;
                        case 6:
                            total = total - Double.parseDouble(display.getText().toString());
                            break;
                        case 7:
                            total = memoria;
                            break;
                        case 8:
                            total = Math.pow(total, Double.parseDouble(display.getText().toString()));
                            break;
                    }
                }
                if (op == 9) {
                    String mensaje = dividirCero();
                    display.setText(mensaje + "");
                    op = 0;
                } else {
                    display.setText(total + "");
                    op1 = 8;
                }

                break;
            case R.id.btnEliminar:
                ingreso = "";
                total = borrar();
                memoria = borrar();
                display.setText("");
                break;
            case R.id.btnPotencia:
                op = 8;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    if (total == 0 || op1 == 8) {
                        total = Double.parseDouble(display.getText().toString());
                        display.setText("");
                        op1 = 0;
                    } else {
                        total = elevado(total, Double.parseDouble(display.getText().toString()));
                        display.setText(total + "");
                    }
                }
                break;
            case R.id.btnFactorial:
                op = 10;
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
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
                if (ingreso.length() != 0) {
                    ingreso = display.getText().toString();
                    ingreso = ingreso.substring(0, ingreso.length() - 1);
                    ;
                    display.setText(ingreso + "");
                } else {

                }
                break;
            case R.id.btnNum0:
                ingreso = ingreso + "0";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum1:
                ingreso = ingreso + "1";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum2:
                ingreso = ingreso + "2";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum3:
                ingreso = ingreso + "3";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum4:
                ingreso = ingreso + "4";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum5:
                ingreso = ingreso + "5";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum6:
                ingreso = ingreso + "6";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum7:
                ingreso = ingreso + "7";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum8:
                ingreso = ingreso + "8";
                display.setText(ingreso + "");
                break;
            case R.id.btnNum9:
                ingreso = ingreso + "9";
                display.setText(ingreso + "");
                break;
            case R.id.btnPunto:
                if (ingreso.contains(".")) {

                } else {
                    ingreso = ingreso + ".";
                    display.setText(ingreso + "");
                }
                break;
            case R.id.btnLog:
                op = 12;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    total = log(10, Integer.parseInt(display.getText().toString()));
                    display.setText(total + "");
                }
                break;
            case R.id.btnRaiz:
                op = 13;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    double ver = Double.parseDouble(display.getText().toString());
                    if (ver < 0) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                        alerta.setMessage("no existe la raiz");
                        AlertDialog titulo = alerta.create();
                        titulo.setTitle("ERROR");
                        titulo.show();
                    } else {
                        total = raiz(Double.parseDouble(display.getText().toString()));
                        display.setText(total + "");
                    }

                }
                break;
            case R.id.btnSin:
                op = 14;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    total = serieTaylorSin(Double.parseDouble(display.getText().toString()));
                    display.setText(total + "");
                }
                break;
            case R.id.btnCos:
                op = 15;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    total = serieTaylorCos(Double.parseDouble(display.getText().toString()));
                    display.setText(total + "");
                }
                break;
            case R.id.btnTan:
                op = 15;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    total = serieTaylorSin(Double.parseDouble(display.getText().toString())) / serieTaylorCos(Double.parseDouble(display.getText().toString()));
                    display.setText(total + "");
                }
                break;

            case R.id.btnHex:
                op = 16;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    String hex;
                    hex = decimalAHexadecimal(Integer.parseInt(display.getText().toString()));
                    display.setText(hex + "");
                }
                break;
            case R.id.btnOct:
                op = 17;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    String oct;
                    oct = decimalAOctal(Integer.parseInt(display.getText().toString()));
                    display.setText(oct + "");
                }
                break;
            case R.id.btnBin:
                op = 18;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {
                    String bin;
                    bin = DecimalBinario(Integer.parseInt(display.getText().toString()));
                    display.setText(bin + "");
                }
                break;
            case R.id.btnDec:
                op = 19;
                ingreso = "";
                if (display.getText().toString().equals("")) {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Ingrese un numero primero");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("ERROR");
                    titulo.show();
                } else {

                }
                break;


        }


    }
}

