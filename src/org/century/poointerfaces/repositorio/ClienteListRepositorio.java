package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// public class ClienteListRepositorio implements CrudRepository, OrdenableRepositorio,PaginableRepositorio
public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio{

    private List<Cliente> dataSource;

    public ClienteListRepositorio(){
        dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente obtenerPorId(Integer id) {
        Cliente c = null;
        for(Cliente cli : dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public void crearCliente(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente c = obtenerPorId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminarCliente(Integer id) {
        this.dataSource.remove(obtenerPorId(id));
    }

    @Override
    public List<Cliente> ordenarClientes(String campo, Direccion dir) {

        /*
            Una expresion lamba es una interfaz funcional
            que tiene un solo metodo abstracto por lo cual
            cuando la usamos se asume que estamos usando ese metodo en especifico
            ya que no tiene mas, entonces aqui asumimos que estamos usando
            el metodo abstracto compare() de la interfaz Comparator<T>

            * Ademas los argumentos que se le pasan tambien se asumen que son del
            tipo de la clase que se esta usando ((Cliente a, Cliente b) -> {})
         */

        //A partir del dataSource, creamos una nueva lista para no modificar la original
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = ordenar(campo,a,b);
            }else if(dir == Direccion.DES){
                resultado = ordenar(campo,b,a);
            }
            /*
                Retornar un numero entero, ya que eso es retorna el metodo abstracto
                compare() de la interaz Compareto<> pero con la expresion lamba se esta
                abreviando por eso el return resultado;
             */
            return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        //El metodo sublista nos regresa la lista con paginacion
        //El cual rebice 2 argumentos, especificando desde donde incia hasta donde termina
        //La paginacion de la lista
        return dataSource.subList(desde,hasta);
    }

    private int ordenar(String campo,Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id": resultado = a.getId().compareTo(b.getId());break;
            case "nombre": resultado = a.getNombre().compareTo(b.getNombre());break;
            case "apellido": resultado = a.getApellido().compareTo(b.getApellido());break;
        }
        return resultado;
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
