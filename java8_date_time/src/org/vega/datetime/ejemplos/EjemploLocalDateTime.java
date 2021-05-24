package org.vega.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaTiempo=LocalDateTime.now();

        fechaTiempo=LocalDateTime.of(2021, Month.DECEMBER,30,12,12,30);
        System.out.println("fechaTiempo = " + fechaTiempo);

        Month mes=fechaTiempo.getMonth();
        System.out.println("mes = " + mes);
        int dia=fechaTiempo.getDayOfMonth();
        System.out.println("dia = " + dia);

        String formato1=fechaTiempo.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("formato1 = " + formato1);
        String formato2=fechaTiempo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("formato2 = " + formato2);

    }
}
