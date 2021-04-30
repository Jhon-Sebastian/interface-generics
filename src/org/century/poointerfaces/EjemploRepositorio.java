package org.century.poointerfaces;

import org.century.poointerfaces.modelo.Cliente;
import org.century.poointerfaces.repositorio.*;
import org.century.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        // CrudRepository repo = new ClienteListRepositorio();
        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzales"));
        repo.crear(new Cliente("Lucia", "Martinez"));
        repo.crear(new Cliente("Andrez", "Guzman"));

        //Listado Normal
        System.out.println("\n----------------Listado Normal--------------------");
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        //Listado Paginado
        System.out.println("\n-----------------Listado Paginado-------------------");
        // List<Cliente> paginado = ( (PaginableRepositorio)repo).listar(0,2);
        List<Cliente> paginado = repo.listar(0,2);
        paginado.forEach(System.out::println);

        //Listado Ordenado [id,nombre,apellido]-[Ascendente,Descendiente]
        System.out.println("\n*----------------Listado Ordenado [id]-[DES]------------------*");
        List<Cliente> ordenado = ( (OrdenableRepositorio)repo).listaOrdenada("id", Direccion.DES);
        ordenado.forEach(System.out::println);

        System.out.println("\n**---------------Listado Ordenado [nombre]-[ASC]-----------------**");
        List<Cliente> ordenado2 = ( (OrdenableRepositorio)repo).listaOrdenada("nombre", Direccion.ASC);
        ordenado2.forEach(System.out::println);

        System.out.println("\n***--------------Listado Ordenado [apellido]-[DES]----------------***");
        List<Cliente> ordenado3 = ( (OrdenableRepositorio)repo).listaOrdenada("apellido", Direccion.DES);
        ordenado3.forEach(System.out::println);

        //Editar Cliente
        System.out.println("\n-----------------Editar Cliente-------------------");
        Cliente beaActualizar = new Cliente("Bea","Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.obtenerPorId(2);
        System.out.println(bea);
        System.out.println("\n<<<<<<<<<<<<<<<<Comprobar Editar>>>>>>>>>>>>>>>>>");
        List<Cliente> listadoOrdenado = ((OrdenableRepositorio) repo).listaOrdenada("id",Direccion.ASC);
        listadoOrdenado.forEach(System.out::println);

        //Eliminar Cliente
        System.out.println("\n-----------------Eliminar Cliente-------------------");
        Cliente clienteEliminar = repo.obtenerPorId(2);
        System.out.println(clienteEliminar);
        repo.eliminar(2);
        System.out.println("\n<<<<<<<<<<<<<<<<Comprobar Eliminar>>>>>>>>>>>>>>>>>");
        repo.listar().forEach(System.out::println);

        //Total de elementos
        System.out.println("\n---------------Total de Clientes--------------------");
        System.out.println(repo.total());

    }
}
