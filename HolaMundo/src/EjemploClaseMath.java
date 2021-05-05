import java.util.Random;

public class EjemploClaseMath {
    public static void main(String[] args) {

        int absoluto =Math.abs(-3);
        System.out.println("absoluto = " + absoluto);

        double max=Math.max(3.5D,3.3D);

        double techo=Math.ceil(3.2);

        double puso=Math.floor(3.9);

        double redondo=Math.round(3.499);
        
        double exp= Math.exp(Math.PI);
        System.out.println("exp = " + exp);

        double log= Math.toDegrees(1.57);
        System.out.println("log = " + log);


        Random randomObj=new Random();

        int randomInt=randomObj.nextInt();



    }
}
