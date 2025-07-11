package models;

    import dto.ClienteDTO;
    import enumeration.TipoCliente;
    import java.util.ArrayList;
    import java.util.List;

    public class Cliente {
        private String cuit;
        private String razonSocial;
        private TipoCliente tipoCliente;
        private ListaPrecio listaPrecio;
        private List<Factura> facturas = new ArrayList<>();

        public Cliente(ListaPrecio listaPrecio, String cuit, String razonSocial, TipoCliente tipoCliente) {
            this.listaPrecio = listaPrecio;
            this.cuit = cuit;
            this.razonSocial = razonSocial;
            this.tipoCliente = tipoCliente;
            this.listaPrecio.addCliente(this);
        }

        public String getCuit() { return cuit; }
        public String getRazonSocial() { return razonSocial; }
        public TipoCliente getTipoCliente() { return tipoCliente; }
        public ListaPrecio getListaPrecio() { return listaPrecio; }
        public List<Factura> getFacturas() { return facturas; }

        public void agregarFactura(Factura f) { facturas.add(f); }

        public boolean tieneFacturasImpagas(int cantidad) {
            int impagas = 0;
            for (Factura f : facturas) {
                if (f.getTotal() > f.getTotalPagado()) impagas++;
            }
            return impagas >= cantidad;
        }
    }