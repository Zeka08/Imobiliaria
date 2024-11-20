package Dao;

import Imobiliaria.imovel;
import ConexaoM.Mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDao {

	public void adicionarImovel(imovel imovel) throws SQLException {
        String sql = "INSERT INTO Imovel (categoria, area, valor_sugerido, valor_real, endereco, bairro, data_construcao, disponibilidade, descricao) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, imovel.getCategoria());
            stmt.setDouble(2, imovel.getArea());
            stmt.setDouble(3, imovel.getValorSugerido());
            if (imovel.getValorReal() != null) {
                stmt.setDouble(4, imovel.getValorReal());
            } else {
                stmt.setNull(4, Types.DECIMAL);
            }
            stmt.setString(5, imovel.getEndereco());
            stmt.setString(6, imovel.getBairro());
            stmt.setDate(7, new java.sql.Date(imovel.getDataConstrucao().getTime()));
            stmt.setString(8, imovel.getDisponibilidade());
            stmt.setString(9, imovel.getDescricao());
            
            stmt.executeUpdate();
        }
    }
    
    public List<imovel> listarImoveis() throws SQLException {
        List<imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM Imovel";
        
        try (Connection conn = Mysql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                imovel imovel = new imovel();
                imovel.setIdImovel(rs.getInt("id_imovel"));
                imovel.setCategoria(rs.getString("categoria"));
                imovel.setArea(rs.getDouble("area"));
                imovel.setValorSugerido(rs.getDouble("valor_sugerido"));
                imovel.setValorReal(rs.getDouble("valor_real"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setDataConstrucao(rs.getDate("data_construcao"));
                imovel.setDisponibilidade(rs.getString("disponibilidade"));
                imovel.setDescricao(rs.getString("descricao"));
                imoveis.add(imovel);
            }
        }
        return imoveis;
    }
    
}
