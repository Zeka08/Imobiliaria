package Dao;

import Imobiliaria.Manutencao;
import ConexaoM.Mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDao {

	public void adicionarManutencao(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO Manutencao (id_imovel, tipo_manutencao, data_manutencao, custo) VALUES (?, ?, ?, ?)";
        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, manutencao.getIdImovel());
            stmt.setString(2, manutencao.getTipoManutencao());
            stmt.setDate(3, new java.sql.Date(manutencao.getDataManutencao().getTime()));
            stmt.setDouble(4, manutencao.getCusto());
            
            stmt.executeUpdate();
        }
    }
    
    public List<Manutencao> listarManutencoes() throws SQLException {
        List<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM Manutencao";
        
        try (Connection conn = Mysql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Manutencao manutencao = new Manutencao();
                manutencao.setIdManutencao(rs.getInt("id_manutencao"));
                manutencao.setIdImovel(rs.getInt("id_imovel"));
                manutencao.setTipoManutencao(rs.getString("tipo_manutencao"));
                manutencao.setDataManutencao(rs.getDate("data_manutencao"));
                manutencao.setCusto(rs.getDouble("custo"));
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
}
