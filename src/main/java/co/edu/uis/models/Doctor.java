package co.edu.uis.models;

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

import co.edu.uis.dto.DoctorDto;

@SqlResultSetMapping(
		name= "listarMedicosMapping",
		classes = {
				@ConstructorResult(targetClass = DoctorDto.class,
					columns = {
							@ColumnResult(name = "idDoctor", type = String.class),
							@ColumnResult(name = "nombreMedico", type = String.class),
							@ColumnResult(name = "especialidad", type = String.class),
					}
				)
			}
		)

@NamedNativeQuery(
		name = "Doctor.listarMedicos",
		resultClass = DoctorDto.class,
		resultSetMapping = "listarMedicosMapping",
		query = ("select idDoctor, "
				+ "concat(workers.workerName, ' ', workers.workerLastName) as 'nombreMedico', "
				+ "doctors.area as 'especialidad' "
				+ "from doctors "
				+ "inner join workers on workers.idworkers = doctors.id_workers; ")
		)

@NamedNativeQuery(
		name = "Doctor.listarMedicosById",
		resultClass = DoctorDto.class,
		resultSetMapping = "listarMedicosMapping",
		query = ("select idDoctor, "
				+ "concat(workers.workerName, ' ', workers.workerLastName) as 'nombreMedico', "
				+ "doctors.area as 'especialidad' "
				+ "from doctors "
				+ "inner join workers on workers.idworkers = doctors.id_workers "
				+ "where idDoctor = ?1 ;")
		)


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
