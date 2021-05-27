package org.vega.patrones.decorator2;

import org.vega.patrones.decorator2.decorador.ConChocholateDecorador;
import org.vega.patrones.decorator2.decorador.ConCremaDecorador;
import org.vega.patrones.decorator2.decorador.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(7, "Cafe Mokha");
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(conCrema);
        ConChocholateDecorador conCHoco = new ConChocholateDecorador(conLeche);

        System.out.println("el precio del cafe con moca es: " + conCHoco.getPrecioBase());
        System.out.println("los ingredientes del " + cafe + " son: " + conCHoco.getIngredientes());


        Configurable capuchino = new Cafe(4, "Cafe Capuchino");
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(conCrema);

        System.out.println("el precio del " + capuchino + " es: " + conLeche.getPrecioBase());
        System.out.println("los ingredientes del " + capuchino + " son: " + conLeche.getIngredientes());


        Configurable expresso=new Cafe(3,"Cafe Expresso");

        System.out.println("el precio del " + expresso + " es: " + expresso.getPrecioBase());
        System.out.println("los ingredientes del " + expresso + " son: " + expresso.getIngredientes());
    }
}
