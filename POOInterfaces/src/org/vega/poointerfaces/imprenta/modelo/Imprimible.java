package org.vega.poointerfaces.imprenta.modelo;

public interface Imprimible {
    default String imprimir(){
        return "imprimiendo";
    }
}
