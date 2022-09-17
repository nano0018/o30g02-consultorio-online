package co.edu.uis.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CitaMedicDto {

	@Id
	private int idmedical_appointment;
	private String nombrePaciente;
	private String nombreMedico;
	private String especialidad;
	private Date fechaCita;
	
	public CitaMedicDto(String idmedical_appointment, String nombrePaciente, String nombreMedico, String especialidad,
			Date fechaCita) {
		
		this.idmedical_appointment = Integer.valueOf(idmedical_appointment);
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
		this.especialidad = especialidad;
		this.fechaCita = fechaCita;
	}

	public int getIdmedical_appointment() {
		return idmedical_appointment;
	}

	public void setIdmedical_appointment(int idmedical_appointment) {
		this.idmedical_appointment = idmedical_appointment;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}
	
	
	

}
