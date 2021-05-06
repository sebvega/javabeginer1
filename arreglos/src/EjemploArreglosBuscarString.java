import java.util.Scanner;

public class EjemploArreglosBuscarString {
    public static void main(String[] args) {

        String[] a = new String[4];
        int i = 0;
        Scanner s = new Scanner(System.in);

        for (i = 0; i < a.length; i++) {
            System.out.print("ingrese un nombre: ");
            a[i] = s.nextLine();
        }
        System.out.println("\ningrese un nombre a buscar");
        String num = s.nextLine();
        i = 0;
        while ((i < a.length) && !(a[i].equalsIgnoreCase(num))) {
            i++;
        }
        if (i==a.length) {
            System.out.println("no se encontro el numero");
        } else if (a[i].equalsIgnoreCase(num)) {
            System.out.println("el numero fue encontrado en " + i);
        }

    }
}
