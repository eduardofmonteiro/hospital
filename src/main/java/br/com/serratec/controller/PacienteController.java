package br.com.serratec.controller;

import java.util.ArrayList;
import java.util.List;
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
	
	@DeleteMapping("{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
	
	@PutMapping("{id}")
    public Paciente alterar(@PathVariable Integer id, @RequestBody Paciente p) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId().equals(id)) {
            	pacientes.set(i, p);
                return p;
            }
        }
        return null;
    }	
}
