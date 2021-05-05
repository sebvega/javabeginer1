import java.util.Map;

public class EjemploVariablesEntorno {
    public static void main(String[] args) {

        Map<String,String> varEnv=System.getenv();
        System.out.println("variables de ambiente del sistema = " + varEnv);

        System.out.println("--------listando variables de entorno del sistema--------");
        for (String key:varEnv.keySet()){
            System.out.println(key+ " => "+varEnv.get(key));
        }

        String username =System.getenv("USERNAME");
        System.out.println("username = " + username);

        String javaHome =System.getenv("JAVA_HOME");
        System.out.println("javaHome = " + javaHome);

        String temDir =System.getenv("TEMP");
        System.out.println("javaHome = " + temDir);

        String pathDir =System.getenv("PATH");
        System.out.println("javaHome = " + pathDir);

        String pathDir2 =varEnv.get("Path");
        System.out.println("javaHome = " + pathDir2);
    }
}
