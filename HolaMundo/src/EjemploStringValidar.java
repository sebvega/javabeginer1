import java.util.Locale;

public class EjemploStringValidar {
    public static void main(String[] args) {
        String curso = null;
        boolean esNullo = curso == null;
        System.out.println("esNullo = " + esNullo);
        if (esNullo){
            curso = "Programación Java";
        }

        boolean esVacio = curso.length()==0;
        boolean esVacio2 = curso.isEmpty();
        boolean esVacio3 = curso.isBlank();
        if (esVacio=false){

            System.out.println(curso.toUpperCase());
            System.out.println(curso.concat("desde cero"));
        }

    }
}
