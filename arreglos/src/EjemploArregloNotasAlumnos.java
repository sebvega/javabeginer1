import java.util.Scanner;

public class EjemploArregloNotasAlumnos {
    public static void main(String[] args) {

        double sumMat = 0.0, sumFis = 0.0, sumBio = 0.0;
        double[] claseMatematica, claseFisica, claseBiologia;
        claseMatematica = new double[7];
        claseBiologia = new double[7];
        claseFisica = new double[7];

        Scanner s = new Scanner(System.in);
        System.out.println("ingrese las notas de cada estudiante en matematicas");
        for (int i = 0; i < claseMatematica.length; i++) {
            claseMatematica[i] = s.nextDouble();
        }
        System.out.println("ingrese las notas de cada estudiante en biologia");
        for (int i = 0; i < claseBiologia.length; i++) {
            claseBiologia[i] = s.nextDouble();
        }
        System.out.println("ingrese las notas de cada estudiante en fisica");
        for (int i = 0; i < claseFisica.length; i++) {
            claseFisica[i] = s.nextDouble();
        }
        for (int i = 0; i < claseBiologia.length; i++) {
            sumMat += claseMatematica[i];
            sumBio += claseBiologia[i];
            sumFis += claseFisica[i];
        }
        double promMat = sumMat / claseMatematica.length;
        double promBio = sumBio / claseBiologia.length;
        double promFis = sumFis / claseFisica.length;
        double promcurso = (promBio + promFis + promMat) / 3;
        System.out.println("Promedio de la clase de matematicas = " + promMat);
        System.out.println("Promedio de la clase de biologia = " + promBio);
        System.out.println("Promedio de la clase de fisica = " + promFis);
        System.out.println("Promedio del curso = " + promcurso);


        System.out.println("ingrese el ID entre 0-6");
        int id=s.nextInt();
        double promAlum=(claseMatematica[id]+claseBiologia[id]+claseFisica[id])/3;
        System.out.println("el promedio del almumno = "+promAlum);
    }
}
