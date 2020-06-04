package ec.edu.espe.calculadora;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSuma(){
        MainActivity prueba = new MainActivity();
        float valor = prueba.sumar(2,2);
        assertEquals(4,valor,valor);
    }
    @Test
    public void testResta(){
        MainActivity prueba = new MainActivity();
        float valor = prueba.restar(4,2);
        assertEquals(2,valor,valor);
    }
    @Test
    public void testMulti(){
        MainActivity prueba = new MainActivity();
        float valor = prueba.multiplicar(2,0);
        assertEquals(0,valor,valor);
    }
    @Test
    public void testDiv(){
        MainActivity prueba = new MainActivity();
        float valor = prueba.dividir(4,2);
        assertEquals(4,valor,valor);
    }
    @Test
    public void testDivCero(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.dividirCero();
        assertEquals("Math Error",valor);
    }
    @Test
    public void testMmas(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.dividirCero();
        assertEquals("Math Error",valor);
    }
    @Test
    public void testMmenos(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.dividirCero();
        assertEquals("Math Error",valor);
    }
    @Test
    public void testM(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.dividirCero();
        assertEquals("Math Error",valor);
    }
    @Test
    public void testBorrar(){
        MainActivity prueba = new MainActivity();
        float valor = prueba.borrar();
        assertEquals(0,valor,valor);
    }



}