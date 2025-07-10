package models;

        import enumeration.TipoImpuesto;

        public class FacturaImpuesto {
            private TipoImpuesto tipoImpuesto;
            private double porcentaje;
            private double importe;

            public FacturaImpuesto(TipoImpuesto tipoImpuesto, double porcentaje, double importe) {
                this.tipoImpuesto = tipoImpuesto;
                this.porcentaje = porcentaje;
                this.importe = importe;
            }

            public TipoImpuesto getTipoImpuesto() { return tipoImpuesto; }
            public double getPorcentaje() { return porcentaje; }
            public double getImporte() { return importe; }
        }