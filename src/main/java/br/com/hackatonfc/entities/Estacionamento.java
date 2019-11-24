package br.com.hackatonfc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import br.com.hackatonfc.dtos.EstacionamentoDto;

@Entity
@Component
@Table(name = "estacionamento")

public class Estacionamento implements Serializable {
	private static final long serialVersionUID = -6888542263201514002L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_estacionamento", nullable = false)
	private String nomeEstacionamento;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "endereco", nullable = true)
	private String endereco;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "telefone", nullable = true)
	private String telefone;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "vagasCarro", nullable = true)
	private String vagasCarro;
	
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "vagasMoto", nullable = true)
	private String vagasMoto;
	
	public Estacionamento() {

	}
	
	public Estacionamento(Long id, String nomeEstacionamento, String cnpj, String endereco, String telefone, String vagasCarro, String vagasMoto ) {
		this.id = id;
		this.nomeEstacionamento = nomeEstacionamento;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.vagasCarro = vagasCarro;
		this.vagasMoto = vagasMoto;

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}

	public void setNomeEstacionamento(String nomeEstacionamento) {
		this.nomeEstacionamento = nomeEstacionamento;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getVagasCarro() {
		return vagasCarro;
	}

	public void setVagasCarro(String vagasCarro) {
		this.vagasCarro = vagasCarro;
	}
	
	public String getVagasMoto() {
		return vagasMoto;
	}

	public void setVagasMoto(String vagasMoto) {
		this.vagasMoto = vagasMoto;
	}
	
	@Override
	public String toString() {
		return "Estacionamento [id=" + id + ", nomeEstacionamento=" + nomeEstacionamento + ", cnpj=" + cnpj
				+ ", endereco=" + endereco + ", telefone=" + telefone + ", vagasCarro="+ vagasCarro + ", vagasMoto= "+ vagasMoto +  "]";
	}

	public void setDataPartida(Class<? extends EstacionamentoDto> class1) {
		// TODO Auto-generated method stub
		
	}
}
