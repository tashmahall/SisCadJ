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

@Table(name="YOUTH_ADVICE_COMMENT",schema="IGREJA_DB")
@Entity
public class YouthAdviceComment extends BaseEntity<Long> implements IBaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="youth_adv_comm_sq", sequenceName="youth_adv_comm_sequence", allocationSize=1 )
	@GeneratedValue(generator="youth_adv_comm_sq", strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="YOUTH_ADV_COMM_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CONSEULOR_ID", referencedColumnName="CONSEULOR_ID")
	private Conseulor conseulor;

	@ManyToOne
	@JoinColumn(name="YOUTH_ADV_ID", referencedColumnName="YOUTH_ADV_ID")
	private YouthAdvice youthAdvice;
	
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


	public YouthAdvice getYouthAdvice() {
		return youthAdvice;
	}

	public void setYouthAdvice(YouthAdvice youthAdvice) {
		this.youthAdvice = youthAdvice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}