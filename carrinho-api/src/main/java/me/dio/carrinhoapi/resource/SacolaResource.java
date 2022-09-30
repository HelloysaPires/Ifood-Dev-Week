package me.dio.carrinhoapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import me.dio.carrinhoapi.model.Item;
import me.dio.carrinhoapi.model.Sacola;
import me.dio.carrinhoapi.resource.dto.ItemDto;
import me.dio.carrinhoapi.service.SacolaService;

@Api(value="/ifood/sacolas")
@RestController
@RequestMapping("/ifood/sacola")
public class SacolaResource {
	
	private final SacolaService sacolaService;
	
	public SacolaResource(SacolaService sacolaService) {
		super();
		this.sacolaService = sacolaService;
	}

	@PostMapping
	Item incluirItemNaSacola(@RequestBody ItemDto itemDto) {
		return sacolaService.incluirItemNaSacola(itemDto);
	}
	
	@GetMapping("/{id}")
	Sacola verSacola(@PathVariable Long id) {
		return sacolaService.verSacola(id);
	}
	
	
	@PatchMapping("/fechar/{id}")
	Sacola fecharSacola(@PathVariable Long id, @RequestParam int formaPagamento) {
		return sacolaService.fecharSacola(id, formaPagamento);
	}
}
