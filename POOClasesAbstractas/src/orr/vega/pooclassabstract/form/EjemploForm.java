package orr.vega.pooclassabstract.form;

import orr.vega.pooclassabstract.form.elementos.*;
import orr.vega.pooclassabstract.form.elementos.select.Opcion;
import orr.vega.pooclassabstract.form.validador.*;

import java.util.ArrayList;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());
        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));
        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());
        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("xp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {

            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre + "' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("hola que tal, este campo esta desabilitado");

        username.setValor("jhon.doe");
        password.setValor("123456");
        email.setValor("jhon@correo.com");
        edad.setValor("22");
        experiencia.setValor("mas de 10 años de experiencia");
        java.setSelected(true);


        List<ElementoForm> elemento = new ArrayList<>();

        elemento.add(username);
        elemento.add(password);
        elemento.add(email);
        elemento.add(edad);
        elemento.add(experiencia);
        elemento.add(lenguaje);
        elemento.add(saludar);

        for (ElementoForm e : elemento) {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
        elemento.forEach(e->{
            if (!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });

    }
}
