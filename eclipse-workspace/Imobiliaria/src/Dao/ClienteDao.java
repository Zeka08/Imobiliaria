package Dao;

import Imobiliaria.cliente;
import ConexaoM.Mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

	public void adicionarCliente(cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, tipo_relacionamento, telefone, avaliacao_cliente) VALUES (?, ?, ?, ?)";
        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTipoRelacionamento());
            stmt.setString(3, cliente.getTelefone());
            stmt.setDouble(4, cliente.getAvaliacaoCliente());
            
            stmt.executeUpdate();
        }
    }
    
    public List<cliente> listarClientes() throws SQLException {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        
        try (Connection conn = Mysql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                cliente cliente = new cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTipoRelacionamento(rs.getString("tipo_relacionamento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setAvaliacaoCliente(rs.getDouble("avaliacao_cliente"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    
}
