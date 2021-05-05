import java.util.Scanner;

public class OperadorTernario {
    public static void main(String[] args) {

        String variable= 7==7? "es verdad":"es falso";
        System.out.println("variable = " + variable);

        String estado = "";
        double promedio = 0.0;
        double matematicas = 0.0;
        double historia = 0.0;
        double ciencias = 0.0;

        Scanner scanner=new Scanner(System.in);
        System.out.println("ingrese la nota de matematicas");
        matematicas=scanner.nextDouble();
        System.out.println("ingrese la nota de historia");
        historia=scanner.nextDouble();
        System.out.println("ingrese la nota de ciencias");
        ciencias=scanner.nextDouble();

        promedio=(matematicas+historia+ciencias)/3;
        estado =promedio>=5.49?"Aprobado":"Rechazado";
        System.out.println("estado = " + estado);

    }
}
