public class EjemploStringConcatenacion {
    public static void main(String[] args) {
        String curso = "Programación Java";
        String profesor = "Andrés Guzmán";

        String detalle = curso + " con el instructor " + profesor;
        System.out.println("detalle = " + detalle);

        int a = 10;
        int b=5;

        System.out.println(detalle + (a + b));
        System.out.println(a + b + detalle);

        String detalle2 = curso.concat(" con ").concat(profesor);
    }
}
