package org.vega.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        Timer tiempo = new Timer();

        tiempo.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("tarea realizada en:" + new Date() + "nombre del Thread: "
                        + Thread.currentThread().getName());
                System.out.println("Finaliza el timepo");
                tiempo.cancel();
            }
        }, 5000);
        System.out.println("Agendamos una tarea para 5 minutos mas...");
    }

}
