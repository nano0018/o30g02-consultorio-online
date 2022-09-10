package co.edu.uis.o30g02consultorioonline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmedicine")
	private int idmedicine;
	
	@Column(name="medicine_name")
	private String medicine_name;
	
	@Column(name="medicine_amount")
	private int medicine_amount;
	
	@Column(name="medicine_dose")
	private int medicine_dose;
		

	public Medicamento() {
		super();
	}	
	
	public Medicamento(int idmedicine, String medicine_name, int medicine_amount, int medicine_dose) {
		super();
		this.idmedicine = idmedicine;
		this.medicine_name = medicine_name;
		this.medicine_amount = medicine_amount;
		this.medicine_dose = medicine_dose;
	}

	public int getIdmedicine() {
		return idmedicine;
	}

	public void setIdmedicine(int idmedicine) {
		this.idmedicine = idmedicine;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public int getMedicine_amount() {
		return medicine_amount;
	}

	public void setMedicine_amount(int medicine_amount) {
		this.medicine_amount = medicine_amount;
	}

	public int getMedicine_dose() {
		return medicine_dose;
	}

	public void setMedicine_dose(int medicine_dose) {
		this.medicine_dose = medicine_dose;
	}

	@Override
	public String toString() {
		return "Medicamento [idmedicine=" + idmedicine + ", medicine_name=" + medicine_name + ", medicine_amount="
				+ medicine_amount + ", medicine_dose=" + medicine_dose + "]";
	}
		
}
