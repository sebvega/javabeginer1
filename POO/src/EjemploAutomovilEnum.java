public class EjemploAutomovilEnum {
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


        TipoAutomovil tipo = Mazda.getTipo();
        System.out.println("modelo Mazda " + tipo.getNombre());
        System.out.println("tipo Mazda " + tipo.getDescripcion());

        tipo=Hiunday.getTipo();
        switch (tipo) {
            case CONVERTIBLE -> System.out.println("El auto es deportivo y descapotable de dos puertas");
            case COUPE -> System.out.println("Es un automovil de dos puertas y tipicamente deportivo");
            case FURGOM -> System.out.println("Es tunn automovil utilitario de transporte, de empresas");
            case HATCHBACK -> System.out.println("Es un automovil mediano compacto, con aspecto deportivo");
            case PICKUP -> System.out.println("Es un automovil tipo camioneta");
            case SEDAN -> System.out.println("Es un automovil mediano");
            case STATION_WAGON -> System.out.println("Es un automovil mas grande, con maleta grande");
        }

        TipoAutomovil[] tipos=TipoAutomovil.values();

        for (TipoAutomovil ta:tipos ) {
            System.out.print(ta+" => "+ta.name() + ", "+
                    ta.getNombre()+", "+
                    ta.getDescripcion()+", "+
                    ta.getNumeroPuertas());
            System.out.println();
            System.out.println();
        }


    }
}
