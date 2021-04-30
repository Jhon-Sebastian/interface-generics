package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {

    List<T> listaOrdenada(String campo, Direccion dir);

    /*
        Antes de los genericos
        List<Cliente> ordenarClientes(String campo, Direccion dir);
     */

}
