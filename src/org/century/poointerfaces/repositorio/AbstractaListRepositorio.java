package org.century.poointerfaces.repositorio;

import org.century.poointerfaces.modelo.BaseEntity;
import org.century.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.century.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.century.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.century.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;

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
    public T obtenerPorId(Integer id) throws LecturaAccesoDatoException {
        if(id == null || id <= 0){
            throw new LecturaAccesoDatoException("Id invalido, debe ser mayor a 0 y != null");
        }
        T c = null;
        for(T cli : dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                c = cli;
                break;
            }
        }
        if(c == null){
            throw new LecturaAccesoDatoException("No existe el registro con el id: " + id);
        }
        return c;
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException{
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if(this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error, el objeto con id: "
            +  t.getId() + ", ya existe en la base de datos");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
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
