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
        Producto nuevo = new Producto(1, 1000, "bicicleta", 5);
        Scanner entrada = new Scanner(System.in);
        
        while(true){
            String cadena = entrada.nextLine();
            int resultado = nuevo.getNombre().indexOf(cadena);
            System.out.println(resultado);
            if (resultado != -1){
                System.out.println("Esta");
            }
        }
        
    }
    
}
