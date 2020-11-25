/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendajava;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    
    public Producto[] getProducto(){
        conectarBD();
        List<Producto> listaProd = new ArrayList<Producto>();
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
        Producto[] res = new Producto[listaProd.size()];
        return res = listaProd.toArray(res);
    }
}

