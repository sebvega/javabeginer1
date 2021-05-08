public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil.setCapacidadTanqueEstatico(45);
        Automovil Mazda = new Automovil("mazda", "2019");


        Mazda.setColor(Color.AZUL);
        Mazda.setMotor(new Motor(2200,TipoMotor.GASOLINA));

        Mazda.setTipo(TipoAutomovil.SEDAN);

        Automovil Hiunday = new Automovil("hiunday", "i10");
        Hiunday.setMotor(new Motor(1100,TipoMotor.GASOLINA));
        Hiunday.setColor(Color.GRIS);
        Hiunday.setTipo(TipoAutomovil.HATCHBACK);
        Automovil Nissan = new Automovil("nissan", "frontier", Color.ROJO,
                new Motor(3000,TipoMotor.DIESEL),new Tanque(50));
        Nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil Nissan2 = new Automovil("nissan", "KqWai", Color.AMARILLO,
                new Motor(3000, TipoMotor.DIESEL), new Tanque(44));
        Nissan2.setTipo(TipoAutomovil.COUPE);
        Automovil auto = new Automovil();

        System.out.println("Nissan = " + Nissan);
        System.out.println("Nissan2 = " + Nissan2);
        System.out.println("Hiunday = " + Hiunday);
        System.out.println("Mazda = " + Mazda);


        System.out.println(Automovil.VEL_MAX_CARRETERA);

        Automovil.setColorPatenete(Color.AZUL);
        System.out.println(Automovil.getColorPatenete());
        System.out.println();
        System.out.println(Mazda.detalle());
        System.out.println();
        System.out.println(Hiunday.detalle());
        System.out.println();
        System.out.println(Nissan.detalle());
        System.out.println("kilometros por litros = " + Automovil.calcularConsumoEstatico(300, 0.6f));
        System.out.println("kilometros por litros = " + Nissan.calcularConsumoEstatico(300, 0.6f));
        System.out.println(Automovil.getColorPatenete().getColor());


        TipoAutomovil tipoMazda = Mazda.getTipo();
        System.out.println("modelo Mazda " + tipoMazda.getNombre());
        System.out.println("tipo Mazda " + tipoMazda.getDescripcion());


    }
}
