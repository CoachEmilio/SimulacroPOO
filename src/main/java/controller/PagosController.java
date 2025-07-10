package controller;

 import dto.InfoFacturaDTO;
 import dto.InfoPagoDTO;
 import dto.ReciboEmitidoDTO;
 import models.Factura;
 import models.Pago;
 import models.Recibo;

 import java.util.ArrayList;
 import java.util.List;

 public class PagosController {
     private static PagosController instance = null;
     private List<Recibo> recibos = new ArrayList<>();
     private List<Pago> pagos = new ArrayList<>();

     private PagosController() {
         // Datos sintéticos de ejemplo
         Recibo r1 = new Recibo("20123456789", "Empresa Uno");
         Recibo r2 = new Recibo("20234567890", "Empresa Dos");
         recibos.add(r1);
         recibos.add(r2);

         Pago p1 = new Pago(java.time.LocalDate.now(), 1000.0, "Banco Nación", "Cuenta 1");
         pagos.add(p1);
     }

     // Patrón Singleton para asegurar que solo haya una instancia de PagosController
     public static synchronized PagosController getInstance() {
         if (instance == null) {
             instance = new PagosController();
         }
         return instance;
     }

     public List<ReciboEmitidoDTO> obtenerRecibosEmitidos() {
         List<ReciboEmitidoDTO> result = new ArrayList<>();
         for (Recibo r : this.recibos) {
             ReciboEmitidoDTO unRecibo = new ReciboEmitidoDTO();
             unRecibo.cuitCliente = r.getCuitCliente();
             unRecibo.razonSocial = r.getRazonSocialCliente();
             unRecibo.infoPago.addAll(r.obtenerInfoPagos());
             result.add(unRecibo);
         }
         return result;
     }

     public int agregarPago(InfoPagoDTO nuevoPago) {
         Pago p = new Pago(nuevoPago.fecha, nuevoPago.importe, nuevoPago.banco, nuevoPago.cuenta);
         for (InfoFacturaDTO info : nuevoPago.infoFactura) {
             Factura f = null; // Aquí deberías obtener la factura real si está implementado
             p.agregarFacturaAsociada(f, info.total);
         }
         this.pagos.add(p);
         return this.pagos.size();
     }
 }