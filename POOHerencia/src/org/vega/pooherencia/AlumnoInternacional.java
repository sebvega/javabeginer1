package org.vega.pooherencia;

public class AlumnoInternacional extends Alumno {

    private String pais;
    private double notaIdiomas;

    public AlumnoInternacional() {
        System.out.println("Alumno internacional: iniciando constructor");
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getNotaIdiomas() {
        return notaIdiomas;
    }

    public void setNotaIdiomas(double notaIdiomas) {
        this.notaIdiomas = notaIdiomas;
    }

    @Override
    public String saludar() {
        String saludar = super.saludar();
        return saludar + ", soy un alumno internacional " + getNombre() + "  " + getPais();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\npais='" + pais + '\'' +
                ", notaIdiomas=" + notaIdiomas;
    }
}
