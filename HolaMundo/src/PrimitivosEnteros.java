public class PrimitivosEnteros {
    public static void main(String[] args) {
        byte numeroByte=127;
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("tipo byte corresponde en byte a "+Byte.BYTES);
        System.out.println("tipo byte corresponde en bites a "+Byte.SIZE);
        System.out.println("valor maximo de un byte "+Byte.MAX_VALUE);
        System.out.println("valor minimo de un byte "+Byte.MIN_VALUE);

        short numeroShort=32767;
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("tipo Short corresponde en byte a "+ Short.BYTES);
        System.out.println("tipo Short corresponde en bites a "+ Short.SIZE);
        System.out.println("valor maximo de un Short "+ Short.MAX_VALUE);
        System.out.println("valor mínimo de un Short "+ Short.MIN_VALUE);

        int numeroInt=2147483647;
        System.out.println("numeroInt = " + numeroInt);
        System.out.println("tipo int corresponde en byte a "+ Integer.BYTES);
        System.out.println("tipo int corresponde en bites a "+ Integer.SIZE);
        System.out.println("valor maximo de un int "+ Integer.MAX_VALUE);
        System.out.println("valor mínimo de un int "+ Integer.MIN_VALUE);

        long numeroLong = 9223372036854775807L;
        System.out.println("numeroLong = " + numeroLong);
        System.out.println("tipo Long corresponde en byte a "+ Long.BYTES);
        System.out.println("tipo Long corresponde en bites a "+ Long.SIZE);
        System.out.println("valor maximo de un Long "+ Long.MAX_VALUE);
        System.out.println("valor mínimo de un Long "+ Long.MIN_VALUE);

        var numeroVar=127;

    }
}
