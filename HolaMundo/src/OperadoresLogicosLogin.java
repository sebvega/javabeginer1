import java.util.Scanner;

public class OperadoresLogicosLogin {
    public static void main(String[] args) {


        /*String[] userNames = new String[2];
        String[] passwords=new String[2];
        userNames[0]= "vega";
        passwords[0]= "1234";

        userNames[1]= "andres";
        passwords[1]= "1234";
*/
        String[] userNames = {"vega,andres,admin"};
        String[] passwords= {"1234,12345,123456"};

        Scanner scanner =new Scanner(System.in);
        System.out.println("ingrese el usuario");

        String usuario = scanner.nextLine();
        System.out.println("ingrese la contraseña");
        String contra = scanner.next();

        boolean esAutenticado = false;

        for(int i=0;i<userNames.length;i++){
            if (usuario.equals(userNames[i]) && contra.equals(passwords[i])) {
                esAutenticado=true;
                break;
            }
        }
        if (esAutenticado){
            System.out.println("bienbenido usuario ".concat(usuario).concat("!"));
        }else {
            System.out.println("username or password is wrong");
            System.out.println("suerte");
        }
    }
}
