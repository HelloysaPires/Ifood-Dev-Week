package me.dio.carrinhoapi.service;

import me.dio.carrinhoapi.model.Item;
import me.dio.carrinhoapi.model.Sacola;
import me.dio.carrinhoapi.resource.dto.ItemDto;

public interface SacolaService {
	
	Item incluirItemNaSacola(ItemDto itemDto);
	
	Sacola verSacola(Long id);
	
	Sacola fecharSacola(Long id, int formaPagamento);
	
}
