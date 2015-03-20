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

@Table(name="TEENAGER_ADVICE",schema="IGREJA_DB")
@Entity
public class TeenagerAdvice extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="teenager_adv_sq", sequenceName="teenager_adv_sequence", allocationSize=1 )
	@GeneratedValue(generator="teenager_adv_sq", strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="TEEN_ADV_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="TEEN_ID", referencedColumnName="TEEN_ID")
	private Teenager teenager;
	
	@ManyToOne
	@JoinColumn(name="CONSEULOR_ID", referencedColumnName="CONSEULOR_ID")
	private Conseulor conseulor;

	@ManyToOne
	@JoinColumn(name="ADV_STATUS_ID", referencedColumnName="ADV_STATUS_ID")
	private AdviceStatus adviceStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DT")
	private Date creationDate;
	
	@Column(name="ADVICE", length=2000)
	private String advice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Teenager getTeenager() {
		return teenager;
	}

	public void setTeenager(Teenager teenager) {
		this.teenager = teenager;
	}

	public Conseulor getConseulor() {
		return conseulor;
	}

	public void setConseulor(Conseulor conseulor) {
		this.conseulor = conseulor;
	}

	public AdviceStatus getAdviceStatus() {
		return adviceStatus;
	}

	public void setAdviceStatus(AdviceStatus adviceStatus) {
		this.adviceStatus = adviceStatus;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}





	
}