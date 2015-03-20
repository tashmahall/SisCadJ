package br.com.veritech.igreja.jovens.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="EVENT",schema="IGREJA_DB")
@Entity
public class Event extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="EVENT_ID")
	@SequenceGenerator(name="event_sq", sequenceName="event_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "event_sq")
	private Long id;
	
	@Column(name="EVENT_DT")
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	
	@Column(name="EVENT_NAME", nullable=false, length=100)
	private String eventName;
	
	@Column(name="LOCATION_EVENT", length=250)
	private String eventLocation;
	
	@Column(name="LOCATION_EVENT", length=150)
	private String eventTheme;
	
	@Column(name="OBSERVATION", length=1000)
	private String observation;
	
	@ManyToMany
	@JoinTable(name="PERSON_EVENT", joinColumns={@JoinColumn(name="EVENT_ID")}, inverseJoinColumns={@JoinColumn(name="PERSON_ID")})
	private List<Person> personsEvent;
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventTheme() {
		return eventTheme;
	}
	public void setEventTheme(String eventTheme) {
		this.eventTheme = eventTheme;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public List<Person> getPersonsEvent() {
		return personsEvent;
	}
	public void setPersonsEvent(List<Person> personsEvent) {
		this.personsEvent = personsEvent;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	


}
