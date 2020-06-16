/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexadecimal;

/**
 *
 * @author niki_
 */
public class Hexadecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
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
    
}
