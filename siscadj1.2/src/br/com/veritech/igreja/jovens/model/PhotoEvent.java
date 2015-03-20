package br.com.veritech.igreja.jovens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="PHOTO_EVENT",schema="IGREJA_DB")
@Entity
public class PhotoEvent extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PHOTO_EVENT_ID")
	@SequenceGenerator(name="photo_event_sq", sequenceName="photo_event_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "photo_event_sq")
	private Long id;
	
	@Column(name="PHOTO", nullable=false)
	@Lob
	private byte[] photo;
	
	@Column(name="PHOTO",length=500)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="EVENT_ID", referencedColumnName="EVENT_ID", nullable=false)
	private Event event;

	@Override
	public Long getId() {
		return this.id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
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
	


}
