package org.vega.pooherencia;

public class Alumno extends Persona {
    private String institucion;
    private double notaMatematica;
    private double notaEspaniol;
    private double notaHistoria;

    public Alumno() {
        System.out.println("Alumno: iniciando constructor");
    }

    public Alumno(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre, String apellido, int edad, String institucion) {
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaEspaniol() {
        return notaEspaniol;
    }

    public void setNotaEspaniol(double notaEspaniol) {
        this.notaEspaniol = notaEspaniol;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }


    public String saludar() {
        String saludar = super.saludar();
        return saludar + ", soy un alumno " + getNombre();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ninstitucion='" + institucion + '\'' +
                ", notaMatematica=" + notaMatematica +
                ", notaEspaniol=" + notaEspaniol +
                ", notaHistoria=" + notaHistoria;
    }
}
