package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Consulta;
import br.com.serratec.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository repository;
	
	@PostMapping
	public Consulta inserir(@RequestBody Consulta c) {
		return repository.save(c);
	}
	
}
