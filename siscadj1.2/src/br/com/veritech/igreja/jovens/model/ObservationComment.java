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

@Table(name="OBS_COMMENT", schema="IGREJA_DB")
@Entity
public class ObservationComment extends BaseEntity<Long> implements IBaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="obs_comment_sq", sequenceName="obs_comment_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "obs_comment_sq")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="COMMENT_DATE_CREATION",nullable=false)
	private Date DateComment;
	
	@Column(name="COMMENT_DESC", nullable=false)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="OBSERVATION_ID", referencedColumnName="OBSERVATION_ID", nullable=false)
	private Observation observation;
	
	@ManyToOne
	@JoinColumn(name="CONSEULOR_ID", referencedColumnName="CONSEULOR_ID", nullable=false)
	private Conseulor conseulor;
	
	
	public Date getDateComment() {
		return DateComment;
	}

	public void setDateComment(Date dateComment) {
		DateComment = dateComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Observation getObservation() {
		return observation;
	}

	public void setObservation(Observation observation) {
		this.observation = observation;
	}

	public Conseulor getConseulor() {
		return conseulor;
	}

	public void setConseulor(Conseulor conseulor) {
		this.conseulor = conseulor;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

}
