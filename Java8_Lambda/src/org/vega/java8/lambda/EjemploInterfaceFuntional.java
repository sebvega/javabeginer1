package org.vega.java8.lambda;

import org.vega.java8.lambda.aritmetica.Aritmetica;
import org.vega.java8.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFuntional {
    public static void main(String[] args) {

        Aritmetica suma = (a, b) -> a + b;
        Aritmetica resta = (a, b) -> a - b;

        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.computar(10, 5, suma));
        System.out.println(calculadora.computar(10, 5, resta));
        System.out.println(calculadora.computar(10, 5, (a, b) -> a * b));

        System.out.println(calculadora.computarConBiFunction(10, 5, Double::sum));
    }
}
