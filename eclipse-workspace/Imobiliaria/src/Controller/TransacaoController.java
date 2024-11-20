package Controller;

import Dao.TransacaoDao;
import Imobiliaria.Transacao;

import java.sql.SQLException;
import java.util.List;

public class TransacaoController {
    private TransacaoDao transacaoDao;
    
    public TransacaoController() {
        transacaoDao = new TransacaoDao();
    }
    
    public void adicionarTransacao(Transacao transacao) {
        try {
            transacaoDao.adicionarTransacao(transacao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       }
       
       public List<Transacao> listarTransacoes() {
           try {
               return transacaoDao.listarTransacoes();
           } catch (SQLException e) {
               e.printStackTrace();
               
               return null;
           }
       }
       }