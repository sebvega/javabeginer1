package org.svega.app.jardin;

import org.svega.app.hogar.*;
import static org.svega.app.hogar.Persona.saludar;
import static org.svega.app.hogar.Persona.GENERO_FEMENINO;
import static org.svega.app.hogar.Persona.GENERO_MASCULINO;

public class EjemploPaguetes {
    public static void main(String[] args) {
        Persona p= new Persona();
        p.setNombre("andres");
        p.setApellido("zapata");
        p.setColorPelo(ColorPelo.CAFE);
        System.out.println(p.getNombre());

        Perro polcito=new Perro();
        polcito.nombre="pool";
        polcito.raza="labrador";


        String jugando=polcito.jugar(p);
        System.out.println("jugando = " + jugando);
        String saludo=saludar();
        System.out.println("saludo = " + saludo);
        String generoMujer=GENERO_FEMENINO;




    }
}
