package models;

import java.util.ArrayList;
import java.util.List;

//corregí la eliminacion del dto en ListaPrecio y la movimos a ClienteController
public class ListaPrecio {
    private int listaPreciosID;
    private String descripcion;
    private List<Cliente> clientes = new ArrayList<>();

    public ListaPrecio(int id, String descripcion) {
        this.listaPreciosID = id;
        this.descripcion = descripcion;
    }

    public int getListaPrecioID() { return listaPreciosID; }
    public String getDescripcion() { return descripcion; }

    public void addCliente(Cliente c) { clientes.add(c); }

    // Ahora devuelve la lista de clientes (no DTOs)
    public List<Cliente> getClientes() {
        return clientes;
    }
}