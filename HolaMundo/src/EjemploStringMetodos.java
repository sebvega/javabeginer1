import java.util.Locale;

public class EjemploStringMetodos {
    public static void main(String[] args) {
        String nombre = "Andres";

        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.equals(\"Andres\") = " + nombre.equals("Andres"));
        System.out.println("nombre.equals(\"andres\") = " + nombre.equals("andres"));
        System.out.println("nombre.equalsIgnoreCase(\"andres\") = " + nombre.equalsIgnoreCase("andres"));
        System.out.println("nombre.compareTo(\"Andres\") = " + nombre.compareTo("Andres"));

        String trabalengua = "trabalenguas";
        System.out.println(trabalengua.replace("a","."));
        System.out.println(trabalengua.indexOf("a"));
        System.out.println(trabalengua.lastIndexOf("a"));
        System.out.println(trabalengua.contains("a"));
        System.out.println("  trabalenguas  ".trim());
    }
}
