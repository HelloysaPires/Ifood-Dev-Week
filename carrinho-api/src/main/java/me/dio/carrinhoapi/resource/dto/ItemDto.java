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

}
