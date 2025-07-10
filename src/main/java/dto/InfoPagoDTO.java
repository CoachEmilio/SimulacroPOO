package dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InfoPagoDTO {
    public LocalDate fecha;
    public String banco;
    public String cuenta;
    public double importe;
    public List<InfoFacturaDTO> infoFactura = new ArrayList<InfoFacturaDTO>();
}