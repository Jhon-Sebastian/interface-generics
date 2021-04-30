package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

// public class ClienteListRepositorio implements CrudRepository, OrdenableRepositorio,PaginableRepositorio
public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    protected AbstractaListRepositorio(){
        dataSource = new ArrayList<>();
    }

    /*
    Metodo Generico, que ya viene para cada ClaseRepository que extienda de
    AbstractaListRepositorio,ademas de que las clases que se pasan en el
    generic deben extender de BaseEntity ya que ahi esta el atributo ID
    y con ello este metodo puede trabajar con el metodo getId Y setId
     */
    @Override
    public T obtenerPorId(Integer id) {
        T c = null;
        for(T cli : dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(obtenerPorId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        //El metodo sublista nos regresa la lista con paginacion
        //El cual rebice 2 argumentos, especificando desde donde incia hasta donde termina
        //La paginacion de la lista
        return dataSource.subList(desde,hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

}
