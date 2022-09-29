package me.dio.carrinhoapi.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import me.dio.carrinhoapi.enumeration.FormaPagamento;
import me.dio.carrinhoapi.model.Item;
import me.dio.carrinhoapi.model.Sacola;
import me.dio.carrinhoapi.repository.SacolaRepository;
import me.dio.carrinhoapi.resource.dto.ItemDto;
import me.dio.carrinhoapi.service.SacolaService;

@Service
public class SacolaServiceImpl implements SacolaService {

	private final SacolaRepository sacolaRepository;
	
	public SacolaServiceImpl(SacolaRepository sacolaRepository) {
		super();
		this.sacolaRepository = sacolaRepository;
	}

	@Override
	public Item incluirItemNaSacola(ItemDto itemDto) {
	
		
		
		return null;
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
