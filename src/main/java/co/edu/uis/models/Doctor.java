package co.edu.uis.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iddoctor")
	private int idDoctor;
	
	@Column(name="area")
	private String area;
	
	@Column(name="id_workers")
	private int id_workers;

	public Doctor() {
		super();
	}

	public Doctor(int idDoctor, String area, int id_workers) {
		super();
		this.idDoctor = idDoctor;
		this.area = area;
		this.id_workers = id_workers;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getId_workers() {
		return id_workers;
	}

	public void setId_workers(int id_workers) {
		this.id_workers = id_workers;
	}
	
	
}
