package br.com.veritech.igreja.jovens.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.veritech.igreja.jovens.model.compositekey.PhotoEventPersonPK;

@Table(name="PHOTO_EVENT_PERSON",schema="IGREJA_DB")
@Entity
public class PhotoEventPerson extends BaseEntity<PhotoEventPersonPK> implements IBaseEntity<PhotoEventPersonPK> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PhotoEventPersonPK id;
	
	@Column(name="PHOTO",nullable=false)
	private byte[] photo;
	
	@Column(name="PHOTO",length=500)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="EVENT_ID", referencedColumnName="EVENT_ID", nullable=false)
	private Event event;

	@ManyToOne
	@JoinColumn(name="PHOTO_EVENT_ID", referencedColumnName="PHOTO_EVENT_ID", nullable=false, insertable=false)
	private PhotoEvent photoEvent;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID", nullable=false, insertable=false)
	private Person person;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@Override
	public PhotoEventPersonPK getId() {
		return this.id;
	}
	@Override
	public void setId(PhotoEventPersonPK id) {
		this.id = id;
	}
	public PhotoEvent getPhotoEvent() {
		return photoEvent;
	}
	public void setPhotoEvent(PhotoEvent photoEvent) {
		this.photoEvent = photoEvent;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
