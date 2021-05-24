package org.vega.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriod {
    public static void main(String[] args) {

        LocalDate fecha1=LocalDate.of(2011,9,23);
        LocalDate fecha2=LocalDate.of(2021,11,21);

        Period periodo=Period.between(fecha1,fecha2);

        System.out.println("periodo = " + periodo);
    }
}
