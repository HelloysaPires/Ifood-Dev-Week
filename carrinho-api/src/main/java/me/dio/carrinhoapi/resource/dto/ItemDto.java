package me.dio.carrinhoapi.resource.dto;

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
public class ItemDto {
	
	private Long produtoId;
	private int quantidade;
	private Long sacolaId;
	
	
	public ItemDto(Long produtoId, int quantidade, Long sacolaId) {
		super();
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.sacolaId = sacolaId;
	}
	
	public ItemDto() {
		
	}
	
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Long getSacolaId() {
		return sacolaId;
	}
	public void setSacolaId(Long sacolaId) {
		this.sacolaId = sacolaId;
	}
	
	

}
