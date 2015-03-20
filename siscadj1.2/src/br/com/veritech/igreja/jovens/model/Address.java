package br.com.veritech.igreja.jovens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ADDRESS",schema="IGREJA_DB")
@Entity
public class Address extends BaseEntity<Long> implements IBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="address_sq", sequenceName="address_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "address_sq")
	@Column(name="ID")
	private Long id;
	
	@Column(name="STREET", length=255, nullable=false)
	private String street;
	
	@Column(name="COMPLEMENT", length=255, nullable=true)
	private String complement;
	
	@Column(name="CEP", length=8, nullable=true)
	private String cep;
	
	@Column(name="DISTRICT", length=255, nullable=true)
	private String district;
	
	@Column(name="CITY", length=255, nullable=true)
	private String city;
	
	@Column(name="STATE", length=255, nullable=true)
	private String state;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID", nullable=false)
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
