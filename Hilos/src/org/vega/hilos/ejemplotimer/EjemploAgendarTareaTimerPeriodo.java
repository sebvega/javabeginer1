package org.vega.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        AtomicInteger contadorAtomic=new AtomicInteger(3);
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Timer tiempo = new Timer();


        tiempo.schedule(new TimerTask() {

            @Override
            public void run() {
                int i=contadorAtomic.getAndDecrement();
                if(i>0){
                    toolkit.beep();
                    System.out.println("tarea periodica en: " + new Date() + "nombre del Thread: "
                            + Thread.currentThread().getName());
                     //contador--;
                }else {
                    System.out.println("Finaliza el timepo");
                    tiempo.cancel();
                }
            }
        }, 500, 1000);
        System.out.println("Agendamos una tarea cada 10 seg...");
    }

}
