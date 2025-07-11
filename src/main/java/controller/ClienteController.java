package controller;

import models.Cliente;
import models.ListaPrecio;
import models.Producto;
import dto.ClienteDTO;
import enumeration.TipoCliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    // Singleton: única instancia del controlador y privada como se requiere
    // para evitar instanciación externa y garantizar un único punto de acceso
    private static ClienteController instance = null;

    // Listas de entidades principales
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<ListaPrecio> listaprecios = new ArrayList<ListaPrecio>();
    private List<Producto> productos = new ArrayList<>();

    // Constructor privado: inicializa datos sintéticos para pruebas y desarrollo
    private ClienteController() {
        // Listas de precios ficticias
        listaprecios.add(new ListaPrecio(1, "Lista precios general"));
        listaprecios.add(new ListaPrecio(2, "Lista clientes 2 años permanencia"));
        listaprecios.add(new ListaPrecio(3, "LP Sector público"));

        // Clientes ficticios asociados a listas de precios
        clientes.add(new Cliente(listaprecios.get(0), "cuit1", "Razon Social Cliente 1", TipoCliente.ConsumidorFinal));
        clientes.add(new Cliente(listaprecios.get(0), "cuit2", "Razon Social Cliente 2", TipoCliente.ConsumidorFinal));
        clientes.add(new Cliente(listaprecios.get(0), "cuit3", "Razon Social Cliente 3", TipoCliente.ConsumidorFinal));
        clientes.add(new Cliente(listaprecios.get(1), "cuit4", "Razon Social Cliente 4", TipoCliente.ResponsableInscripto));
        clientes.add(new Cliente(listaprecios.get(2), "cuit5", "Ministerio de educación", TipoCliente.Exento));

        // Productos ficticios
        productos.add(new Producto(1, "Producto 1", 1000));
        productos.add(new Producto(2, "Producto 2", 2000));
        productos.add(new Producto(3, "Producto 3", 3000));
        productos.add(new Producto(4, "Producto 4", 4000));
        productos.add(new Producto(5, "Producto 5", 5000));
    }

    // Metodo estático para obtener la instancia Singleton
    public static synchronized ClienteController getInstance() {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }

    // Punto 3: Devuelve los clientes (DTO) de una lista de precios específica
    // Corregido para devolver una lista de ClienteDTO y no desde el modelo ListaPrecio.
    public List<ClienteDTO> getClientesPorListaPrecio(int lpID) {
        for (ListaPrecio lp : listaprecios) {
            if (lp.getListaPrecioID() == lpID) {
                List<ClienteDTO> result = new ArrayList<>();
                for (Cliente c : lp.getClientes()) {
                    ClienteDTO dto = new ClienteDTO();
                    dto.cuit = c.getCuit();
                    dto.razonSocial = c.getRazonSocial();
                    dto.tipoCliente = c.getTipoCliente();
                    result.add(dto);
                }
                return result;
            }
        }
        return new ArrayList<>();
    }

    //Borré el método de dtos en clientes y acá lo traspasé a ClienteController
    // Punto 2: Devuelve los clientes con al menos 'cantFacturas' impagas
    public List<ClienteDTO> getClienteConFacturasAdeudadas(int cantFacturas) {
        ArrayList<ClienteDTO> result = new ArrayList<>();
        for (Cliente c : this.clientes) {
            if (c.tieneFacturasImpagas(cantFacturas)) {
                ClienteDTO dto = new ClienteDTO();
                dto.cuit = c.getCuit();
                dto.razonSocial = c.getRazonSocial();
                dto.tipoCliente = c.getTipoCliente();
                result.add(dto);
            }
        }
        return result;
    }

    // Devuelve los nombres de todos los productos (para la vista)
    public List<String> getNombresProductos() {
        List<String> nombres = new ArrayList<>();
        for (Producto p : productos) {
            nombres.add(p.getDescripcion());
        }
        return nombres;
    }

    // Punto 5: Devuelve los precios de un producto en todas las listas de precios
    public List<String> consultarPreciosPorProducto(int productoID) {
        List<String> resultado = new ArrayList<>();
        Producto producto = null;
        for (Producto p : productos) {
            if (p.getProductoID() == productoID) {
                producto = p;
                break;
            }
        }
        if (producto == null) return resultado;

        for (ListaPrecio lp : listaprecios) {
            // Lógica ficticia: precio base + 100 * id de lista
            double precio = producto.getPrecio() + lp.getListaPrecioID() * 100;
            resultado.add(lp.getDescripcion() + ": $" + precio);
        }
        return resultado;
    }
}