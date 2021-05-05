import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EjemploJavaUtilDateParse {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy,MM,dd");
        System.out.println("ingrese una fecha con el formato = yyyy,MM,dd");
        try {
            Date fecha = format.parse(s.nextLine());
            System.out.println("fecha = " + fecha);
            System.out.println("format = " + format.format(fecha));

            Date fecha2=new Date();
            System.out.println("fecha2 = " + fecha2);
            if (fecha.after(fecha2)){
                System.out.println("fecha del usuario es despues de la fecha2");
            }else if(fecha.before(fecha2)){
                System.out.println("fecha es anterior que fecha2");
            }
            else if (fecha.equals(fecha2)){
                System.out.println("son la misma fecha");
            }

            if (fecha.compareTo(fecha2)>0){
                System.out.println("fecha del usuario es despues de la fecha2");
            }else if(fecha.compareTo(fecha2)<0){
                 System.out.println("fecha es anterior que fecha2");
            }else {
                System.out.println("son la misma fecha");
            }



        } catch (ParseException e) {
            //e.printStackTrace();
            System.err.println("la fecha tiene un formato incorrecto " + e.getMessage());
        }


    }
}
