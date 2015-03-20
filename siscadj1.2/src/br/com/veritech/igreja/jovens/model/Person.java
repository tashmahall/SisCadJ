package br.com.veritech.igreja.jovens.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Table(name="PERSON",schema="IGREJA_DB")
@Entity
public class Person extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PERSON_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	@Column(name="MOTHER_NAME")
	private String motherName;
	@Column(name="FATHER_NAME")
	private String fatherName;
	@Temporal(TemporalType.DATE)
	@Column(name="CONVERSION_DATE")
	private Date conversionDate;
	@Column(name="BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Column(name="STAR_BETANINHA_DT")
	@Temporal(TemporalType.DATE)
	private Date startBetaninhaDate;
	@Column(name="EXIT_BETANINHA_DT")
	@Temporal(TemporalType.DATE)
	private Date exitBetaninhaDate;
	@Column(name="BAPTIZED")
	private Boolean baptized;
	@Column(name="DIVORCED_PARENTS")
	private Boolean divorcedParents;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getConversionDate() {
		return conversionDate;
	}

	public void setConversionDate(Date conversionDate) {
		this.conversionDate = conversionDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getStartBetaninhaDate() {
		return startBetaninhaDate;
	}

	public void setStartBetaninhaDate(Date startBetaninhaDate) {
		this.startBetaninhaDate = startBetaninhaDate;
	}

	public Date getExitBetaninhaDate() {
		return exitBetaninhaDate;
	}

	public void setExitBetaninhaDate(Date exitBetaninhaDate) {
		this.exitBetaninhaDate = exitBetaninhaDate;
	}

	public Boolean getBaptized() {
		return baptized;
	}

	public void setBaptized(Boolean baptized) {
		this.baptized = baptized;
	}

	public Boolean getDivorcedParents() {
		return divorcedParents;
	}

	public void setDivorcedParents(Boolean divorcedParents) {
		this.divorcedParents = divorcedParents;
	}

}
