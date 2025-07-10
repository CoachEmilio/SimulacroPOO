package dto;

import java.time.LocalDate;
import java.util.ArrayList;

public class RemitosEmitidosDTO {
    public int remitoID;
    public LocalDate fecha;
    public ArrayList<ProductoRemitoDTO> productos = new ArrayList<ProductoRemitoDTO>();
}