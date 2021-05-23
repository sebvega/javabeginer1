package org.vega.optional.ejemplo.repository;

import org.vega.optional.ejemplo.models.Computador;
import org.vega.optional.ejemplo.models.Fabricante;
import org.vega.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class ComputadorRepository implements Repositorio {

    private List<Computador> dataSourse;

    public ComputadorRepository() {
        dataSourse = new ArrayList<>();
        Procesador pros=new Procesador("Rizen 9",new Fabricante("AMD"));
        Computador asus=new Computador("Asus Rog", "Strix G512");
        asus.setProcesador(pros);
        dataSourse.add(asus);
        dataSourse.add(new Computador("MacBook Pro", "A12"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {

        return dataSourse.stream().filter(c->c.getNombre().toLowerCase()
                .contains(nombre.toLowerCase()))
                .findFirst();
    }
}
