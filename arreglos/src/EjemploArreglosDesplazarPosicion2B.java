import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2B {
    public static void main(String[] args) {

        int[] a = new int[10];
        int elemento, posicion, ultimo;
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            System.out.print("ingrese el numero: ");
            a[i] = s.nextInt();
        }
        System.out.println();
        System.out.println("ingrese el nuevo elemento");
        elemento = s.nextInt();
        System.out.println("ingrese la posicion donde agreagara de 0-9");
        posicion = s.nextInt();

        ultimo = a[a.length - 1];


        for (int i = a.length - 2; i >= posicion; i--) {
            a[i + 1] = a[i];
        }

        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, a.length);

        b[posicion] = elemento;
        b[b.length - 1] = ultimo;
        a=b;
        System.out.println("el arreglo termina como");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
