package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepository<T> {

    //Con genericos poder hacer toda la funcionanlidad pero con Productos , Clientes etc
    List<T> listar();

    T obtenerPorId(Integer id);

    void crear(T objeto);

    void editar(T objeto);

    void eliminar(Integer id);
}

  /* Antes de los Genericos, mas acoplado a un solo tipo de dato
      List<Cliente> listar();

    Cliente obtenerPorId(Integer id);

    void crearCliente(Cliente cliente);

    void editarCliente(Cliente cliente);

    void eliminarCliente(Integer id);
}
   */
