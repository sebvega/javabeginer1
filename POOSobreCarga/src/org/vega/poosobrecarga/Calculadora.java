package org.vega.poosobrecarga;

public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public float sumar(float a, float b) {
        return a + b;
    }

    public float sumar(int a, float b) {
        return a + b;
    }

    public float sumar(float a, int b) {
        return a + b;
    }
}
