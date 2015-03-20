package br.com.veritech.igreja.jovens.model.compositekey;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import br.com.veritech.igreja.jovens.model.Person;

@Embeddable
public class PhotoEventPersonPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="PHOTO_EVENT_ID", referencedColumnName="PHOTO_EVENT_ID", nullable=false)
	private Long photoEventId;
	
	@JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID", nullable=false)
	private Person personId;

	public Long getPhotoEventId() {
		return photoEventId;
	}

	public void setPhotoEventId(Long photoEventId) {
		this.photoEventId = photoEventId;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((personId == null) ? 0 : personId.hashCode());
		result = prime * result
				+ ((photoEventId == null) ? 0 : photoEventId.hashCode());
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
		PhotoEventPersonPK other = (PhotoEventPersonPK) obj;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (photoEventId == null) {
			if (other.photoEventId != null)
				return false;
		} else if (!photoEventId.equals(other.photoEventId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return photoEventId.toString()+ personId.toString() ;
	}



}
