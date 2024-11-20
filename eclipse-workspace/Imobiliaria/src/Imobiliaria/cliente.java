package Imobiliaria;

public class cliente {
	  private int idCliente;
	    private String nome;
	    private String tipoRelacionamento;
	    private String telefone;
	    private double avaliacaoCliente;
	    
	    public cliente() {}
	    
	    public int getIdCliente() {
	        return idCliente;
	    }
	    public void setIdCliente(int idCliente) {
	        this.idCliente = idCliente;
	    }
	    public String getNome() {
	        return nome;
	    }
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    public String getTipoRelacionamento() {
	        return tipoRelacionamento;
	    }
	    public void setTipoRelacionamento(String tipoRelacionamento) {
	        this.tipoRelacionamento = tipoRelacionamento;
	    }
	    public String getTelefone() {
	        return telefone;
	    }
	    public void setTelefone(String telefone) {
	        this.telefone = telefone;
	    }
	    public double getAvaliacaoCliente() {
	        return avaliacaoCliente;
	    }
	    public void setAvaliacaoCliente(double avaliacaoCliente) {
	        this.avaliacaoCliente = avaliacaoCliente;
	    }
	    
	    @Override
	    public String toString() {
	        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", tipoRelacionamento=" + tipoRelacionamento
	                + ", telefone=" + telefone + ", avaliacaoCliente=" + avaliacaoCliente + "]";
	    }
	}

	
