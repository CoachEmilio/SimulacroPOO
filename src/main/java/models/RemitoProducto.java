package models;

      public class RemitoProducto {
          private Producto producto;
          private int cantidad;
          private double precio;

          public RemitoProducto(Producto producto, int cantidad, double precio) {
              this.producto = producto;
              this.cantidad = cantidad;
              this.precio = precio;
          }

          public Producto getProducto() {
              return producto;
          }

          public int getCantidad() {
              return cantidad;
          }

          public double getPrecio() {
              return precio;
          }
      }