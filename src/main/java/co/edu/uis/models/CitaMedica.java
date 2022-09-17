package co.edu.uis.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import co.edu.uis.dto.CitaMedicDto;

@SqlResultSetMapping(
		name= "listarCitasMedicasMapping",
		classes = {
				@ConstructorResult(targetClass = CitaMedicDto.class,
					columns = {
							@ColumnResult(name = "idmedical_appointment", type = String.class),
							@ColumnResult(name = "nombrePaciente", type = String.class),
							@ColumnResult(name = "nombreMedico", type = String.class),
							@ColumnResult(name = "especialidad", type = String.class),
							@ColumnResult(name = "fechaCita", type = Date.class),
					}
				)
			}
		)

@NamedNativeQuery(
		name = "CitaMedica.listarCitasMedicas",
		resultClass = CitaMedicDto.class,
		resultSetMapping = "listarCitasMedicasMapping",
		query = ("select medical_appointment.idmedical_appointment, "
				+ "concat(user.username, ' ', user.userLastName) as 'nombrePaciente', "
				+ "concat(workers.workerName, ' ', workers.workerLastName) as 'nombreMedico', "
				+ "doctors.area as 'especialidad' , "
				+ "medical_appointment.medical_appointment_date as fechaCita "
				+ "from medical_appointment "
				+ "inner join user on user.userId = medical_appointment.user_userId "
				+ "inner join doctors on doctors.idDoctor = medical_appointment.doctors_idDoctor "
				+ "inner join workers on workers.idworkers = doctors.id_workers;")
		)

@NamedNativeQuery(
		name = "CitaMedica.listarCitasMedicasbyId",
		resultClass = CitaMedicDto.class,
		resultSetMapping = "listarCitasMedicasMapping",
		query = ("select medical_appointment.idmedical_appointment, "
				+ "concat(user.username, ' ', user.userLastName) as 'nombrePaciente', "
				+ "concat(workers.workerName, ' ', workers.workerLastName) as 'nombreMedico', "
				+ "doctors.area as 'especialidad' , "
				+ "medical_appointment.medical_appointment_date as fechaCita "
				+ "from medical_appointment "
				+ "inner join user on user.userId = medical_appointment.user_userId "
				+ "inner join doctors on doctors.idDoctor = medical_appointment.doctors_idDoctor "
				+ "inner join workers on workers.idworkers = doctors.id_workers "
				+ "where medical_appointment.user_userId = ?1 ;")
		)

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
