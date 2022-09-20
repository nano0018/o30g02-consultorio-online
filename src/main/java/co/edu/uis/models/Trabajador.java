package co.edu.uis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="workers")
public class Trabajador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idworkers")
	private int idWorkers;
	
	@Column(name="workername")
	private String workerName;
	
	@Column(name="workerlastname")
	private String workerLastName;
	
	@Column(name="workeremployment")
	private String workerEmployment;
	
	@Column(name="workersalary")
	private Double workerSalary;
	
	@Column(name="workertel")
	private String workerTel;
	
	@Column(name="typecontract")
	private String typeContract;
	
	@Column(name="workerpassword")
	private String workerPassword;

	public Trabajador() {
		super();
	}

	public Trabajador(int idWorkers, String workerName, String workerLastName, String workerEmployment,
			Double workerSalary, String workerTel, String typeContract, String workerPassword) {
		super();
		this.idWorkers = idWorkers;
		this.workerName = workerName;
		this.workerLastName = workerLastName;
		this.workerEmployment = workerEmployment;
		this.workerSalary = workerSalary;
		this.workerTel = workerTel;
		this.typeContract = typeContract;
		this.workerPassword = workerPassword;
	}

	public int getIdWorkers() {
		return idWorkers;
	}

	public void setIdWorkers(int idWorkers) {
		this.idWorkers = idWorkers;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerLastName() {
		return workerLastName;
	}

	public void setWorkerLastName(String workerLastName) {
		this.workerLastName = workerLastName;
	}

	public String getWorkerEmployment() {
		return workerEmployment;
	}

	public void setWorkerEmployment(String workerEmployment) {
		this.workerEmployment = workerEmployment;
	}

	public Double getWorkerSalary() {
		return workerSalary;
	}

	public void setWorkerSalary(Double workerSalary) {
		this.workerSalary = workerSalary;
	}

	public String getWorkerTel() {
		return workerTel;
	}

	public void setWorkerTel(String workerTel) {
		this.workerTel = workerTel;
	}

	public String getTypeContract() {
		return typeContract;
	}

	public void setTypeContract(String typeContract) {
		this.typeContract = typeContract;
	}

	public String getWorkerPassword() {
		return workerPassword;
	}

	public void setWorkerPassword(String workerPassword) {
		this.workerPassword = workerPassword;
	}

	@Override
	public String toString() {
		return "Workers [idWorkers=" + idWorkers + ", workerName=" + workerName + ", workerLastName=" + workerLastName
				+ ", workerEmployment=" + workerEmployment + ", workerSalary=" + workerSalary + ", workerTel="
				+ workerTel + ", typeContract=" + typeContract + ", workerPassword=" + workerPassword + "]";
	}
	
}
