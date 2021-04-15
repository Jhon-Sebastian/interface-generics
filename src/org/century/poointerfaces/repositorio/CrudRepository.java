package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepository {

    List<Cliente> listar();

    Cliente obtenerPorId(Integer id);

    void crearCliente(Cliente cliente);

    void editarCliente(Cliente cliente);

    void eliminarCliente(Integer id);
}
