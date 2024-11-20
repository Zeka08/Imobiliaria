package Imobiliaria;

import java.util.Date;

public class HistoricoTransacao {
    private int idHistorico;
    private Integer idImovel; 
    private Integer idCliente; 
    private Date dataTransacao;
    private double valor;
    
 public HistoricoTransacao() {}
    
    public HistoricoTransacao(int idHistorico, Integer idImovel, Integer idCliente, Date dataTransacao, double valor) {
        this.idHistorico = idHistorico;
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
    }
        
        public int getIdHistorico() {
            return idHistorico;
        }
        public void setIdHistorico(int idHistorico) {
            this.idHistorico = idHistorico;
        }
        public Integer getIdImovel() {
            return idImovel;
        }
        public void setIdImovel(Integer idImovel) {
            this.idImovel = idImovel;
        }
        public Integer getIdCliente() {
            return idCliente;
        }
        public void setIdCliente(Integer idCliente) {
            this.idCliente = idCliente;
        }
        public Date getDataTransacao() {
            return dataTransacao;
        }
        public void setDataTransacao(Date dataTransacao) {
            this.dataTransacao = dataTransacao;
        }
        public double getValor() {
            return valor;
        }
        public void setValor(double valor) {
            this.valor = valor;
        }
        
        @Override
        public String toString() {
            return "HistoricoTransacoes [idHistorico=" + idHistorico + ", idImovel=" + idImovel + ", idCliente="
                    + idCliente + ", dataTransacao=" + dataTransacao + ", valor=" + valor + "]";
        
    }
    }