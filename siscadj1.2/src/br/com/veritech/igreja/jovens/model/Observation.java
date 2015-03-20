package br.com.veritech.igreja.jovens.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="OBSERVATION", schema="IGREJA_DB")
@Entity
public class Observation extends BaseEntity<Long> implements IBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="OBSERVATION_ID")
	@SequenceGenerator(name="observation_sq", sequenceName="observation_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "observation_sq")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="OBS_DATE_CREATION",nullable=false)
	private Date observationDateCreation;
	
	@Column(name="OBSERVATION", length=1000, nullable=false)
	private String observation;
	
	@ManyToOne
	@JoinColumn(name="OBS_KIND_ID",referencedColumnName="OBS_KIND_ID", nullable=false)
	private ObservationKind observationKind;
	
	@ManyToOne
	@JoinColumn(name="OBS_STATUS_ID",referencedColumnName="OBS_STATUS_ID", nullable=false)
	private ObservationStatus obserbationStatus;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID",referencedColumnName="PERSON_ID", nullable=false)
	private Person observedPerson;
	
	@ManyToOne
	@JoinColumn(name="CONSEULOR_ID",referencedColumnName="CONSEULOR_ID", nullable=false)
	private Conseulor conseulor;
	
	//Aparently the @Fetch Annotation where we can use the subselect was substituted by the @OneToMany Annotation bellow 
	@OneToMany(fetch=FetchType.LAZY,mappedBy="observation",targetEntity=ObservationComment.class)
	private List<ObservationComment> listComment;

	public Date getObservationDateCreation() {
		return observationDateCreation;
	}

	public void setObservationDateCreation(Date observationDateCreation) {
		this.observationDateCreation = observationDateCreation;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public ObservationKind getObservationKind() {
		return observationKind;
	}

	public void setObservationKind(ObservationKind observationKind) {
		this.observationKind = observationKind;
	}

	public ObservationStatus getObserbationStatus() {
		return obserbationStatus;
	}

	public void setObserbationStatus(ObservationStatus obserbationStatus) {
		this.obserbationStatus = obserbationStatus;
	}

	public Person getObservedPerson() {
		return observedPerson;
	}

	public void setObservedPerson(Person observedPerson) {
		this.observedPerson = observedPerson;
	}

	public Conseulor getConseulor() {
		return conseulor;
	}

	public void setConseulor(Conseulor conseulor) {
		this.conseulor = conseulor;
	}

	public List<ObservationComment> getListComment() {
		return listComment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
