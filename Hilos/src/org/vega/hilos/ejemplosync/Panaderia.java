package org.vega.hilos.ejemplosync;

public class Panaderia {

    private String pan;
    private boolean disponible;

    public synchronized void hornear(String masa) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.pan = masa;
        System.out.println("se esta horneando el " + this.pan);
        this.disponible = true;
        notify();
    }

    public synchronized String consumir() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cliente consume: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}