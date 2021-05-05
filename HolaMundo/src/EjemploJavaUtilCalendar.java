import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploJavaUtilCalendar {
    public static void main(String[] args) {

        Calendar calendario = Calendar.getInstance();

        calendario.set(Calendar.YEAR, 2020);
        calendario.set(Calendar.MONTH, 1);
        calendario.set(Calendar.DAY_OF_MONTH, 25);

        //calendario.set(2020,Calendar.JANUARY,25,12,22,1);
        Date fecha = calendario.getTime();

        //System.out.println("calendario = " + calendario);
        System.out.println("fecha = " + fecha);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy,MMMM,dd");
        System.out.println("formato = " + formato);
    }
}
