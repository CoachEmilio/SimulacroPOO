package models;

    public class PagoFactura {
        private Factura factura;
        private double totalPagado;

        public PagoFactura(Factura factura, double totalPagado) {
            this.factura = factura;
            this.totalPagado = totalPagado;
        }

        public Factura getFactura() { return factura; }
        public double getTotalPagado() { return totalPagado; }
    }