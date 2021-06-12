package org.century.poointerfaces.repositorio;


import org.century.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepository<T> {

    //Con genericos poder hacer toda la funcionanlidad pero con Productos , Clientes etc
    List<T> listar();

    //En las interfaces siempre es mejor poner la mas generica, no importa que en la
    //Implementacion tengamos una excepcion hija
    T obtenerPorId(Integer id) throws AccesoDatoException;

    void crear(T objeto) throws AccesoDatoException;

    void editar(T objeto) throws AccesoDatoException;

    void eliminar(Integer id) throws AccesoDatoException;
}

  /* Antes de los Genericos, mas acoplado a un solo tipo de dato
      List<Cliente> listar();

    Cliente obtenerPorId(Integer id);

    void crearCliente(Cliente cliente);

    void editarCliente(Cliente cliente);

    void eliminarCliente(Integer id);
}
   */
