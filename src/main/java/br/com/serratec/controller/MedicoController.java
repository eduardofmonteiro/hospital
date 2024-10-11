package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.serratec.entity.Medico;
import br.com.serratec.repository.MedicoRepository;

public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	public Medico inserir(@RequestBody Medico m) {
		return repository.save(m);
	}
	
	@GetMapping
	public List <Medico> listar(){
		return repository.findAll();
	}
	
}
