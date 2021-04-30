package org.century.generics;

import org.century.poointerfaces.modelo.Cliente;
import org.century.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        /* TODO:[OBJETIVO]
            El objetivo de los Genericos es:
            Que sea mas seguro con respecto a la conversion de datos,
            trabajar con distintos tipos, que sean mas genericos,
            reducir errores de compilacion  */

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres","Guzman"));

        Cliente[] clietesArreglo =  {new Cliente("Andres","Guzman")
                                    ,new Cliente("Lucas","Segundo")
                                    ,new Cliente("Escariote","Joseodo")};

        Integer[] enterosArreglo =  new Integer[]{1,2,3};

        List<Cliente> cli = fromArrayToList(clietesArreglo);
        List<Integer> ent = fromArrayToList(enterosArreglo);

        cli.forEach(System.out::println);
        ent.forEach(System.out::println);

        System.out.println();
        List<String> nombres = fromArrayToList(new String[]{"Andres",
                                                            "Pepe",
                                                            "jhon",
                                                            "Bea"}, enterosArreglo);

        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremium = fromArrayToList(
                new ClientePremium[]{
                        new ClientePremium("Lukas","Vazques"),
                        new ClientePremium("Ana","Lucia"),
                        new ClientePremium("Victoria","Ausique"),
                        new ClientePremium("Andres","Escobar")
                }
        );

        clientePremium.forEach(System.out::println);

        System.out.println("\n");
        imprimirClientes(clientes);

        System.out.println("\n");
        imprimirClientes(cli);

        System.out.println("\n");
        imprimirClientes(clientePremium);

        System.out.println("\nMaximo de  1,9,4 es: " + maximo(1,9,4));
        System.out.println("\nMaximo de  3.9, 11.6 , 7.78 es: " + maximo(3.9,11.6,7.78));
        System.out.println("\nMaximo de  zanahoria, arandanos, manzana es: " +
                maximo("zanahoria","arandanos","manzana"));

     }

    /* TODO: [Como especificar que vamos a usar Generics]

        Se aplican despues de los modificadores de acceso y antes
        de declarar el nombre del metodo, usando <T>, se usa la
        letra T por constumbre y ademas que sea en mayuscula,si hay
        mas argumentos ya depende del programador como nombrarlas

        Ademas si se quiere recibir un generico por argumento
        o retornar un tipo de lista generica necesariamente toca
        declarar que va a usar genericos usando <T>
        despues de los modificadores, obligatoriamente.

        EXAMPLE:

        public static <T> List<T> nameMethod(){}
        private void <T> nameMethod(T[] value){}
        <T, G> String nameMethod(T value1, G value2){}  */

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }


    /*  TODO:[Bounded Generics]

         Si se quiere solo permitir algunos tipos de datos, exceptuando
         otros, podemos usar Bounded Generics, que lo que hace es solo
         permitir el acceso al tipo de dato(Clases) que indiquemos
         y tambien sirve para interfaces en el que solo permite clases
         que hallan implementado dicha interfaz

         EXAMPLE:
         <T extends Number>
         <T extends TipoDatoALimitar>
         <T extends NombreInterfaz>

         Se puede trabajar con objetos de tipo Number e hijos como
         Integer,Short,Byte,Long,Double,Float  */

    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }




    /*  TODO:[Limite de tipos de datos pasados como argumentos]
        Todavia se puede limitar mas,indicando que el tipo de dato a entrar
        debe implemnetar la interfaz "Comparable<T>", o la que se desee.

        EXAMPLE:
       <T extends Clientes & interfazQueDebeImplementar>

       Se puede trabajar con Cliene e hijos que implementen dicha interfaz  */

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }



    /*   TODO:[Varios argumentos Genericos]
         T -> Transforma el arreglo en una lista
         G -> Mustra el arreglo  */

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento : x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }




    /*   TODO:[Comodines o Wildcars]
         Solo se pueden usar en Listas

         Una List<Clientes> != List<ClientePremiun> no son iguales
         ya que una no hereda de la otra, es muy diferente la herencia
         normal de Objetos con un padre e hijo,aqui no aplica esto con
         listas. Por ello usamos comodin o wildcars

         Para permitir que una List<ClientePremiun> o
         clases hijas entre como argumento siendo una List<>

         EXAMPLE:
         List<? extends Cliente>, aqui lo que estamos diciendo es que
         cualquiere List<Hijos de Cliente> puede entrar como argumento

         */
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }


    /*  TODO:[Metodo generico]

        Permite trabajar con cualquier tipo de objeto siempre y cuando
        dicho objeto halla implementado halla la interfaz Comparable<T>
        Con esto damos cabida a las Clases Wrapper ya que estan
        la implementan.

        Cuando se indica que los todos los argumentos son de tipo
        T, quiere decir que si el primer argumento es Integer, todos
        deben ser Integer y asi sucesivamente

        Ademas de comparar en la tabla UNICODE cual es el mayor  */

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(a) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }

}
