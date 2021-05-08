public class EjemploAutomovilRelacionesObjetos {
    public static void main(String[] args) {




        Persona conductorMazda=new Persona("sebastian","vega");
        Automovil Mazda = new Automovil("mazda", "2019");
        Mazda.setColor(Color.AZUL);
        Mazda.setMotor(new Motor(2200,TipoMotor.GASOLINA));
        Mazda.setTipo(TipoAutomovil.SEDAN);
        Mazda.setPropietario(conductorMazda);
        //Mazda.setRuedas(ruedasMaz);


        Rueda[] ruedasMaz= new Rueda[5];
        for (int i=0;i<ruedasMaz.length;i++){
            Mazda.addRueda(new Rueda("michellin",15,75));
        }




        Persona conductorHiunday=new Persona("laura","mancilla");
        Automovil Hiunday = new Automovil("hiunday", "i10");
        Hiunday.setMotor(new Motor(1100,TipoMotor.GASOLINA));
        Hiunday.setColor(Color.GRIS);
        Hiunday.setTipo(TipoAutomovil.HATCHBACK);
        Hiunday.setPropietario(conductorHiunday);
        //Hiunday.setRuedas(ruedasHiun);

        Hiunday.addRueda(new Rueda("Yokohama",15,55))
        .addRueda(new Rueda("Yokohama",15,55))
        .addRueda(new Rueda("Yokohama",15,55))
        .addRueda(new Rueda("Yokohama",15,55))
        .addRueda(new Rueda("Yokohama",15,55));


       /* Rueda[] ruedasHiun= new Rueda[5];
        for (int i=0;i<ruedasHiun.length;i++){
            Hiunday.addRueda(new Rueda("Yokohama",15,55));
        }*/




        Persona conductorNissan1=new Persona("martha","cecilia");
        Automovil Nissan = new Automovil("nissan", "frontier", Color.ROJO,
                new Motor(3000,TipoMotor.DIESEL),new Tanque(50));
        Nissan.setTipo(TipoAutomovil.PICKUP);
        Nissan.setPropietario(conductorNissan1);
        //Nissan.setRuedas(ruedasNis1);


        Rueda[] ruedasNis1= new Rueda[5];
        for (int i=0;i<ruedasNis1.length;i++){
            Nissan.addRueda(new Rueda("chinesse",18,75));
        }




        Persona conductorNissan2=new Persona("janeth","Lizcano");
        Automovil Nissan2 = new Automovil("nissan", "KqWai", Color.AMARILLO,
                new Motor(3000, TipoMotor.DIESEL), new Tanque(44));
        Nissan2.setTipo(TipoAutomovil.COUPE);
        Nissan2.setPropietario(conductorNissan2);
        Automovil auto = new Automovil();
        //Nissan2.setRuedas(ruedasNis2);


        Rueda[] ruedasNis2= new Rueda[5];
        for (int i=0;i<ruedasNis2.length;i++){
            Nissan2.addRueda(new Rueda("michellin",15,75));
        }


        System.out.println(Mazda.detalle());
        System.out.println(Hiunday.detalle());
        System.out.println(Nissan.detalle());
        System.out.println(Nissan2.detalle());

        System.out.println("conductor de Mazda: "+Mazda.getPropietario());
        System.out.println("");
        for(Rueda r:Mazda.getRuedas()){
            System.out.println("Fabricante: "+r.getFabricante()+", Rin: "+r.getRin()+", Ancho: "+r.getAncho());
        }



    }
}
