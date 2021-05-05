public class SentenciaWhile {
    public static void main(String[] args) {

        int i=0;
        while (i<5){
            System.out.println("i = " + i);
            i++;
        }
        boolean prueba=true;
        i=0;
        while (prueba){
            if(i==7){
                prueba=false;
            }
            System.out.println("i = " + i);
            i++;
        }
        do {
            System.out.println("solo una vez");
            i=1;
        }while (i!=1);
    }
}
