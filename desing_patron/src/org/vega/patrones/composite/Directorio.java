package org.vega.patrones.composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente {

    private List<Componente> hijos;
    private List<String> hola;

    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    public Directorio addComponente(Componente com) {
        hijos.add(com);
        return this;
    }

    public void removeComponente(Componente com) {
        hijos.remove(com);
    }

    @Override
    public String mostrar(int nivel) {
        StringBuilder sb = new StringBuilder("- ".repeat(nivel));
        sb.append(nombre)
                .append("/")
                .append("\n");
        for (Componente c1 : this.hijos) {
            sb.append(c1.mostrar(nivel + 1));
            if (c1 instanceof Archivo) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean buscar(String nombre) {
        if (this.nombre.equalsIgnoreCase(nombre)) {
            return true;
        }
        /*
        for (Componente hijo:hijos){
            if (hijo.buscar(nombre)){
                return true;
            }
        }
        return false;
         */
        return hijos.stream().anyMatch(h -> h.buscar(nombre));
    }
}
