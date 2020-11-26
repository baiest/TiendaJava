/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendajava;
import java.sql.*;
import java.util.*;
/**
 *
 * @author user
 */
public class Controlador {
    private Producto[] arregloProducto;
    private Connection conexion = null;
    public Controlador(){
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Cargada Libreria");
        }catch(ClassNotFoundException e){
            System.out.println("Error en el driver: " + e );
        }
        conectarBD();
    }

    public Producto[] getArregloProducto() {
        return arregloProducto;
    }
    
    private void conectarBD(){
        try{            
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/TiendaJava",
                    "postgres",
                    "postgres"
            );
            boolean valid = conexion.isValid(5000);
            System.out.println(valid ? "OK" : "FAIL");
        }catch(java.sql.SQLException sql){
            System.out.println("Error: "+ sql);
        }
        
    }
    
    public Vector<Producto> getProducto(){
        
        Vector<Producto> listaProd = new Vector<Producto>();
        Producto stack;
        try{
            Statement sql = conexion.createStatement();
            ResultSet result = sql.executeQuery("SELECT * FROM Producto");
            while(result.next()){
                  stack = new Producto(
                          result.getInt("id"),
                          result.getDouble("precio"),
                          result.getString("nombre"),
                          result.getInt("cantidad")
                  );
                  listaProd.add(stack);
            }
        }catch(SQLException e){
            System.out.println("Error en consulta: " + e);
        }
        return listaProd;
    }
    
    public Object[][] getMatriz(Vector<Producto> productos){
        Object[][] matriz = new Object[productos.size()][4];
        for(int i = 0; i< productos.size() ; i++){
            matriz[i][0] = productos.elementAt(i).getId();
            matriz[i][1] = productos.elementAt(i).getNombre();
            matriz[i][2] = productos.elementAt(i).getPrecio();
            matriz[i][3] = productos.elementAt(i).getId();
        }
        return matriz;
    }
    
    public Object[][] buscar(String nombre){
        System.out.println(nombre == "" ?  "Vacio": "--"+nombre);
        Vector<Producto> productos = getProducto();
        Vector<Producto> encontrado =new Vector<Producto>();
        int minus, mayus = -1;
        for (Producto p: productos){
            minus = p.getNombre().toLowerCase().indexOf(nombre);
            mayus = p.getNombre().toUpperCase().indexOf(nombre);
            if (minus != -1 || mayus != -1){
                encontrado.add(p);
            }
        }
        Object[][] matriz = nombre == "" ? getMatriz(productos): getMatriz(encontrado);
        
        return matriz;
    }
}

