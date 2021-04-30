package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {

    List<T> listar(int desde, int hasta);

    /*  Antes de los genericos
        List<Cliente> listar(int desde, int hasta);
     */

}
