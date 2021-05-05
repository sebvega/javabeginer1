public class PasarPorValor {
    public static void main(String[] args) {

        int i = 10,j=0;
        System.out.println("iniciamos main con i = " + i);
        test(i);
        System.out.println("finaliza el metodo main con el valor de i = "+i);
    }

    public static void test(int i){
        System.out.println("iniciamos el metodo test con i = "+i);
        i=35;
        System.out.println("i ahora es = " + i);


    }
}
