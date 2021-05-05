public class WrapperBoolean {
    public static void main(String[] args) {

        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        boolean primiBoolean=num1>num2;
        Boolean objecBoolean=Boolean.valueOf(primiBoolean);
        Boolean objecBoolean2=Boolean.valueOf("false");


        System.out.println("primiBoolean = " + primiBoolean);
        System.out.println("objecBoolean = " + objecBoolean);
        System.out.println("objecBoolean2 = " + objecBoolean2);
    }
}
