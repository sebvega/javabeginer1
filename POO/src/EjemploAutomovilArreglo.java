import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {



//Mazda
        Persona conductorMazda=new Persona("sebastian","vega");
        Automovil Mazda = new Automovil("Mazda", "2019");
        Mazda.setColor(Color.AZUL);
        Mazda.setMotor(new Motor(2200,TipoMotor.GASOLINA));
        Mazda.setTipo(TipoAutomovil.SEDAN);
        Mazda.setPropietario(conductorMazda);

//Hiunday
        Persona conductorHiunday=new Persona("laura","mancilla");
        Automovil Hiunday = new Automovil("Hiunday", "i10");
        Hiunday.setMotor(new Motor(1100,TipoMotor.GASOLINA));
        Hiunday.setColor(Color.GRIS);
        Hiunday.setTipo(TipoAutomovil.HATCHBACK);
        Hiunday.setPropietario(conductorHiunday);

//Nissan1
        Persona conductorNissan1=new Persona("martha","cecilia");
        Automovil Nissan = new Automovil("Nissan", "frontier", Color.ROJO,
                new Motor(3000,TipoMotor.DIESEL),new Tanque(50));
        Nissan.setTipo(TipoAutomovil.PICKUP);
        Nissan.setPropietario(conductorNissan1);

//Chevrolet
        Persona conductorNissan2=new Persona("janeth","Lizcano");
        Automovil Nissan2 = new Automovil("Chevrolet", "aveo", Color.AMARILLO,
                new Motor(1200, TipoMotor.GASOLINA), new Tanque(44));
        Nissan2.setTipo(TipoAutomovil.COUPE);
        Nissan2.setPropietario(conductorNissan2);


//Audi
        Automovil Audi=new Automovil("Audi","A3");
        Audi.setPropietario(new Persona("pipe","zapata"));

        Automovil[] autos=new Automovil[5];
        autos[0]=Mazda;
        autos[1]=Hiunday;
        autos[2]=Nissan;
        autos[3]=Nissan2;
        autos[4]=Audi;


        Arrays.sort(autos);
        for (Automovil vehiculo : autos) {
            System.out.println(vehiculo);
        }
    }
}
