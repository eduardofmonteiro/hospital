package br.com.serratec.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.serratec.enumerated.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataConsulta;
	private LocalTime horaConsulta;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	private String paciente;
	
	@ManyToOne
	private String medico; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}
	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	
}
