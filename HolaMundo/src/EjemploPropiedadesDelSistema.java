import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EjemploPropiedadesDelSistema {
    public static void main(String[] args) {

        try {
            FileInputStream archivo = new FileInputStream("src/config.properties");
            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada"," ni valor guardado en el objeto properties");

            System.setProperties(p);
            System.getProperties().list(System.out);

            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.autor.email"));



        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("no existe el archivo" + e);
        }

    }
}
