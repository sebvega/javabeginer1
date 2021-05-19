package org.vega.hilos.ejemplo;

import org.vega.hilos.ejemplo.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Roma")).start();
        new Thread(new ViajeTarea("Venezia")).start();
        new Thread(new ViajeTarea("Cuzco")).start();
    }
}
