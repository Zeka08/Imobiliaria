package Imobiliaria;

import java.util.Date;

public class Transacao {
	   private int idTransacao;
	    private int idImovel;
	    private int idCliente;
	    private Date dataTransacao;
	    private double valor;
	    private String tipoTransacao;
	    
	    public Transacao() {}
	    
	    public Transacao(int idTransacao, int idImovel, int idCliente, Date dataTransacao, double valor, String tipoTransacao) {
	        this.idTransacao = idTransacao;
	        this.idImovel = idImovel;
	        this.idCliente = idCliente;
	        this.dataTransacao = dataTransacao;
	        this.valor = valor;
	        this.tipoTransacao = tipoTransacao;
	    }
	    
	        public int getIdTransacao() {
	            return idTransacao;
	        }
	        public void setIdTransacao(int idTransacao) {
	            this.idTransacao = idTransacao;
	        }
	        public int getIdImovel() {
	            return idImovel;
	        }
	        public void setIdImovel(int idImovel) {
	            this.idImovel = idImovel;
	        }
	        public int getIdCliente() {
	            return idCliente;
	        }
	        public void setIdCliente(int idCliente) {
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
	        public String getTipoTransacao() {
	            return tipoTransacao;
	        }
	        public void setTipoTransacao(String tipoTransacao) {
	            this.tipoTransacao = tipoTransacao;
	        }
	        
	        @Override
	        public String toString() {
	            return "Transacao [idTransacao=" + idTransacao + ", idImovel=" + idImovel + ", idCliente=" + idCliente
	                    + ", dataTransacao=" + dataTransacao + ", valor=" + valor + ", tipoTransacao=" + tipoTransacao + "]";
	        
	    
	    }
}
