package Dao;

import Imobiliaria.HistoricoTransacao;
import ConexaoM.Mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoTransacaoDao {

	 public void adicionarHistorico(HistoricoTransacao historico) throws SQLException {
	        String sql = "INSERT INTO Historico_Transacoes (id_imovel, id_cliente, data_transacao, valor) VALUES (?, ?, ?, ?)";
	        try (Connection conn = Mysql.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	             
	            if (historico.getIdImovel() != null) {
	                stmt.setInt(1, historico.getIdImovel());
	            } else {
	                stmt.setNull(1, Types.INTEGER);
	            }
	            
	            if (historico.getIdCliente() != null) {
	                stmt.setInt(2, historico.getIdCliente());
	            } else {
	                stmt.setNull(2, Types.INTEGER);
	            }
	            
	            stmt.setDate(3, new java.sql.Date(historico.getDataTransacao().getTime()));
	            stmt.setDouble(4, historico.getValor());
	            
	            stmt.executeUpdate();
	        }
	    }
	    
	    public List<HistoricoTransacao> listarHistorico() throws SQLException {
	        List<HistoricoTransacao> historicos = new ArrayList<>();
	        String sql = "SELECT * FROM Historico_Transacoes";
	        
	        try (Connection conn = Mysql.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	             
	            while (rs.next()) {
	                HistoricoTransacao historico = new HistoricoTransacao();
	                historico.setIdHistorico(rs.getInt("id_historico"));
	                int idImovel = rs.getInt("id_imovel");
	                if (!rs.wasNull()) {
	                    historico.setIdImovel(idImovel);
	                }
	                int idCliente = rs.getInt("id_cliente");
	                if (!rs.wasNull()) {
	                    historico.setIdCliente(idCliente);
	                }
	                historico.setDataTransacao(rs.getDate("data_transacao"));
	                historico.setValor(rs.getDouble("valor"));
	                historicos.add(historico);
	            }
	        }
	        return historicos;
	    }
}
