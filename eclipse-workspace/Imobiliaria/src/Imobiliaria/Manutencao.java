package Imobiliaria;

import java.util.Date;

public class Manutencao {
    private int idManutencao;
    private int idImovel;
    private String tipoManutencao;
    private Date dataManutencao;
    private double custo;
    
 public Manutencao() {}
    
    public Manutencao(int idManutencao, int idImovel, String tipoManutencao, Date dataManutencao, double custo) {
        this.idManutencao = idManutencao;
        this.idImovel = idImovel;
        this.tipoManutencao = tipoManutencao;
        this.dataManutencao = dataManutencao;
        this.custo = custo;
    }
        
        public int getIdManutencao() {
            return idManutencao;
        }
        public void setIdManutencao(int idManutencao) {
            this.idManutencao = idManutencao;
        }
        public int getIdImovel() {
            return idImovel;
        }
        public void setIdImovel(int idImovel) {
            this.idImovel = idImovel;
        }
        public String getTipoManutencao() {
            return tipoManutencao;
        }
        public void setTipoManutencao(String tipoManutencao) {
            this.tipoManutencao = tipoManutencao;
        }
        public Date getDataManutencao() {
            return dataManutencao;
        }
        public void setDataManutencao(Date dataManutencao) {
            this.dataManutencao = dataManutencao;
        }
        public double getCusto() {
            return custo;
        }
        public void setCusto(double custo) {
            this.custo = custo;
        }
        
        @Override
        public String toString() {
            return "Manutencao [idManutencao=" + idManutencao + ", idImovel=" + idImovel + ", tipoManutencao="
                    + tipoManutencao + ", dataManutencao=" + dataManutencao + ", custo=" + custo + "]";
        
    }
        
    }