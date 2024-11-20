package Controller;

import Dao.HistoricoTransacaoDao;
import Imobiliaria.HistoricoTransacao;

import java.sql.SQLException;
import java.util.List;

public class HistoricoTransacaoController {
    private HistoricoTransacaoDao historicoDao;
    
    public HistoricoTransacaoController() {
        historicoDao = new HistoricoTransacaoDao();
    }
    
    public void adicionarHistorico(HistoricoTransacao historico) {
        try {
            historicoDao.adicionarHistorico(historico);
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
      }
      
      public List<HistoricoTransacao> listarHistorico() {
          try {
              return historicoDao.listarHistorico();
          } catch (SQLException e) {
              e.printStackTrace();
              return null;
          }
      }}