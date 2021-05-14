package org.vega.ejemplos.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{
    private String nombre;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", nota='" + nota;
    }

    @Override
    public int compareTo(Alumno o) {
        if (this==null) return 0;
        return this.nombre.compareTo(o.nombre);
        //para numeros primitivos
        /*if (this.nota==o.nota)return 0;
        if (this.nota>o.nota)return 1;
        if (this.nota<o.nota)return -1;*/

        //con cuando es tipo Integer T
       // if (this.nota==null)return 0;
      //  return this.nota.compareTo(o.nota)
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return nota==alumno.nota && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
