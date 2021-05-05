class Persona {
    private String nombre;
    public void modificarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;

    }
    public String leerNombre() {
        return nombre;
    }
}
public class PasarPorReferencia2 {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.modificarNombre("andres");
        System.out.println("persona = " + persona.leerNombre());
        test(persona);
        System.out.println("persona = " + persona.leerNombre());
    }

    public static void test(Persona personita) {
        personita.modificarNombre("pepe");
    }
}
