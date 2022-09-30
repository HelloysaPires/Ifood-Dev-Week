package me.dio.carrinhoapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.carrinhoapi.enumeration.FormaPagamento;
import me.dio.carrinhoapi.model.Item;
import me.dio.carrinhoapi.model.Restaurante;
import me.dio.carrinhoapi.model.Sacola;
import me.dio.carrinhoapi.repository.ItemRepository;
import me.dio.carrinhoapi.repository.ProdutoRepository;
import me.dio.carrinhoapi.repository.SacolaRepository;
import me.dio.carrinhoapi.resource.dto.ItemDto;
import me.dio.carrinhoapi.service.SacolaService;

@Service
public class SacolaServiceImpl implements SacolaService {

	private final SacolaRepository sacolaRepository;
	private final ProdutoRepository produtoRepository;
	private final ItemRepository itemRepository;
	

	public SacolaServiceImpl(SacolaRepository sacolaRepository, ProdutoRepository produtoRepository,
			ItemRepository itemRepository) {
		super();
		this.sacolaRepository = sacolaRepository;
		this.produtoRepository = produtoRepository;
		this.itemRepository = itemRepository;
	}

	@Override
	public Item incluirItemNaSacola(ItemDto itemDto) {
	
		Sacola sacola = verSacola(itemDto.getSacolaId());
		
		if(sacola.isFechada())	throw new RuntimeException("Erro! Essa sacola está fechada.");
		
		Item item = new Item();
		item.setQuantidade(itemDto.getQuantidade());
		item.setSacola(sacola);
		item.setProduto(produtoRepository.findById(itemDto.getProdutoId())
									     .orElseThrow(
									 		() -> {
													throw new RuntimeException("Produto não encontrado!");
												}
									     ));
		List<Item> itensDaSacola = sacola.getItens();
		
		if(itensDaSacola.isEmpty()) {
			itensDaSacola.add(item);
		}else {
			Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();
			Restaurante restauranteDoItem = item.getProduto().getRestaurante();
			
			if(restauranteAtual.equals(restauranteDoItem)) itensDaSacola.add(item);
			else throw new RuntimeException("Não é possível adiconar produtos de restaurantes diferentes! Feche a sacola ou esvazie.");
		}
		
		List<Double> valorDosItem = new ArrayList<>();
		
		for(Item itemDaSacola: itensDaSacola) {
			double valorTotal = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
			valorDosItem.add(valorTotal);
		}
		
		Double valorTotalSacola = 0.0;
		
		for(Double valorItem: valorDosItem) {
			valorTotalSacola +=  valorItem;
		}
		
		sacola.setValorTotal(valorTotalSacola);
		sacolaRepository.save(sacola);
		return item;
	}

	@Override
	public Sacola verSacola(Long id) {
		return sacolaRepository.findById(id).orElseThrow(
			() -> {
				throw new RuntimeException("Id não encontrado!");
			}
		);
	}

	@Override
	public Sacola fecharSacola(Long id, int formaPagamento) {

		Sacola sacola = verSacola(id);
		
		if(sacola.getItens().isEmpty()) {
			throw new RuntimeException("Sacola vazia!");
		}
		
		FormaPagamento fp =  formaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
		
		sacola.setFormaPagamento(fp);
		sacola.setFechada(true);
		
		return sacolaRepository.save(sacola);

	}

}
