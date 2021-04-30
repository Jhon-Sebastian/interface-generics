package org.century.poointerfaces.repositorio;

/*
    Una interfaz tambien puede heredar de otras interfaces,aqui lo que
    hacemos es que una interfaz herede de las demas y asi en la clase que la
    implementa no tenga que implementar todas, si no solo una

    Aqui si se permite herencia multiple pero de interfaces

    Esta interfaz va a heredar los metodos de las demas

    Solo como prueba, para entender que se puede hacer

 */
public interface OrdenablePaginableCrudRepositorio<T> extends CrudRepository<T>,
        OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio{
}
