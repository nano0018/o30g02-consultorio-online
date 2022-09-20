package co.edu.uis.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
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
	
	@Column(nullable = true)
	private String observaciones;
	
	public CitaMedicDto(String idmedical_appointment, String nombrePaciente, String nombreMedico, String especialidad,
			Date fechaCita, String observaciones) {
		
		this.idmedical_appointment = Integer.valueOf(idmedical_appointment);
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
		this.especialidad = especialidad;		
		this.fechaCita = fechaCita;
		this.observaciones = observaciones;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "CitaMedicDto [idmedical_appointment=" + idmedical_appointment + ", nombrePaciente=" + nombrePaciente
				+ ", nombreMedico=" + nombreMedico + ", especialidad=" + especialidad + ", fechaCita=" + fechaCita
				+ ", observaciones=" + observaciones + "]";
	}
	
}
