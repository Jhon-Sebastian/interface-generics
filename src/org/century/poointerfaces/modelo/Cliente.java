package org.century.poointerfaces.modelo;


import java.util.Objects;

public class Cliente extends BaseEntity{

    private String nombre;
    private String apellido;


    public Cliente(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';

    }

    /*
        Ya que en el metodo eliminarCliente primero compara con el metodo
        equals si existe el cliente, uno por uno , con algun atributo del
        Cliente, entonces lo implementamos para decirle que lo haga por el id
     */

}
