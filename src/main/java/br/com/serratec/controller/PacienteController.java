package br.com.serratec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratec.entity.Paciente;
import br.com.serratec.repository.PacienteRepository;
import jakarta.validation.Valid;

public class PacienteController {

	private static List<Paciente> pacientes = new ArrayList<>(); 
	
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	public Paciente inserir(@RequestBody Paciente p) {
		return repository.save(p);
	}
	
	@GetMapping
	public List <Paciente> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}/consultas")
    public Paciente listarPacienteComConsultas(@Valid @PathVariable Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        if (paciente.isPresent()) {
            return paciente.get();
        } else {
            throw new RuntimeException("Paciente não encontrado");
        }
    }
	
	@DeleteMapping("{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
	
	@PutMapping("{id}")
    public Paciente alterar(@PathVariable Long id, @RequestBody Paciente p) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId().equals(id)) {
            	pacientes.set(i, p);
                return p;
            }
        }
        return null;
    }	

}
