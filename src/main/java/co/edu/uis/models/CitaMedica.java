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

import org.springframework.format.annotation.DateTimeFormat;

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
							@ColumnResult(name = "observaciones", type = String.class),
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
				+ "medical_appointment.medical_appointment_date as fechaCita, "
				+ "medical_appointment.observations as observaciones "
				+ "from medical_appointment "
				+ "inner join user on user.userId = medical_appointment.user_userId "
				+ "inner join doctors on doctors.idDoctor = medical_appointment.doctors_idDoctor "
				+ "inner join workers on workers.idworkers = doctors.id_workers;")
		)

@NamedNativeQuery(
		name = "CitaMedica.listarCitasMedicasbyUserId",
		resultClass = CitaMedicDto.class,
		resultSetMapping = "listarCitasMedicasMapping",
		query = ("select medical_appointment.idmedical_appointment, "
				+ "concat(user.username, ' ', user.userLastName) as 'nombrePaciente', "
				+ "concat(workers.workerName, ' ', workers.workerLastName) as 'nombreMedico', "
				+ "doctors.area as 'especialidad' , "
				+ "medical_appointment.medical_appointment_date as fechaCita, "
				+ "medical_appointment.observations as observaciones "
				+ "from medical_appointment "
				+ "inner join user on user.userId = medical_appointment.user_userId "
				+ "inner join doctors on doctors.idDoctor = medical_appointment.doctors_idDoctor "
				+ "inner join workers on workers.idworkers = doctors.id_workers "
				+ "where medical_appointment.user_userId = ?1 ;")
		)

@NamedNativeQuery(
		name = "CitaMedica.listarCitasMedicasbyDoctorId",
		resultClass = CitaMedicDto.class,
		resultSetMapping = "listarCitasMedicasMapping",
		query = ("select medical_appointment.idmedical_appointment, "
				+ "concat(user.username, ' ', user.userLastName) as 'nombrePaciente', "
				+ "concat(workers.workerName, ' ', workers.workerLastName) as 'nombreMedico', "
				+ "doctors.area as 'especialidad' , "
				+ "medical_appointment.medical_appointment_date as fechaCita, "
				+ "medical_appointment.observations as observaciones "
				+ "from medical_appointment "
				+ "inner join user on user.userId = medical_appointment.user_userId "
				+ "inner join doctors on doctors.idDoctor = medical_appointment.doctors_idDoctor "
				+ "inner join workers on workers.idworkers = doctors.id_workers "
				+ "where medical_appointment.doctors_idDoctor = ?1 ;")
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
	
	@Column(name="observations", nullable = true)
	private String observations;
	
	@Column(name="medical_appointment_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date medical_appointment_date;
			
	public CitaMedica() {
		
	}
		
	public CitaMedica(int idmedical_appointment, int user_userId, int doctors_idDoctor, String observations,
			Date medical_appointment_date) {
		super();
		this.idmedical_appointment = idmedical_appointment;
		this.user_userId = user_userId;
		this.doctors_idDoctor = doctors_idDoctor;
		this.observations = observations;
		this.medical_appointment_date = medical_appointment_date;
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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Date getMedical_appointment_date() {
		return medical_appointment_date;
	}

	public void setMedical_appointment_date(Date medical_appointment_date) {
		this.medical_appointment_date = medical_appointment_date;
	}

	@Override
	public String toString() {
		return "CitaMedica [idmedical_appointment=" + idmedical_appointment + ", user_userId=" + user_userId
				+ ", doctors_idDoctor=" + doctors_idDoctor + ", observations=" + observations
				+ ", medical_appointment_date=" + medical_appointment_date + "]";
	}
	
}