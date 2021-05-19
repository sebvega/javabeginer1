package org.vega.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

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
        Future<String> resultadoFuturo = executor.submit(tarea);
        executor.shutdown();
        System.out.println("continuando con la ejecucion del main");

        while (!resultadoFuturo.isDone()) {
            System.out.println("cargando...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        //System.out.println(resultadoFuturo.isDone());//pregunta si ya termino

        System.out.println("obtenemos el resultado de la tarea: " + resultadoFuturo.get());//espera hasta que termine
        System.out.println("finaliza la tarea " + resultadoFuturo.isDone());//en este caso ya es true
    }
}
