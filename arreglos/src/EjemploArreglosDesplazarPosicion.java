import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion {
    public static void main(String[] args) {

        int[] a=new int[10];
        Scanner s= new Scanner(System.in);

        for (int i=0;i<a.length;i++){
            System.out.print("ingrese el numero: ");
            a[i]=s.nextInt();
        }

        int temp=a[a.length-1];

        for (int i=a.length-2;i>=0;i--){
            a[i+1]=a[i];
        }
        a[0]=temp;
        for (int i=0;i<a.length;i++){
            System.out.println("el arreglo termina como");
            System.out.println(a[i]);;
        }
    }
}
