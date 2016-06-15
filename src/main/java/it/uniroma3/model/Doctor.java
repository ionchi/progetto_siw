package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String specialization;
	
	@OneToMany(mappedBy="doctor")
	private List<Exam> examsDone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Exam> getExamsDone() {
		return examsDone;
	}

	public void setExamsDone(List<Exam> examsDone) {
		this.examsDone = examsDone;
	}

	@Override
	public String toString() {
		return "Medico [nome=" + firstName + ", cognome=" + lastName + ", specializzazione=" + specialization + "]";
	}
}
