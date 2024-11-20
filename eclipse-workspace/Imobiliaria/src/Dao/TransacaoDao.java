package Dao;

import Imobiliaria.Transacao;
import ConexaoM.Mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {

	  public void adicionarTransacao(Transacao transacao) throws SQLException {
	        String sql = "INSERT INTO Transacao (id_imovel, id_cliente, data_transacao, valor, tipo_transacao) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = Mysql.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	             
	            stmt.setInt(1, transacao.getIdImovel());
	            stmt.setInt(2, transacao.getIdCliente());
	            stmt.setDate(3, new java.sql.Date(transacao.getDataTransacao().getTime()));
	            stmt.setDouble(4, transacao.getValor());
	            stmt.setString(5, transacao.getTipoTransacao());
	            
	            stmt.executeUpdate();
	        }
	    }
	    
	    public List<Transacao> listarTransacoes() throws SQLException {
	        List<Transacao> transacoes = new ArrayList<>();
	        String sql = "SELECT * FROM Transacao";
	        
	        try (Connection conn = Mysql.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	             
	            while (rs.next()) {
	                Transacao transacao = new Transacao();
	                transacao.setIdTransacao(rs.getInt("id_transacao"));
	                transacao.setIdImovel(rs.getInt("id_imovel"));
	                transacao.setIdCliente(rs.getInt("id_cliente"));
	                transacao.setDataTransacao(rs.getDate("data_transacao"));
	                transacao.setValor(rs.getDouble("valor"));
	                transacao.setTipoTransacao(rs.getString("tipo_transacao"));
	                transacoes.add(transacao);
	            }
	        }
	        return transacoes;
	    }
}
