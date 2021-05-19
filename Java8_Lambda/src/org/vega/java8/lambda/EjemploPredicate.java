package org.vega.java8.lambda;

import org.vega.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = num -> num > 10;
        boolean res = test.test(7);
        System.out.println("res = " + res);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(test2.test("ROLE:ASSISTANT"));

        BiPredicate<String, String> test3 = String::equals;//(a,b)->a.equals(b);
        System.out.println("test3 = " + test3.test("hola", "hola"));

        BiPredicate<Integer, Integer> test4 = (a, b) -> b > a;
        boolean r2 = test4.test(4, 3);
        System.out.println("r2 = " + r2);

        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();
        user1.setNombre("pablo");
        user2.setNombre("angela");

        BiPredicate<Usuario, Usuario> test5=(a,b)->a.getNombre().equals(b.getNombre());
        System.out.println(test5.test(user1,user2));

    }
}
