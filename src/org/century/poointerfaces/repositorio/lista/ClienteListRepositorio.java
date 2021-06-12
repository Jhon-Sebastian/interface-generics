package org.century.poointerfaces.repositorio.lista;

import org.century.poointerfaces.modelo.Cliente;
import org.century.poointerfaces.repositorio.AbstractaListRepositorio;
import org.century.poointerfaces.repositorio.Direccion;
import org.century.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

// public class ClienteListRepositorio implements CrudRepository, OrdenableRepositorio,PaginableRepositorio
public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {


    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = obtenerPorId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listaOrdenada(String campo, Direccion dir) {

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

    private int ordenar(String campo,Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id": resultado = a.getId().compareTo(b.getId());break;
            case "nombre": resultado = a.getNombre().compareTo(b.getNombre());break;
            case "apellido": resultado = a.getApellido().compareTo(b.getApellido());break;
        }
        return resultado;
    }

}
