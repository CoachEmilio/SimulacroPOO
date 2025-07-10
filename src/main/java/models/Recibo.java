package models;

    import dto.InfoPagoDTO;
    import java.util.ArrayList;
    import java.util.List;

    public class Recibo {
        private String cuitCliente;
        private String razonSocialCliente;
        private List<InfoPagoDTO> pagos = new ArrayList<>();

        public Recibo(String cuitCliente, String razonSocialCliente) {
            this.cuitCliente = cuitCliente;
            this.razonSocialCliente = razonSocialCliente;
        }

        public String getCuitCliente() { return cuitCliente; }
        public String getRazonSocialCliente() { return razonSocialCliente; }
        public List<InfoPagoDTO> obtenerInfoPagos() { return pagos; }

        public void agregarPago(InfoPagoDTO pago) { pagos.add(pago); }
    }