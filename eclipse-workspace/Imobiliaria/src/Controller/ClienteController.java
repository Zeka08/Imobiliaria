package Controller;

import Dao.ClienteDao;
import Imobiliaria.cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteController {
    private ClienteDao clienteDao;
    
    public ClienteController() {
        clienteDao = new ClienteDao();
    }
    
    public void adicionarCliente(cliente cliente) {
        try {
            clienteDao.adicionarCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();


}}
    public List<cliente> listarClientes() {
        try {
            return clienteDao.listarClientes();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    }
