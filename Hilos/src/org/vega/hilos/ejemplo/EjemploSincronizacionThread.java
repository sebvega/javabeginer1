package org.vega.hilos.ejemplo;

import org.vega.hilos.ejemplo.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrases("Hola"," que tal!")).start();
        new Thread(new ImprimirFrases("quien eres"," tu?")).start();
        Thread.sleep(100);
        Thread h3=new Thread(new ImprimirFrases("muchas gracias", " por todo"));


        h3.start();
    }

    public synchronized static void imprimirFrases(String frase1,String frase2){
        System.out.print(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(frase2);
    }
}
