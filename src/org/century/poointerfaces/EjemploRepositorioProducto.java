package org.century.poointerfaces;

import org.century.poointerfaces.modelo.Cliente;
import org.century.poointerfaces.modelo.Producto;
import org.century.poointerfaces.repositorio.Direccion;
import org.century.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.century.poointerfaces.repositorio.OrdenableRepositorio;
import org.century.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.century.poointerfaces.repositorio.lista.ProductoListRepostorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        // CrudRepository repo = new ClienteListRepositorio();
        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepostorio();
        repo.crear(new Producto("mesa",50.52));
        repo.crear(new Producto("silla",18));
        repo.crear(new Producto("lampara",15.5));
        repo.crear(new Producto("escoba",400.89));

        System.out.println("\n----------------Listado Normal--------------------");
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        System.out.println("\n-----------------Listado Paginado-------------------");
        List<Producto> paginado = repo.listar(0,2);
        paginado.forEach(System.out::println);

        System.out.println("\n*----------------Listado Ordenado [id]-[DES]------------------*");
        List<Producto> ordenado = repo.listaOrdenada("id", Direccion.DES);
        ordenado.forEach(System.out::println);

        System.out.println("\n**---------------Listado Ordenado [descripcion]-[ASC]-----------------**");
        List<Producto> ordenado2 = repo.listaOrdenada("descripcion", Direccion.ASC);
        ordenado2.forEach(System.out::println);

        System.out.println("\n***--------------Listado Ordenado [precio]-[DES]----------------***");
        List<Producto> ordenado3 = repo.listaOrdenada("precio", Direccion.DES);
        ordenado3.forEach(System.out::println);

        System.out.println("\n-----------------Editar Producto-------------------");
        Producto beaActualizar = new Producto("Carrito",45.03);
        beaActualizar.setId(2);
        repo.editar(beaActualizar);

        Producto bea = repo.obtenerPorId(2);
        System.out.println(bea);

        System.out.println("\n<<<<<<<<<<<<<<<<Comprobar Editar>>>>>>>>>>>>>>>>>");
        List<Producto> listadoOrdenado = repo.listaOrdenada("id",Direccion.ASC);
        listadoOrdenado.forEach(System.out::println);

        System.out.println("\n-----------------Eliminar Producto-------------------");
        Producto clienteEliminar = repo.obtenerPorId(2);
        System.out.println(clienteEliminar);
        repo.eliminar(2);
        System.out.println("\n<<<<<<<<<<<<<<<<Comprobar Eliminar>>>>>>>>>>>>>>>>>");
        repo.listar().forEach(System.out::println);

        //Total de elementos
        System.out.println("\n---------------Total de Productos--------------------");
        System.out.println("Total de registros: " + repo.total());

    }
}
