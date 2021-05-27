package org.vega.patrones.observer.ejemplo;

import org.vega.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        repo.addObserver((o, u) -> System.out.println("Enviando un e-mail al usuario " + u));
        repo.addObserver((o, u) -> System.out.println("Enviando un e-mail al administrador"));
        repo.addObserver((o, u) -> System.out.println("Guardando la info del usuario "
                + u + " en el registro"));
        repo.crearUsuario("juancho");

    }
}
