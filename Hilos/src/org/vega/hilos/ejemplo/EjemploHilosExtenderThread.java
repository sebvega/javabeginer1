package org.vega.hilos.ejemplo;

import org.vega.hilos.ejemplo.threads.NombreThread;

public class EjemploHilosExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo=new NombreThread("Jhon Cena");
        hilo.start();

        //Thread.sleep(100);

        Thread hilo2=new NombreThread("Maria");
        hilo2.start();

        System.out.println("corriendo en el main despues del start");
        System.out.println(hilo.getState());

        NombreThread hilo3=new NombreThread("anita laba la tina");
        hilo3.start();
    }
}
