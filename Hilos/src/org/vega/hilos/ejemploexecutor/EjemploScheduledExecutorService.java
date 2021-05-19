package org.vega.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("tarea en el main ......");


        //CountDownLatch lock = new CountDownLatch(5);
        AtomicInteger contador=new AtomicInteger(5);
        Future<?> futuro= executor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            //    lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hola mundo dentro de la tarea -.-");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        //TimeUnit.SECONDS.sleep(10);

        //lock.await();
        //futuro.cancel(true);
        while (contador.get()>=0){
            if (contador.get()==0){
                futuro.cancel(true);
                contador.getAndDecrement();
            }
        }
        System.out.println("otra tarea en el main ......");
        executor.shutdown();
    }
}
