import javax.swing.*;

public class SentenciaForArreglo {
    public static void main(String[] args) {

        String[] nombres = {"andres", "pepe", "maria", "paco", "lalo"};
        int count=nombres.length;
        for (int i = 0; i < count; i++) {
            if (nombres[i].equalsIgnoreCase("andres") ||
                    nombres[i].equalsIgnoreCase("pepe")){
                continue;
            }
            System.out.println(i+".-"+nombres[i]);
        }
        String buscar= JOptionPane.showInputDialog("ingrese un nombre, ejm \"pepe\" o \"maria\"");
        System.out.println("buscar = " + buscar);
        boolean encontrado = false;
        for (int i=0;i<count;i++){
            if(nombres[i].equalsIgnoreCase(buscar)){
                encontrado=true;
                break;
            }
        }
        if (encontrado){
            JOptionPane.showMessageDialog(null, "fue encontrado " + buscar);
        }else{
            JOptionPane.showMessageDialog(null, "no existe en el sistema " + buscar);
        }



    }
}
