package models;

 import java.time.LocalDate;
 import java.util.ArrayList;
 import java.util.List;

 public class Factura {
     private Cliente cliente;
     private int sucursalID;
     private int numero;
     private LocalDate fchEmision;
     private double total;
     private List<FacturaProducto> productos = new ArrayList<>();
     private List<FacturaImpuesto> impuestos = new ArrayList<>();
     private List<PagoFactura> pagos = new ArrayList<>();

     public Factura(Cliente cliente, int sucursalID, int numero, LocalDate fchEmision) {
         this.cliente = cliente;
         this.sucursalID = sucursalID;
         this.numero = numero;
         this.fchEmision = fchEmision;
         this.total = 0;
         this.cliente.agregarFactura(this);
     }

     public void agregarProducto(Producto p, int cantidad, double precio) {
         productos.add(new FacturaProducto(p, cantidad, precio));
         total += cantidad * precio;
     }

     public void agregarImpuesto(FacturaImpuesto imp) { impuestos.add(imp); }
     public void agregarPago(PagoFactura pago) { pagos.add(pago); }

     public int getSucursalID() { return sucursalID; }
     public int getNumero() { return numero; }
     public LocalDate getfchEmision() { return fchEmision; }
     public double getTotal() { return total; }
     public List<FacturaProducto> getProductos() { return productos; }

     public double getTotalPagado() {
         double pagado = 0;
         for (PagoFactura p : pagos) pagado += p.getTotalPagado();
         return pagado;
     }
 }