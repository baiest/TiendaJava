/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendajava;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class TiendaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto nuevo = new Producto(5, 1000, "bicicleta", 5);
        Controlador tienda = new Controlador();
        System.out.println(nuevo.mostrarDatos());
        Scanner entrada = new Scanner(System.in);
        
        tienda.agregar(nuevo);
        
    }
    
}
