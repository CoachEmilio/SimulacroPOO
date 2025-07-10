// src/main/java/models/Remito.java
     package models;

     import java.time.LocalDate;
     import java.util.ArrayList;
     import java.util.List;

     public class Remito {
         private int remitoID;
         private LocalDate fecha;
         private Cliente cliente;
         private List<RemitoProducto> productos = new ArrayList<>();

         public Remito(int remitoID, LocalDate fecha, Cliente cliente) {
             this.remitoID = remitoID;
             this.fecha = fecha;
             this.cliente = cliente;
         }

         public int getRemitoID() {
             return remitoID;
         }

         public LocalDate getFecha() {
             return fecha;
         }

         public Cliente getCliente() {
             return cliente;
         }

         public List<RemitoProducto> getProductos() {
             return productos;
         }

         public void agregarProducto(Producto producto, int cantidad, double precio) {
             productos.add(new RemitoProducto(producto, cantidad, precio));
         }
     }