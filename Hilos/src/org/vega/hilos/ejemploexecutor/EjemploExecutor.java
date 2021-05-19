package org.vega.hilos.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("finaliza la tarea...");
        };
        executor.submit(tarea);
        executor.shutdown();
        System.out.println("continuando con la ejecucion del main 1");
        executor.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("continuando con la ejecucion del main 2");
    }
}
