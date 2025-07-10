package controller;

import dto.FacturaDTO;
import dto.ProductoFacturaDTO;
import dto.ProductoRemitoDTO;
import dto.RemitosEmitidosDTO;
import models.Factura;
import models.Producto;
import models.Remito;
import models.RemitoProducto;

import java.util.ArrayList;
import java.util.List;

public class VentasController {
    private static VentasController instance = null;
    private final List<Remito> remitos = new ArrayList<>();
    private final List<Producto> productos = new ArrayList<>();
    private final List<Factura> facturas = new ArrayList<>();

    private VentasController() {
        productos.add(new Producto(1, "Producto 1", 1000));
        productos.add(new Producto(2, "Producto 2", 2000));
        productos.add(new Producto(3, "Producto 3", 3000));
        productos.add(new Producto(4, "Producto 4", 4000));
        productos.add(new Producto(5, "Producto 5", 5000));
        // Aquí puedes agregar datos sintéticos de remitos y facturas si lo necesitas
    }

    // Patrón Singleton para asegurar que solo haya una instancia de VentasController
    public static synchronized VentasController getInstance() {
        if (instance == null) {
            instance = new VentasController();
        }
        return instance;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public List<RemitosEmitidosDTO> getRemitosEmitidos() {
        List<RemitosEmitidosDTO> result = new ArrayList<>();
        for (Remito r : remitos) {
            RemitosEmitidosDTO dto = new RemitosEmitidosDTO();
            dto.remitoID = r.getRemitoID();
            dto.fecha = r.getFecha();
            for (RemitoProducto rp : r.getProductos()) {
                dto.productos.add(new ProductoRemitoDTO(
                    rp.getProducto().getProductoID(),
                    rp.getCantidad(),
                    rp.getPrecio()
                ));
            }
            result.add(dto);
        }
        return result;
    }

    public List<FacturaDTO> getFacturasEmitidas() {
        List<FacturaDTO> result = new ArrayList<>();
        for (Factura f : facturas) {
            FacturaDTO dto = new FacturaDTO();
            dto.sucursalID = f.getSucursalID();
            dto.numero = f.getNumero();
            dto.fchEmision = f.getfchEmision();
            dto.total = f.getTotal();
            for (var fp : f.getProductos()) {
                dto.productos.add(new ProductoFacturaDTO(
                    fp.getProducto().getProductoID(),
                    fp.getCantidad(),
                    fp.getPrecio()
                ));
            }
            result.add(dto);
        }
        return result;
    }
}