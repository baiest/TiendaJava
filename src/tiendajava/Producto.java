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
public class Producto {
    private int id;
    private double precio;
    private String nombre;
    private int cantidad;
    
    public Producto(int id, double precio, String nombre, int cantidad){
        this.id=id;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public String mostrarDatos(){
        String cadena = Integer.toString(this.id)+", "+ Double.toString(this.precio) +", '"+ this.nombre+"', "+Integer.toString(this.cantidad);
        return cadena;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
