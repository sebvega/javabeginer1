import java.util.Scanner;

public class EjemploArreglosDetectarOrden {
    public static void main(String[] args) {

        int[] a = new int[7];

        Scanner s = new Scanner(System.in);
        System.out.println("ingrese 7 numeros");
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        boolean ascendente = false;
        boolean descendente = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                descendente=true;
            }
            if (a[i]<a[i+1]){
                ascendente=true;
            }
        }
        if (ascendente&&descendente){
            System.out.println("Arreglo = desordenado");
        }else if (ascendente){
            System.out.println("Arreglo = ascendente");
        }else if (descendente){
            System.out.println("Arreglo = descendente");
        }else {
            System.out.println("Arreglo = todos son iguales");
        }

    }
}
