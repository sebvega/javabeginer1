import java.lang.reflect.Method;

public class EjemploMetodoGetClass {
    public static void main(String[] args) {

        String texto = "hola que tal";
        Class strClass = texto.getClass();
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getName() = " + strClass.getSimpleName());
        System.out.println("strClass.getName() = " + strClass.getPackageName());
        
        for(Method metido: strClass.getMethods()){
            System.out.println("metido.getName() = " + metido.getName());
        }
        
        Integer num=34;
        Class intClass= num.getClass();
        System.out.println("intClass.getName() = " + intClass.getName());
    }
}
