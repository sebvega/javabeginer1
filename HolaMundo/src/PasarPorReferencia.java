public class PasarPorReferencia {
    public static void main(String[] args) {

        int[] edad = {10, 11, 12};
        System.out.println("iniciamos el metodo main  = " );
        for (int i : edad) {
            System.out.println("edad = " + i);
        }
        System.out.println(" Antes de llamar al metodo test ");
        test(edad);
        System.out.println(" Despues de llamar al metodo test ");

        for (int i : edad) {
            System.out.println("edad = " + i);
        }

        System.out.println("finaliza el metodo main  = ");
    }

    public static void test(int[] edadArr) {
int j=0;
        System.out.println("iniciamos el metodo test = " );
        for (int i : edadArr) {

            edadArr[j++]=i+20;
        }
        System.out.println("finaliza el metodo test = ");


    }
}
