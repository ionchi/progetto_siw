package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class ExamType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(length = 1000)
	private String description;

	@Column(nullable = false)
	private double cost;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="examtype_id")
	private List<Prerequisite> prerequisites;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="examtype_id")
	private List<Indicator> indicators;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Prerequisite> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Prerequisite> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}

	@Override
	public String toString() {
		return "TipologiaEsame [nome=" + name + ", cost=" + cost + "]";
	}
	
}
