package org.vega.patrones.observer.ejemplo;

import org.vega.patrones.observer.Corporacion;
import org.vega.patrones.observer.Observable;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable,obj) -> {
            System.out.println("Jhon " + observable);
        });
        google.addObserver((observable,obj) -> {
            System.out.println("Andres " + observable);
        });
        google.addObserver((observable,obj) -> {
            System.out.println("Pepe " + observable);
        });
        google.modificarPrecio(1100);
    }
}
