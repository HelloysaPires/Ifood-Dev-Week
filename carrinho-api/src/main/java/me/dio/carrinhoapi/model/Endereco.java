package me.dio.carrinhoapi.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Embeddable
public class Endereco {
	
	private String cep;
	private String complemento;
	
	public Endereco(String cep, String complemento) {
		super();
		this.cep = cep;
		this.complemento = complemento;
	}

	public Endereco() {
		super();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
