public class HolaMundo {
    public static void main(String[] args){
        String saludar="Hola Mundo desde java";
        System.out.println(saludar);
        System.out.println("saludar.toUpperCase() = " + saludar.toUpperCase());

        int numero=10;

        boolean valor=true;
        if (valor){
            System.out.println("numero = " + numero);
        }
        String nombre;
        nombre="Sánchez Vega";
        if (numero>10){
            nombre="juan sebastian";
        }
        System.out.println("nombre = " + nombre);
    }

}
