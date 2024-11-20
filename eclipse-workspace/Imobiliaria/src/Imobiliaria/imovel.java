package Imobiliaria;

import java.util.Date;

public class imovel {
	 private int idImovel;
	    private String categoria;
	    private double area;
	    private double valorSugerido;
	    private Double valorReal;
	    private String endereco;
	    private String bairro;
	    private Date dataConstrucao;
	    private String disponibilidade;
	    private String descricao;
	    
	    public imovel() {}
	    
	    public imovel(int idImovel, String categoria, double area, double valorSugerido, Double valorReal, String endereco,
	                  String bairro, Date dataConstrucao, String disponibilidade, String descricao) {
	        this.idImovel = idImovel;
	        this.categoria = categoria;
	        this.area = area;
	        this.valorSugerido = valorSugerido;
	        this.valorReal = valorReal;
	        this.endereco = endereco;
	        this.bairro = bairro;
	        this.dataConstrucao = dataConstrucao;
	        this.disponibilidade = disponibilidade;
	        this.descricao = descricao;
	    }
	        
	        public int getIdImovel() {
	            return idImovel;
	        }
	        public void setIdImovel(int idImovel) {
	            this.idImovel = idImovel;
	        }
	        public String getCategoria() {
	            return categoria;
	        }
	        public void setCategoria(String categoria) {
	            this.categoria = categoria;
	        }
	        public double getArea() {
	            return area;
	        }
	        public void setArea(double area) {
	            this.area = area;
	        }
	        public double getValorSugerido() {
	            return valorSugerido;
	        }
	        public void setValorSugerido(double valorSugerido) {
	            this.valorSugerido = valorSugerido;
	        }
	        public Double getValorReal() {
	            return valorReal;
	        }
	        public void setValorReal(Double valorReal) {
	            this.valorReal = valorReal;
	        }
	        public String getEndereco() {
	            return endereco;
	        }
	        public void setEndereco(String endereco) {
	            this.endereco = endereco;
	        }
	        public String getBairro() {
	            return bairro;
	        }
	        public void setBairro(String bairro) {
	            this.bairro = bairro;
	        }
	        public Date getDataConstrucao() {
	            return dataConstrucao;
	        }
	        public void setDataConstrucao(Date dataConstrucao) {
	            this.dataConstrucao = dataConstrucao;
	        }
	        public String getDisponibilidade() {
	            return disponibilidade;
	        }
	        public void setDisponibilidade(String disponibilidade) {
	            this.disponibilidade = disponibilidade;
	        }
	        public String getDescricao() {
	            return descricao;
	        }
	        public void setDescricao(String descricao) {
	            this.descricao = descricao;
	        }
	        
	        @Override
	        public String toString() {
	            return "Imovel [idImovel=" + idImovel + ", categoria=" + categoria + ", area=" + area + ", valorSugerido="
	                    + valorSugerido + ", valorReal=" + valorReal + ", endereco=" + endereco + ", bairro=" + bairro
	                    + ", dataConstrucao=" + dataConstrucao + ", disponibilidade=" + disponibilidade + ", descricao="
	                    + descricao + "]";
	        
	    
	    
}}
