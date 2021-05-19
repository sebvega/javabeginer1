package org.vega.hilos.ejemplosync;



import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia pa = new Panaderia();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                pa.hornear("pan n° " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                pa.consumir();
            }
        }).start();
    }
}
