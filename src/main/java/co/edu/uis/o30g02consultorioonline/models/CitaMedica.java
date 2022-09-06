package co.edu.uis.o30g02consultorioonline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medical_appointment")
public class CitaMedica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmedical_appointment")
	private int idmedical_appointment;
	
	@Column(name="user_userId")
	private int user_userId;
	
	@Column(name="doctors_idDoctor")
	private int doctors_idDoctor;
	
	@Column(name="medicalFormula_idmedicalFormula")
	private int medicalFormula_idmedicalFormula;
	
	@Column(name="observations")
	private String observations;
	
	public CitaMedica() {
		
	}

	public CitaMedica(int idmedical_appointment, int user_userId, int doctors_idDoctor,
			int medicalFormula_idmedicalFormula, String observations) {		
		this.idmedical_appointment = idmedical_appointment;
		this.user_userId = user_userId;
		this.doctors_idDoctor = doctors_idDoctor;
		this.medicalFormula_idmedicalFormula = medicalFormula_idmedicalFormula;
		this.observations = observations;
	}

	public int getIdmedical_appointment() {
		return idmedical_appointment;
	}

	public void setIdmedical_appointment(int idmedical_appointment) {
		this.idmedical_appointment = idmedical_appointment;
	}

	public int getUser_userId() {
		return user_userId;
	}

	public void setUser_userId(int user_userId) {
		this.user_userId = user_userId;
	}

	public int getDoctors_idDoctor() {
		return doctors_idDoctor;
	}

	public void setDoctors_idDoctor(int doctors_idDoctor) {
		this.doctors_idDoctor = doctors_idDoctor;
	}

	public int getMedicalFormula_idmedicalFormula() {
		return medicalFormula_idmedicalFormula;
	}

	public void setMedicalFormula_idmedicalFormula(int medicalFormula_idmedicalFormula) {
		this.medicalFormula_idmedicalFormula = medicalFormula_idmedicalFormula;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public String toString() {
		return "CitaMedica [idmedical_appointment=" + idmedical_appointment + ", user_userId=" + user_userId
				+ ", doctors_idDoctor=" + doctors_idDoctor + ", medicalFormula_idmedicalFormula="
				+ medicalFormula_idmedicalFormula + ", observations=" + observations + "]";
	}
	
}
