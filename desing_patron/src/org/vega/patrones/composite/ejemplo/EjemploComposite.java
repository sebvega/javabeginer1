package org.vega.patrones.composite.ejemplo;

import org.vega.patrones.composite.Archivo;
import org.vega.patrones.composite.Directorio;

public class EjemploComposite {
    public static void main(String[] args) {

        Directorio doc=new Directorio("Documentos");
        Directorio java=new Directorio("Java8");


        java.addComponente(new Archivo("patron-composite.docx"));
        Directorio stream= new Directorio("Api stream");
        stream.addComponente(new Archivo("stram-map.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("CV.docx"));
        doc.addComponente(new Archivo("logoEmpresa.png"));

        System.out.println(doc.mostrar(0));



    }
}
