package dto;

import java.util.ArrayList;

public class ReciboEmitidoDTO {
    public String cuitCliente;
    public String razonSocial;
    public ArrayList<InfoPagoDTO> infoPago = new ArrayList<InfoPagoDTO>();
}