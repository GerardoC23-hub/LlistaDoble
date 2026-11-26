/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listdouble;

/**
 *
 * @author gerardo
 */
public class ListDouble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        // 1. INSERTAR EN POSICION
        System.out.println("===== INSERTAR EN POSICION =====");
        lista.insertarInicio(10);
        lista.insertarFinal(30);
        lista.insertarEnPosicion(2, 20);

        System.out.println("Resultado: " + lista);
        System.out.println("Tamaño: " + lista.getTamanio());


        // 2. ELIMINAR POR VALOR
        System.out.println("\n===== ELIMINAR POR VALOR =====");
        System.out.println("Eliminar 20: " + lista.eliminar(20));

        System.out.println("Resultado: " + lista);
        System.out.println("Tamaño: " + lista.getTamanio());


        // 3. ELIMINAR EN POSICION
        System.out.println("\n===== ELIMINAR EN POSICION =====");
        System.out.println("Valor eliminado: "
                + lista.eliminarEnPosicion(1));

        System.out.println("Resultado: " + lista);
        System.out.println("Tamaño: " + lista.getTamanio());


        // 4. ELIMINAR ULTIMO
        System.out.println("\n===== ELIMINAR ULTIMO =====");
        lista.insertarFinal(40);
        lista.insertarFinal(50);

        System.out.println("Antes: " + lista);
        System.out.println("Operacion realizada: " + lista.eliminarFinal());

        System.out.println("Resultado: " + lista);
        System.out.println("Tamaño: " + lista.getTamanio());


        // 5. INSERTAR ORDENADO
        System.out.println("\n===== INSERTAR ORDENADO =====");
        lista.insertarOrdenado(35);
        lista.insertarOrdenado(15);
        lista.insertarOrdenado(60);
        lista.insertarOrdenado(5);

        System.out.println("Resultado: " + lista);
        System.out.println("Tamaño: " + lista.getTamanio());
    }
    
}
