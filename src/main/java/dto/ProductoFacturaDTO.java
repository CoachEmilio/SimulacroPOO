package dto;

public class ProductoFacturaDTO {
    public int productoID;
    public int cantidad;
    public double precio;

    public ProductoFacturaDTO(int productoID, int cantidad, double precio) {
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}