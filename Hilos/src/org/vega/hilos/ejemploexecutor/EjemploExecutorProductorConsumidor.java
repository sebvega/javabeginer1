package org.vega.hilos.ejemploexecutor;

import org.vega.hilos.ejemplosync.Panaderia;
import org.vega.hilos.ejemplosync.runnable.Consumidor;
import org.vega.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException, TimeoutException {

        //ExecutorService executor = Executors.newFixedThreadPool(3);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("tamaño del pool" + executor.getPoolSize());
        System.out.println("cantidad de tareas en cola" + executor.getQueue().size());

        Panaderia pa = new Panaderia();
        Runnable productor = new Panadero(pa);
        Runnable consumidor = new Consumidor(pa);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        executor.shutdown();
        System.out.println("continuando con la ejecucion del main");

    }
}
