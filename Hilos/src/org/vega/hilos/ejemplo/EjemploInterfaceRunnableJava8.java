package org.vega.hilos.ejemplo;

import org.vega.hilos.ejemplo.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {




        Thread main=Thread.currentThread();
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {

                System.out.println(i + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread v1 = new Thread(viaje, "Roma");
        Thread v2 = new Thread(viaje, "Venezia");
        Thread v3 = new Thread(viaje, "Cuzco");

        v1.start();
        v2.start();
        v3.start();

        v1.join();
        v2.join();
        v3.join();

        System.out.println("continuando con la ejecucion del metodo main: "+main.getName());
    }
}
