package org.vega.hilos.ejemplosync.runnable;

import org.vega.hilos.ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable {
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            panaderia.hornear("pan n° " + i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
