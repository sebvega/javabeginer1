package org.vega.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println(((Animal) a).getNombre() + " tipo: " + ((Animal) a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            }
        }
    }

    public static void main(String[] args) {

        Camion<Animal> transCaballos = new Camion<>(5);
        transCaballos.add(new Animal("lazi", "caballo"));
        transCaballos.add(new Animal("tiro al blanco", "caballo"));
        transCaballos.add(new Animal("Dunkan", "caballo"));
        transCaballos.add(new Animal("rayo", "caballo"));
        transCaballos.add(new Animal("rosa", "caballo"));

        imprimirCamion(transCaballos);
        System.out.println();
/*
        for (Animal a : transCaballos) {
            System.out.println(a.getNombre() + " tipo: " + a.getTipo());
        }
*/
        Camion<Maquinaria> transMaq = new Camion<>(3);
        transMaq.add(new Maquinaria("Buldozer"));
        transMaq.add(new Maquinaria("Grua"));
        transMaq.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaq);
        System.out.println();
       /*
        for (Maquinaria m : transMaq) {
            System.out.println(m.getTipo());
        }
*/
        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Renault"));
        transAuto.add(new Automovil("Citroen"));
        transAuto.add(new Automovil("Mazda"));

        imprimirCamion(transAuto);
        System.out.println();
        /*
        for (Automovil a : transAuto) {
            System.out.println(a.getMarca());
        }*/
    }
}
