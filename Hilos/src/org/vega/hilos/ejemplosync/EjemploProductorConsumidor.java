package org.vega.hilos.ejemplosync;

import org.vega.hilos.ejemplosync.runnable.*;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia pa=new Panaderia();
        new Thread(new Panadero(pa)).start();
        new Thread(new Consumidor(pa)).start();
    }
}
