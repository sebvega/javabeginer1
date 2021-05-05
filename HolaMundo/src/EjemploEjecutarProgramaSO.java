import java.io.IOException;

public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {

        Runtime rt=Runtime.getRuntime();
        Process proceso;

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                proceso = rt.exec("notepad");
            }else{
                proceso=rt.exec("gedit");
            }
            proceso.waitFor();
        } catch (Exception e) {
            System.err.println("el comando es desconocido"+ e.getMessage());
            System.exit(1);
        }
        System.out.println("se ha cerrado el editor");


    }
}
