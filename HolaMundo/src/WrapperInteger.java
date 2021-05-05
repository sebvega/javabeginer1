public class WrapperInteger {
    public static void main(String[] args) {

        int primitivo = 32768;
        Integer intObject = Integer.valueOf(primitivo);
        Integer intObject2 = 32768;
        System.out.println("intObject = " + intObject);

        int num = intObject;
        System.out.println("num = " + num);
        int num2 = intObject.intValue();
        System.out.println("num2 = " + num2);

        String valorTvLcd= "67000";
        Integer valor =Integer.valueOf(valorTvLcd);
        System.out.println("valor = " + valor);

        Short shortObjet= 32767;
    }
}
