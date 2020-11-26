/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendajava;

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
        
        
        Controlador tienda = new Controlador(); 
        Producto [] productos = tienda.getProducto();
        Object[] objeto;
        Object [][] matriz = new Object[productos.length][4];
        for(int i = 0; i< productos.length ; i++){
            matriz[i][0] = productos[i].getId();
            matriz[i][1] = productos[i].getNombre();
            matriz[i][2] = productos[i].getPrecio();
            matriz[i][3] = productos[i].getId();
        }   
        
        for(int i = 0; i < productos.length; i++){
            for(int j = 0; j < 4; j++)
                System.out.print(matriz[i][j]+ " ");
        System.out.println(" ");
        }  
    }
    
}
