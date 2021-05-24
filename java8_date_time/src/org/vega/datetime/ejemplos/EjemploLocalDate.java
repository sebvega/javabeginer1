package org.vega.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class EjemploLocalDate {
    public static void main(String[] args) {

        LocalDate fechaActual= LocalDate.now();

        System.out.println("fechaActual = " + fechaActual);

        fechaActual=LocalDate.of(2021,1,1);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual=LocalDate.of(2021, Month.DECEMBER,31);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual=LocalDate.parse("2020-02-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate tomorrow=LocalDate.now().plusDays(1);
        System.out.println("tomorrow = " + tomorrow);

        LocalDate afterMonth=LocalDate.now().minus(1, ChronoUnit.MONTHS);//minusMonths(1);
        System.out.println("tomorrow = " + tomorrow);

        DayOfWeek miercoles=LocalDate.parse("2021-05-24").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

    }
}
