package ec.edu.espe.calculadoracompleta;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testSuma(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.sumar(2,2);
        assertEquals(4,valor,valor);
    }
    @Test
    public void testResta(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.restar(4,2);
        assertEquals(2,valor,valor);
    }
    @Test
    public void testMulti(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.multiplicar(2,0);
        assertEquals(0,valor,valor);
    }
    @Test
    public void testDiv(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.dividir(4,2);
        assertEquals(4,valor,valor);
    }

    @Test
    public void testBorrar(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.borrar();
        assertEquals(0,valor,valor);
    }
    @Test
    public void testPotencia(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.elevado(2,2);
        assertEquals(4,valor,valor);
    }
    @Test
    public void testFactorial(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.factorial(5);
        assertEquals(120,valor,valor);
    }
    @Test
    public void testRaiz(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.raiz(9);
        assertEquals(3,valor,valor);
    }
    @Test
    public void testModulo1(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.modulo(-5,6);
        assertEquals(1,valor,valor);
    }
    @Test
    public void testModulo2(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.modulo(-5,4);
        assertEquals(3,valor,valor);
    }
    @Test
    public void testModulo3(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.modulo(-5,-4);
        assertEquals(1,valor,valor);
    }
    @Test
    public void testModulo4(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.modulo(5,-4);
        assertEquals(-3,valor,valor);
    }
    @Test
    public void testLogarritmo(){
        MainActivity prueba = new MainActivity();
        double valor = prueba.log(10,10);
        assertEquals(1,valor,valor);
    }
    @Test
    public void testBinario(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.DecimalBinario(5);
        assertEquals("101",valor,valor);
    }
    @Test
    public void testHexa(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.decimalAHexadecimal(10);
        assertEquals("a",valor,valor);
    }
    @Test
    public void testOcta(){
        MainActivity prueba = new MainActivity();
        String valor = prueba.decimalAOctal(8);
        assertEquals("10",valor,valor);
    }
}