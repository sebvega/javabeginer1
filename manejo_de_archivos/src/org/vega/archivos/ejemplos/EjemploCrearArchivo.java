package org.vega.archivos.ejemplos;

import org.vega.archivos.ejemplos.service.FileService;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "D:\\cursos\\java\\archivos\\java.txt";

        FileService service = new FileService();
        System.out.println(service.leerArchivo2(nombreArchivo));
        // service.crearArchivo(nombreArchivo);
    }
}
//  d/cursos/java/IdeaProjects