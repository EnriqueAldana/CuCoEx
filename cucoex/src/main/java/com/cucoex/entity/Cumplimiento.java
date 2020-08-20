/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author enrique
 *
 */
@Entity
public class Cumplimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3274594582844769993L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	
	
	// El estatus puede cambiar Por: La fecha actual es mayor a la fecha de vigencia para cumplimiento. El usuario determina que no se cumple.
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String statusKey;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String statusName;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String statusDescription;
	
	@Column(nullable = false)
	private Date effectiveDateForCompliance;          // Fecha de Vigencia para cumplimiento
	
	@Column(nullable = false)
	private Date complianceEvaluationDate;				//Fecha en que fue ejecutado el monitor para validar el cumplimiento
			
	

	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	
	@OneToOne
	  @JoinColumn(name="id")
	  private Causal causal;
	

	
	
	/**
	 * @return the statusKey
	 */
	public String getStatusKey() {
		return statusKey;
	}

	/**
	 * @param statusKey the statusKey to set
	 */
	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 * @return the effectiveDateForCompliance
	 */
	public Date getEffectiveDateForCompliance() {
		return effectiveDateForCompliance;
	}

	/**
	 * @param effectiveDateForCompliance the effectiveDateForCompliance to set
	 */
	public void setEffectiveDateForCompliance(Date effectiveDateForCompliance) {
		this.effectiveDateForCompliance = effectiveDateForCompliance;
	}

	/**
	 * @return the complianceEvaluationDate
	 */
	public Date getComplianceEvaluationDate() {
		return complianceEvaluationDate;
	}

	/**
	 * @param complianceEvaluationDate the complianceEvaluationDate to set
	 */
	public void setComplianceEvaluationDate(Date complianceEvaluationDate) {
		this.complianceEvaluationDate = complianceEvaluationDate;
	}

	/**
	 * @return the created
	 */
	public Calendar getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Calendar created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public Calendar getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	/**
	 * @return the causal
	 */
	public Causal getCausal() {
		return causal;
	}

	/**
	 * @param causal the causal to set
	 */
	public void setCausal(Causal causal) {
		this.causal = causal;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 */
	public Cumplimiento() {
		
	}

	/**
	 * @param statusKey
	 * @param statusName
	 * @param statusDescription
	 * @param effectiveDateForCompliance
	 * @param complianceEvaluationDate
	 * @param updated
	 * @param created
	 */
	public Cumplimiento(@NotEmpty @Size(min = 1, max = 10) String statusKey,
			@NotEmpty @Size(min = 1, max = 10) String statusName,
			@NotEmpty @Size(min = 1, max = 10) String statusDescription, Date effectiveDateForCompliance,
			Date complianceEvaluationDate, Calendar updated, Calendar created) {
		super();
		this.statusKey = statusKey;
		this.statusName = statusName;
		this.statusDescription = statusDescription;
		this.effectiveDateForCompliance = effectiveDateForCompliance;
		this.complianceEvaluationDate = complianceEvaluationDate;
		this.updated = updated;
		this.created = created;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complianceEvaluationDate == null) ? 0 : complianceEvaluationDate.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((effectiveDateForCompliance == null) ? 0 : effectiveDateForCompliance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusDescription == null) ? 0 : statusDescription.hashCode());
		result = prime * result + ((statusKey == null) ? 0 : statusKey.hashCode());
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
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
		Cumplimiento other = (Cumplimiento) obj;
		if (complianceEvaluationDate == null) {
			if (other.complianceEvaluationDate != null)
				return false;
		} else if (!complianceEvaluationDate.equals(other.complianceEvaluationDate))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (effectiveDateForCompliance == null) {
			if (other.effectiveDateForCompliance != null)
				return false;
		} else if (!effectiveDateForCompliance.equals(other.effectiveDateForCompliance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statusDescription == null) {
			if (other.statusDescription != null)
				return false;
		} else if (!statusDescription.equals(other.statusDescription))
			return false;
		if (statusKey == null) {
			if (other.statusKey != null)
				return false;
		} else if (!statusKey.equals(other.statusKey))
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cumplimiento [id=" + id + ", statusKey=" + statusKey + ", statusName=" + statusName
				+ ", statusDescription=" + statusDescription + ", effectiveDateForCompliance="
				+ effectiveDateForCompliance + ", complianceEvaluationDate=" + complianceEvaluationDate + ", updated="
				+ updated + ", created=" + created + "]";
	}
	
	

}
