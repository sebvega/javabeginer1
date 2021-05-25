package org.vega.recursividad.ejemplo;

import org.vega.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecirsividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete PC ATX");
        Componente poder = new Componente("Fuente de Poder 700W");
        Componente motherBoard = new Componente("MainBoard Asus Socket AMD");
        Componente cpu = new Componente("Ryzen 5 2500H");
        Componente ventilador = new Componente("ventilador CPU");
        Componente disipador = new Componente("Disipador solido");
        Componente tg = new Componente("Nvidia RTX 3080 16GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente vRam0 = new Componente("8GB Ram");
        Componente vRam1 = new Componente("8GB Ram");
        Componente gpuVentiladoes = new Componente("ventiladores");
        Componente ram = new Componente("Memoria Ram 32GB");
        Componente ssd = new Componente("SSD 2TB");

        cpu.addComponente(ventilador)
                .addComponente(disipador);
        tg.addComponente(gpu)
                .addComponente(vRam0)
                .addComponente(vRam1)
                .addComponente(gpuVentiladoes);
        motherBoard.addComponente(cpu)
                .addComponente(tg)
                .addComponente(ram)
                .addComponente(ssd);
        pc.addComponente(poder)
                .addComponente(motherBoard)
                .addComponente(new Componente("Monitor"));

        metodoRecursivoJava8(pc,0)
                .forEach(c-> System.out.println("- ".repeat(c.getNivel())+c.getNombre()));

    }

    public static Stream<Componente> metodoRecursivoJava8(Componente c, int nivel){
        c.setNivel(nivel);
        return Stream.concat(Stream.of(c),
                c.getHijos().stream().flatMap(hijo->metodoRecursivoJava8(hijo,nivel+1)));

    }
    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("- ".repeat(nivel)+c.getNombre());
        if (c.tieneHijos()){
            for (Componente hijo:c.getHijos()){
                metodoRecursivo(hijo,nivel++);
            }
        }
    }
}
