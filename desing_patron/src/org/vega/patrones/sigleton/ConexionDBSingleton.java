package org.vega.patrones.sigleton;

public class ConexionDBSingleton {

    private static ConexionDBSingleton instancia;

    private ConexionDBSingleton() {
        System.out.println("conectando a MySQL");
    }

    public static ConexionDBSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDBSingleton();
        }
        return instancia;
    }
}
