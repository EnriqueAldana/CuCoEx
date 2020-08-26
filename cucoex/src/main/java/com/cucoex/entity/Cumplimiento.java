/**
 * 
 */
package com.cucoex.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="id") private Causal causal;
	 */
	
	// El estatus puede cambiar Por: La fecha actual es mayor a la fecha de vigencia para cumplimiento. El usuario determina que no se cumple.

	

	@ManyToOne
    @JoinColumn(name="statusId")
	private Status status;
	
	
	

	/**
	 * @param id
	 * @param effectiveDateForCompliance
	 * @param complianceEvaluationDate
	 * @param created
	 * @param updated
	 * @param causal
	 * @param status
	 */
	public Cumplimiento(Long id, Date effectiveDateForCompliance, Date complianceEvaluationDate, Calendar created,
			Calendar updated, Causal causal, Status status) {
		super();
		this.id = id;
		this.effectiveDateForCompliance = effectiveDateForCompliance;
		this.complianceEvaluationDate = complianceEvaluationDate;
		this.created = created;
		this.updated = updated;
		//this.causal = causal;
		this.status = status;
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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complianceEvaluationDate == null) ? 0 : complianceEvaluationDate.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((effectiveDateForCompliance == null) ? 0 : effectiveDateForCompliance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "Cumplimiento [id=" + id + ", effectiveDateForCompliance=" + effectiveDateForCompliance
				+ ", complianceEvaluationDate=" + complianceEvaluationDate + ", created=" + created + ", updated="
				+ updated + ", status=" + status + "]";
	}

	
	
	

	

}
