package org.vega.appfacturacion;

import org.vega.appfacturacion.model.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.setNit(12345);
        cliente1.setNombre("paco");


        Scanner s = new Scanner(System.in);
        System.out.println("ingrese la descripcion de la factura: ");
        String desc = s.nextLine();
        Factura factura1 = new Factura(desc, cliente1);

        Producto producto1;

        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto1 = new Producto();
            System.out.print("Ingrese producto n° " + producto1.getCodigo() + ": ");
            producto1.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto1.setPrecio(s.nextDouble());

            System.out.print("Ingrese la cantidad: ");
            factura1.addItemFactura(new ItemFactura(s.nextInt(), producto1));
            System.out.println();
            s.nextLine();
        }
        System.out.println(factura1);

    }
}
