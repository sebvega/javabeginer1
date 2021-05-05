import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemasNumericosEntradaScaner {
    public static void main(String[] args) {


        Scanner scaner=new Scanner(System.in);
        System.out.println("ingrese un numero entero:");
        //String numeroStr= scaner.nextLine();
        int numeroDecimal=0;
        try {
            numeroDecimal= scaner.nextInt();//Integer.parseInt(numeroStr);
        }catch (InputMismatchException e){
            System.out.println("error, debe ingresar un numero entero");
            main(args);
            System.exit(0);
        }
        String mensajeBinario= "numero binario de = " + numeroDecimal+ " = " +Integer.toBinaryString(numeroDecimal);
        String mensajeOctal= "numero octal = " + numeroDecimal +" = "+ Integer.toOctalString(numeroDecimal);


        String mensaje= mensajeBinario;
        mensaje += "\n"+mensajeOctal;
        System.out.println(mensaje);
    }
}
