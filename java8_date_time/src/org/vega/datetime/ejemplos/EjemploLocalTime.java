package org.vega.datetime.ejemplos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EjemploLocalTime {
    public static void main(String[] args) {

        LocalTime ahora= LocalTime.now();
        System.out.println("ahora = " + ahora);
        System.out.println("ahora.getHour() = " + ahora.getHour());
        System.out.println("ahora.getMinute() = " + ahora.getMinute());
        System.out.println("ahora.getSecond() = " + ahora.getSecond());

        LocalTime ya=LocalTime.of(6,30);
        System.out.println("ya = " + ya);
        ya= LocalTime.parse("16:30:59");
        System.out.println("ya = " + ya);


        DateTimeFormatter df=DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormateado=ya.format(df);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        LocalTime max=LocalTime.MAX;
        System.out.println("max = " + max);
        LocalTime min=LocalTime.MIN;
        System.out.println("min = " + min);
        
    }
}
