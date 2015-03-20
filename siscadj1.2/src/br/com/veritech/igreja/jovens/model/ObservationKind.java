package br.com.veritech.igreja.jovens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="OBSERVATION_KIND", schema="IGREJA_DB")
@Entity
public class ObservationKind  extends BaseEntity<Long> implements IBaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="OBS_KIND_ID")
	@SequenceGenerator(name="obs_kind_sq", sequenceName="obs_kind_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "obs_kind_sq")
	private Long id;
	
	@Column(name="OBS_KIND_COD", length=3, nullable=false)
	private String code;
	
	@Column(name="OBS_KIND_COD", length=70, nullable=false)
	private String description;
	
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

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
