package org.vega.hilos.ejemploexecutor;

import java.util.Timer;
import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException, TimeoutException {

        //ExecutorService executor = Executors.newFixedThreadPool(3);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("tamaño del pool"+executor.getPoolSize());
        System.out.println("cantidad de tareas en cola"+executor.getQueue().size());

        //Runnable tarea = () -> {
        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("finaliza la tarea...");

            return "algun resultado importante de la tarea";

        };
        Callable<Integer> tarea2 = () -> {
            System.out.println("iniciando tarea 2");
            TimeUnit.SECONDS.sleep(2);
            return 10;
        };
        Future<String> resultadoFuturo = executor.submit(tarea);
        Future<String> resultadoFuturo2 = executor.submit(tarea);
        Future<Integer> resultadoFuturo3 = executor.submit(tarea2);
        executor.shutdown();
        System.out.println("continuando con la ejecucion del main");

        while (!(resultadoFuturo.isDone() && resultadoFuturo2.isDone() && resultadoFuturo3.isDone())) {
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultadoFuturo.isDone()?"finalizo":"en proceso",
                    resultadoFuturo2.isDone()?"finalizo":"en proceso",
                    resultadoFuturo3.isDone()?"finalizo":"en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("obtenemos el resultado1 de la tarea: " + resultadoFuturo.get());//espera hasta que termine
        System.out.println("finaliza la tarea " + resultadoFuturo.isDone());//en este caso ya es true

        System.out.println("obtenemos el resultado2 de la tarea: " + resultadoFuturo2.get());//espera hasta que termine
        System.out.println("finaliza la tarea " + resultadoFuturo2.isDone());//en este caso ya es true

        System.out.println("obtenemos el resultado3 de la tarea: " + resultadoFuturo3.get());//espera hasta que termine
        System.out.println("finaliza la tarea " + resultadoFuturo3.isDone());//en este caso ya es true
    }
}
