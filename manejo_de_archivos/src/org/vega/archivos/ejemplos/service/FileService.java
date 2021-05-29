package org.vega.archivos.ejemplos.service;

import java.io.*;
import java.util.Scanner;

public class FileService {

    public void crearArchivo(String nombre) {
        File archivo = new File(nombre);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))) {
            buffer.append("Hello Word pasado de una aplicacion java en un txt")
                    .append("\n")
                    .append("como esta todo")
                    .append("\n")
                    .append("todo bien?")
                    .append("\n");
            //buffer.close();
            System.out.println("se ha creado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo2(String nombre) {
        File archivo = new File(nombre);
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))) {

            buffer.println("Hello Word pasado de una aplicacion java en un txt");
            buffer.println("como esta todo");
            buffer.printf("todo bien %s?", "sebas");

            //buffer.close();
            System.out.println("se ha creado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo2(String nombre) {
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try (Scanner s = new Scanner(archivo)) {
            s.useDelimiter("\n");
            while (s.hasNext()) {
                sb.append(s.next()).append("\n");
            }
            //s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


    public String leerArchivo(String nombre) {
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine())!=null) {
                sb.append(linea).append("\n");
            }
            //reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
