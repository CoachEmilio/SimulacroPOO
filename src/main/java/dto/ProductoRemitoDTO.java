package dto;

public class ProductoRemitoDTO {
    public int productoID;
    public int cantidad;
    public double precio;

    public ProductoRemitoDTO(int productoID, int cantidad, double precio) {
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}