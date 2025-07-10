package models;

    import dto.ClienteDTO;
    import java.util.ArrayList;
    import java.util.List;

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

        public ArrayList<ClienteDTO> getClientes() {
            ArrayList<ClienteDTO> result = new ArrayList<>();
            for (Cliente c : clientes) result.add(c.toDTO());
            return result;
        }
    }