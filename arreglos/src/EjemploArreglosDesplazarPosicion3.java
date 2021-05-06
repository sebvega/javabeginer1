import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion3 {
    public static void main(String[] args) {

        int[] a = new int[7];
        int elemento, posicion = 0;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < a.length - 1; i++) {
            System.out.print("ingrese el numero: ");
            a[i] = s.nextInt();
        }
        System.out.println();
        System.out.println("ingrese el nuevo elemento");
        elemento = s.nextInt();


        while (posicion < a.length - 1 && elemento > a[posicion]) {
            posicion++;

        }


        for (int i = a.length - 2; i >= posicion; i--) {
            a[i + 1] = a[i];
        }
        a[posicion] = elemento;
        System.out.println("el arreglo termina como");
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + " => " + a[i]);
            ;
        }
    }
}
