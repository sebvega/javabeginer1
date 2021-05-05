import javax.swing.*;

public class SistemasNumericos {
    public static void main(String[] args) {
        String numeroStr= JOptionPane.showInputDialog(null,"ingrese un numero entero");
        int numeroDecimal=0;
        try {
            numeroDecimal= Integer.parseInt(numeroStr);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"eror, debe ingresar un numero entero");
            main(args);
            System.exit(0);
        }

        System.out.println("numeroDecimal = " + numeroDecimal);
        String mensajeBinario= "numero binario de = " + numeroDecimal+ " = " +Integer.toBinaryString(numeroDecimal);
        System.out.println(mensajeBinario);

        int numeroBinario = 0b111110100;
        String mensajeOctal= "numero octal = " + numeroBinario +" = "+ Integer.toOctalString(numeroBinario);
        System.out.println("numeroBinario = " + numeroBinario);
        System.out.println(mensajeOctal);

        int numeroOctal= 0764;
        System.out.println("numeroOctal = " + numeroOctal);
        System.out.println("numero hexadecimal de  = " + numeroOctal + " = " + Integer.toHexString(numeroOctal));

        int numeroHex= 0x1f4;
        System.out.println("numeroHex = " + numeroHex);

        String mensaje= mensajeBinario;
        mensaje += "\n"+mensajeOctal;
        JOptionPane.showMessageDialog(null,mensaje);
    }
}
