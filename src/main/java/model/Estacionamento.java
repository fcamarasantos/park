package model;

public class Estacionamento {
	private int cnpj;
	private String nomeEstacionamento;
	private String endereco;
	private int telefone;
	private int vagasMoto;
	private int vagasCarro;
	
	
	public int nomeEstacionamento() {
		return cnpj;
	}
	
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}
	
	public void setNomeEstacionamento(String nomeEstacionamento) {
		this.nomeEstacionamento = nomeEstacionamento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
