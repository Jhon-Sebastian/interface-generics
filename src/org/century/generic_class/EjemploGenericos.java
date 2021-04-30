package org.century.generic_class;

public class EjemploGenericos {
    public static void main(String[] args) {

        //Transporte de Caballos
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino","Caballo"));
        transporteCaballos.add(new Animal("Grillo","Caballo"));
        transporteCaballos.add(new Animal("Tunquen","Caballo"));
        transporteCaballos.add(new Animal("Clariza","Caballo"));
        transporteCaballos.add(new Animal("Zeus","Caballo"));


        //Transporte de Maquinas
        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grua Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));


        //Transporte de Autos
        Camion<Automovil> transAutos = new Camion<>(2);
        transAutos.add(new Automovil("AUDI"));
        transAutos.add(new Automovil("Mercedez"));


        imprimirCamion(transporteCaballos);
        System.out.println();
        imprimirCamion(transMaquinas);
        System.out.println();
        imprimirCamion(transAutos);


    }

    /*
          Con solo llamar el objeto se puede mostrar la lista
          ya que implementamos la interfaz iterable que hace que el
          objeto se convierta en un tipo de dato Iterable y asi se pueda
          mostrar como una lista o un arreglo, con el metodo iterator()
       */
    private static <T> void imprimirCamion(Camion<T> camion){
        for(T ele : camion){
            if(ele instanceof Animal){
                System.out.println("Nombre: "+ ((Animal) ele).getNombre() + " tipo: " + ((Animal) ele).getTipo());
            }else if(ele instanceof Maquinaria){
                System.out.println("Tipo: " + ((Maquinaria) ele).getTipo());
            }else{
                System.out.println("Marca: " + ((Automovil) ele).getMarca());
            }
        }
    }

}
