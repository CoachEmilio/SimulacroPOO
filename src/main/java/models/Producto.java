package models;

public class Producto {
    private int productoID;
    private String descripcion;
    private double precio;

    public Producto(int productoID, String descripcion, double precio) {
        this.productoID = productoID;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getProductoID() { return productoID; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
}