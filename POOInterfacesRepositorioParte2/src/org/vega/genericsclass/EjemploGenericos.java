package org.vega.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(org.vega.genericsclass.Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof org.vega.genericsclass.Animal) {
                System.out.println(((org.vega.genericsclass.Animal) a).getNombre() + " tipo: " + ((org.vega.genericsclass.Animal) a).getTipo());
            } else if (a instanceof org.vega.genericsclass.Automovil) {
                System.out.println(((org.vega.genericsclass.Automovil) a).getMarca());
            } else if (a instanceof org.vega.genericsclass.Maquinaria) {
                System.out.println(((org.vega.genericsclass.Maquinaria) a).getTipo());
            }
        }
    }

    public static void main(String[] args) {

        org.vega.genericsclass.Camion<org.vega.genericsclass.Animal> transCaballos = new org.vega.genericsclass.Camion<>(5);
        transCaballos.add(new org.vega.genericsclass.Animal("lazi", "caballo"));
        transCaballos.add(new org.vega.genericsclass.Animal("tiro al blanco", "caballo"));
        transCaballos.add(new org.vega.genericsclass.Animal("Dunkan", "caballo"));
        transCaballos.add(new org.vega.genericsclass.Animal("rayo", "caballo"));
        transCaballos.add(new Animal("rosa", "caballo"));

        imprimirCamion(transCaballos);
        System.out.println();
/*
        for (Animal a : transCaballos) {
            System.out.println(a.getNombre() + " tipo: " + a.getTipo());
        }
*/
        org.vega.genericsclass.Camion<org.vega.genericsclass.Maquinaria> transMaq = new org.vega.genericsclass.Camion<>(3);
        transMaq.add(new org.vega.genericsclass.Maquinaria("Buldozer"));
        transMaq.add(new org.vega.genericsclass.Maquinaria("Grua"));
        transMaq.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaq);
        System.out.println();
       /*
        for (Maquinaria m : transMaq) {
            System.out.println(m.getTipo());
        }
*/
        org.vega.genericsclass.Camion<org.vega.genericsclass.Automovil> transAuto = new Camion<>(3);
        transAuto.add(new org.vega.genericsclass.Automovil("Renault"));
        transAuto.add(new org.vega.genericsclass.Automovil("Citroen"));
        transAuto.add(new Automovil("Mazda"));

        imprimirCamion(transAuto);
        System.out.println();
        /*
        for (Automovil a : transAuto) {
            System.out.println(a.getMarca());
        }*/
    }
}
