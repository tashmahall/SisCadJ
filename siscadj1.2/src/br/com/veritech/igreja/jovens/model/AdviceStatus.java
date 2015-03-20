package br.com.veritech.igreja.jovens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ADVICE_STATUS", schema="IGREJA_DB")
@Entity
public class AdviceStatus  extends BaseEntity<Long> implements IBaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ADV_STATUS_ID")
	@SequenceGenerator(name="adv_status_sq", sequenceName="adv_status_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "adv_status_sq")	
	private Long id;

	@Column(name="ADV_STATUS_COD", length=3, nullable=false, unique=true  )
	private String code;
	
	@Column(name="ADV_STATUS_DESC", length=50, nullable=false )
	private String description;
	
	@Column(name="ADV_STATUS_ENABLE", nullable=false )
	private Boolean enable;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
