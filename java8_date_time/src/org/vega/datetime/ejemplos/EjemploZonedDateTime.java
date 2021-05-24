package org.vega.datetime.ejemplos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class EjemploZonedDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.now();

        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal, newYork);
        System.out.println("Zona horaria de new york: " + zonaNy);

        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonnamadrid = zonaNy.withZoneSameInstant(madrid).plusHours(13);
        System.out.println("Zona horaria de madrid: " + zonnamadrid);


        DateTimeFormatter fnm=DateTimeFormatter.ofPattern("HH:mm, dd MM yyyy");
        System.out.println("detalles del viaje: ");
        System.out.println("partida NY: "+fnm.format(zonaNy));
        System.out.println("partida MD: "+fnm.format(zonnamadrid));



    }
}
