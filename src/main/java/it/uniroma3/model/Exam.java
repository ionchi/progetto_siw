package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private ExamType type;

	@ManyToOne
	private Patient patient;

	@ManyToOne
	private Doctor doctor;

	@Temporal (TemporalType.DATE)
	private Date examDate;

	@Temporal (TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="examtype_id")
	private List<Result> results;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExamType getType() {
		return type;
	}

	public void setType(ExamType type) {
		this.type = type;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((examDate == null) ? 0 : examDate.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (examDate == null) {
			if (other.examDate != null)
				return false;
		} else if (!examDate.equals(other.examDate))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esame [tipologia=" + type + ", paziente=" + patient + ", medico=" + doctor + ", dataEsame="
				+ examDate + ", dataCreazione=" + creationDate + "]";
	}
}
