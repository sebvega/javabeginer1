import java.util.Scanner;

public class EjemploArreglosBuscarNumero {
    public static void main(String[] args) {

        int[] a = new int[10];
        int i = 0;
        Scanner s = new Scanner(System.in);

        for (i = 0; i < a.length; i++) {
            System.out.print("ingrese un numero: ");
            a[i] = s.nextInt();
        }
        System.out.println("\ningrese un numero a buscar");
        int num = s.nextInt();
        i = 0;
        while ((i < a.length) && (a[i]!=num)) {
            i++;
        }
        if (i==a.length) {
            System.out.println("no se encontro el numero");
        } else if (a[i]==num) {
            System.out.println("el numero fue encontrado en " + i);
        }

    }
}
