package co.edu.uis.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicalformula")
public class FormulaMedica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmedicalFormula")
	private int idmedicalFormula;
	
	@Column(name="medical_formula_date")
	private Date medical_formula_date;
	
	@Column(name="doctors_idDoctor")
	private int doctors_idDoctor;
	
	@Column(name="user_userId")
	private int user_userId;
	
	@Column(name="medicine_idmedicine")
	private int medicine_idmedicine;
	
	public FormulaMedica() {
		super();
	}

	public FormulaMedica(int idmedicalFormula, Date medical_formula_date, int doctors_idDoctor, int user_userId,
			int medicine_idmedicine) {
		super();
		this.idmedicalFormula = idmedicalFormula;
		this.medical_formula_date = medical_formula_date;
		this.doctors_idDoctor = doctors_idDoctor;
		this.user_userId = user_userId;
		this.medicine_idmedicine = medicine_idmedicine;
	}

	public int getIdmedicalFormula() {
		return idmedicalFormula;
	}

	public void setIdmedicalFormula(int idmedicalFormula) {
		this.idmedicalFormula = idmedicalFormula;
	}

	public Date getMedical_formula_date() {
		return medical_formula_date;
	}

	public void setMedical_formula_date(Date medical_formula_date) {
		this.medical_formula_date = medical_formula_date;
	}

	public int getDoctors_idDoctor() {
		return doctors_idDoctor;
	}

	public void setDoctors_idDoctor(int doctors_idDoctor) {
		this.doctors_idDoctor = doctors_idDoctor;
	}

	public int getUser_userId() {
		return user_userId;
	}

	public void setUser_userId(int user_userId) {
		this.user_userId = user_userId;
	}

	public int getMedicine_idmedicine() {
		return medicine_idmedicine;
	}

	public void setMedicine_idmedicine(int medicine_idmedicine) {
		this.medicine_idmedicine = medicine_idmedicine;
	}

	@Override
	public String toString() {
		return "FormulaMedica [idmedicalFormula=" + idmedicalFormula + ", medical_formula_date=" + medical_formula_date
				+ ", doctors_idDoctor=" + doctors_idDoctor + ", user_userId=" + user_userId + ", medicine_idmedicine="
				+ medicine_idmedicine + "]";
	}
	
}
