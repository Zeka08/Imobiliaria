package Controller;

import Dao.ManutencaoDao;
import Imobiliaria.Manutencao;

import java.sql.SQLException;
import java.util.List;

public class ManutencaoController {
    private ManutencaoDao manutencaoDao;
    
    public ManutencaoController() {
        manutencaoDao = new ManutencaoDao();
    }
    
    public void adicionarManutencao(Manutencao manutencao) {
        try {
            manutencaoDao.adicionarManutencao(manutencao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      }
      
      public List<Manutencao> listarManutencoes() {
          try {
              return manutencaoDao.listarManutencoes();
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
      }
      }