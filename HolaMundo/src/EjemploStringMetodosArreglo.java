public class EjemploStringMetodosArreglo {
    public static void main(String[] args) {

        String trabalengua = "trabalenguas";
        System.out.println("trabalengua.length() = " + trabalengua.length());
        System.out.println("trabalengua.toCharArray() = " + trabalengua.toCharArray());

        char[] arreglo = trabalengua.toCharArray();
        int largo = arreglo.length;
        System.out.println("largo = " + largo);
        for (int i = 0; i < largo; i++) {
            System.out.print(arreglo[i]);
        }
        System.out.println();
        System.out.println("trabalengua = " + trabalengua.split("a"));

        String[] arreglo2 = trabalengua.split("a");
        int l = arreglo2.length;
        for (int i=0; i<l;i++){
            System.out.println("arreglo2 = " + arreglo2[i]);
        }
        String archivo = "alguna.imagen.pdf";
        String[] archivoArr= archivo.split("\\.");
        l = archivoArr.length;
        for (int i=0; i<l;i++){
            System.out.println("arreglo2 = " + archivoArr[i]);
        }
        System.out.println("archivoArr[l-1] = " + archivoArr[l-1]);
    }
}
