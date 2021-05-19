package org.vega.hilos.ejemplo.runnable;

public class ViajeTarea implements Runnable {

    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

    }
}
