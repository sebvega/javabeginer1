package org.vega.pooherencia;

public class Profesor extends Persona {
    private String asignatura;

    public Profesor() {
        System.out.println("Profesor: iniciando constructor ");
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String saludar() {
        String saludo = super.saludar();
        return saludo + ", soy un profesor " + getNombre() + "  " + getAsignatura();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nasignatura='" + asignatura;
    }
}
