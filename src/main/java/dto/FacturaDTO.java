package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class FacturaDTO {
    public int sucursalID;
    public int numero;
    public LocalDate fchEmision;
    public double total;
    public ArrayList<ProductoFacturaDTO> productos = new ArrayList<ProductoFacturaDTO>();
}