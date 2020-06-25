package ec.edu.espe.calculadoracompleta;

import androidx.appcompat.app.AppCompatActivity;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class grafico extends AppCompatActivity implements View.OnClickListener{
    LineGraphSeries<DataPoint> seriesSeno;
    LineGraphSeries<DataPoint> seriesCoseno;
    LineGraphSeries<DataPoint> seriesTangente;
    Button coseno,seno,tangente,volver;
    double y,x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);


        coseno = (Button) findViewById(R.id.btnSeno);
        seno = (Button) findViewById(R.id.btnCoseno);
        tangente = (Button) findViewById(R.id.btnTangente);
        volver = (Button) findViewById(R.id.btnVolver);

        coseno.setOnClickListener(this);
        seno.setOnClickListener(this);
        tangente.setOnClickListener(this);
        volver.setOnClickListener(this);



    }

    static double serieTaylorSin(double x) {
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

    static double serieTaylorCos(double x) {
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
    static double factorial(int numero) {
        double factorial = 1.0d;

        while (numero != 0) {
            factorial *= numero--;
        }

        return factorial;
    }

    @Override
    public void onClick(View v) {
        GraphView graph = (GraphView) findViewById(R.id.graph1);
        graph.removeAllSeries();

        switch (v.getId()) {
            case R.id.btnSeno:
                x = -5.0;
                seriesSeno = new LineGraphSeries<DataPoint>();
                for(int i =0; i<100; i++) {
                    x = x + 0.1;
                    y = serieTaylorSin(x);
                    seriesSeno.appendData(new DataPoint(x, y), true, 100);
                }
                seriesSeno.setColor(Color.RED);
                seriesSeno.setTitle("SIN");
                graph.setTitle("SENO");
                graph.addSeries(seriesSeno);
                break;
            case R.id.btnCoseno:
                x = -5.0;
                seriesCoseno = new LineGraphSeries<DataPoint>();

                for(int i =0; i<100; i++) {
                    x = x + 0.1;
                    y = serieTaylorCos(x);
                    seriesCoseno.appendData(new DataPoint(x, y), true, 100);
                }
                seriesCoseno.setColor(Color.GREEN);
                seriesCoseno.setTitle("COS");
                graph.setTitle("COSENO");
                graph.addSeries(seriesCoseno);
                break;
            case R.id.btnTangente:
                x = -5.0;
                seriesTangente = new LineGraphSeries<DataPoint>();
                seriesTangente.clearCursorModeCache();
                for(int i =0; i<100; i++) {
                    x = x + 0.1;
                    y = serieTaylorSin(x)/serieTaylorCos(x);
                    seriesTangente.appendData(new DataPoint(x, y), true, 100);
                }
                seriesTangente.setColor(Color.BLUE);
                seriesTangente.setTitle("TANG");
                graph.setTitle("TANGENTE");
                graph.addSeries(seriesTangente);
                break;
            case R.id.btnVolver:
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
                break;


        }
    }


}
