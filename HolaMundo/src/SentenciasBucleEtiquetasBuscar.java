public class SentenciasBucleEtiquetasBuscar {
    public static void main(String[] args) {

        String frase = "tres tristes trigres tragaban trigo en un trigal";
        String palabra = "trigo";
        int max = frase.length(), maxPalabra = palabra.length(), cantidad = 0;
        for (int i = 0; i < max; i++) {
            for (int j=0; j < maxPalabra; j++) {
                if (frase.charAt(i) != 't') {
                    continue;
                }
                cantidad++;
            }
        }
        System.out.println("cantidad = " + cantidad);
    }
}
