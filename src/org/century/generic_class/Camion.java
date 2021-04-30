package org.century.generic_class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{

    /*
        Cualquier objeto que implemente esta interfaz puede ser
        iterable, osea pasar por un foreach
     */

    private List<T> objetos;

    private int maxElements;

    public Camion(int maxElements) {
        this.maxElements = maxElements;
        this.objetos = new ArrayList<>();
    }

    public void add(T objeto){
        if(this.objetos.size() <= maxElements) {
            this.objetos.add(objeto);
        }else{
            throw new RuntimeException("No hay mas espacio");
        }
    }

    /*
        Como la interaz List tambien implementa la interfaz de Iterable
        podemos llamar el metodo iterator()
     */
    @Override
    public Iterator<T> iterator() {
        return objetos.iterator();
    }
}
