package br.com.veritech.igreja.jovens.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="CONSEULOR",schema="IGREJA_DB")
@Entity
public class Conseulor extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="conseulor_sq", sequenceName="conseulor_sequence", allocationSize=1 )
	@GeneratedValue(generator="conseulor_sq", strategy=GenerationType.SEQUENCE)
	@Column(name="CONSEULOR_ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID")
	private Person person;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ENTRANCE_DT")
	private Date entranceDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXIT_DT")
	private Date exitDate;
	
	@Column(name="ACTIVITY",length=50)
	private String activity;
	
	@Column(name="OBSERVATION", length=500)
	private String observation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}



}