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

@Table(name="TEENAGER_ADVICE_COMMENT",schema="IGREJA_DB")
@Entity
public class TeenagerAdviceComment extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="teen_adv_comm_sq", sequenceName="teen_adv_comm_sequence", allocationSize=1 )
	@GeneratedValue(generator="teen_adv_comm_sq", strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="TEEN_ADV_COMM_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CONSEULOR_ID", referencedColumnName="CONSEULOR_ID")
	private Conseulor conseulor;

	@ManyToOne
	@JoinColumn(name="TEEN_ADV_ID", referencedColumnName="TEEN_ADV_ID")
	private TeenagerAdvice teenagerAdvice;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DT")
	private Date creationDate;
	
	@Column(name="COMMENT", length=2000)
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Conseulor getConseulor() {
		return conseulor;
	}

	public void setConseulor(Conseulor conseulor) {
		this.conseulor = conseulor;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public TeenagerAdvice getTeenagerAdvice() {
		return teenagerAdvice;
	}

	public void setTeenagerAdvice(TeenagerAdvice teenagerAdvice) {
		this.teenagerAdvice = teenagerAdvice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}