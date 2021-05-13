package org.vega.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) throws DivisionPorZeroException, FormatoNumeroException {
        Calculadora calculadora = new Calculadora();
        String numerador = JOptionPane.showInputDialog("ingrese el numerador");
        String denominador = JOptionPane.showInputDialog("ingrese el denominador");

        try {

            double division2 = calculadora.dividir(numerador, denominador);
            System.out.println("division2 = " + division2);

        } catch (FormatoNumeroException fne) {
            System.out.println("ingrese un numero valido: " + fne.getMessage());

            fne.printStackTrace(System.out);

        } catch (NumberFormatException nfe) {
            System.out.println("se detecto una excepcion, ingrese un numero = " + nfe);
            main(args);
        } catch (DivisionPorZeroException dpze) {
            System.out.println("Capturar el error en ejecucion tipo aritmetico: " + dpze.getMessage());
            main(args);
        } finally {
            System.out.println("estamos cerrando la conexion con el servidor");
        }
        System.out.println("continuamos con el flujo normal de la aplicacion");
    }
}
