package co.edu.uis.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorDto {
	@Id
	private int idDoctor;
	private String nombreMedico;
	private String especialidad;
	
	public DoctorDto(String idDoctor, String nombreMedico, String especialidad) {
		super();
		this.idDoctor = Integer.valueOf(idDoctor);;
		this.nombreMedico = nombreMedico;
		this.especialidad = especialidad;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
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

	@Override
	public String toString() {
		return "DoctorDto [idDoctor=" + idDoctor + ", nombreMedico=" + nombreMedico + ", especialidad=" + especialidad
				+ "]";
	}	

}
