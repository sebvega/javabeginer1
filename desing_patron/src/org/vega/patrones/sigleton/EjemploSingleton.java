package org.vega.patrones.sigleton;

public class EjemploSingleton {
    public static void main(String[] args) {

        for (int i=0;i<10;i++){
            ConexionDBSingleton con=ConexionDBSingleton.getInstancia();
            System.out.println("con = " + con);
        }
    }
}
