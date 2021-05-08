import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {

        Automovil Mazda = new Automovil("mazda", "2019");

        Date fecha = new Date();

        Mazda.setColor(Color.AMARILLO);
        Mazda.setMotor(new Motor(2200, TipoMotor.GASOLINA));
        Mazda.setTanqueComb(new Tanque(38));


        Automovil Hiunday = new Automovil("hiunday", "i10");
        Hiunday.setMotor(new Motor(1100, TipoMotor.GASOLINA));
        Hiunday.setColor(Color.GRIS);

        Automovil Nissan = new Automovil("nissan", "frontier", Color.BLANCO,
                new Motor(3000, TipoMotor.DIESEL), new Tanque());
        Automovil Nissan2 = new Automovil("nissan", "frontier", Color.AMARILLO,
                new Motor(3000, TipoMotor.DIESEL), new Tanque(44));

        Automovil auto = new Automovil();

        System.out.println(auto.equals(Nissan));
        System.out.println(Nissan2.equals(Nissan));

        System.out.println(Nissan);
        System.out.println(Nissan.toString());


        Mazda.detalle();
        System.out.println("Mazda = " + Mazda.detalle());
        System.out.println("Mazda = " + Mazda.acelerar(3000));
        System.out.println("Mazda = " + Mazda.acelerarFrenar(4000));
        System.out.println();

//        System.out.println("kilometros por litro " + Hiunday.calcularConsumo(300, 0.75f));

    }
}
