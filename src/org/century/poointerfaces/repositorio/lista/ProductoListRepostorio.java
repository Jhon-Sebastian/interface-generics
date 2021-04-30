package org.century.poointerfaces.repositorio.lista;

import org.century.poointerfaces.modelo.Producto;
import org.century.poointerfaces.repositorio.AbstractaListRepositorio;
import org.century.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepostorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto p = obtenerPorId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listaOrdenada(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((x,y) ->{
            int result = 0;
            if(dir == Direccion.ASC){
                result = ordenar(campo,x,y);
            }else if(dir == Direccion.DES){
                result = ordenar(campo,y,x);
            }
            return result;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;
        switch (campo){
            case "id": resultado = a.getId().compareTo(b.getId());break;
            case "descripcion": resultado = a.getDescripcion().compareTo(b.getDescripcion());break;
            case "precio": resultado = a.getPrecio().compareTo(b.getPrecio());break;
        }
        return resultado;
    }
}
