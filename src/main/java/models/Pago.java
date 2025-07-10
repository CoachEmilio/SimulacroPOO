package models;

        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

        public class Pago {
            private LocalDate fecha;
            private double importe;
            private String banco;
            private String cuenta;
            private List<PagoFactura> facturasAsociadas = new ArrayList<>();

            public Pago(LocalDate fecha, double importe, String banco, String cuenta) {
                this.fecha = fecha;
                this.importe = importe;
                this.banco = banco;
                this.cuenta = cuenta;
            }

            public void agregarFacturaAsociada(Factura f, double monto) {
                facturasAsociadas.add(new PagoFactura(f, monto));
            }

            public LocalDate getFecha() { return fecha; }
            public double getImporte() { return importe; }
            public String getBanco() { return banco; }
            public String getCuenta() { return cuenta; }
            public List<PagoFactura> getFacturasAsociadas() { return facturasAsociadas; }
        }