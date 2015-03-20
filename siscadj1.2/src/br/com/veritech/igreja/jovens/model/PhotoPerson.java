package br.com.veritech.igreja.jovens.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="PHOTO_PERSON",schema="IGREJA_DB")
@Entity
public class PhotoPerson extends BaseEntity<Long> implements IBaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PHOTO_PERSON_ID")
	@SequenceGenerator(name="photo_person_sq", sequenceName="photo_person_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "photo_person_sq")
	private Long id;
	
	@ManyToOne
	@Column(name="PERSON_ID", nullable=false, insertable=true)
	@JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID", nullable=false )
	private Person person;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PHOTO_DT", nullable=false)
	private Date photoDate;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getPhotoDate() {
		return photoDate;
	}

	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
	}
	
	
}
