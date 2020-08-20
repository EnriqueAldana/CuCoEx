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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class ImpExpType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4062101968932041790L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=25)
	private String ImpExpTypeName;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=254)
	private String ImpExpTypeDescription;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="impexptypes_causales"
		,joinColumns=@JoinColumn(name="impexptype_id")
		,inverseJoinColumns=@JoinColumn(name="causal_id"))
	private Set<ImpExpType> impExpType;
	
	
	/**
	 * @return the impExpType
	 */
	public Set<ImpExpType> getImpExpType() {
		return impExpType;
	}

	/**
	 * @param impExpType the impExpType to set
	 */
	public void setImpExpType(Set<ImpExpType> impExpType) {
		this.impExpType = impExpType;
	}

	/**
	 * 
	 */
	public ImpExpType() {
		
		
	}

	public ImpExpType(String impExpTypeName, String impExpTypeDescription) {
		super();
		ImpExpTypeName = impExpTypeName;
		ImpExpTypeDescription = impExpTypeDescription;
	}

	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the impExpTypeName
	 */
	public String getImpExpTypeName() {
		return ImpExpTypeName;
	}

	/**
	 * @param impExpTypeName the impExpTypeName to set
	 */
	public void setImpExpTypeName(String impExpTypeName) {
		ImpExpTypeName = impExpTypeName;
	}

	/**
	 * @return the impExpTypeDescription
	 */
	public String getImpExpTypeDescription() {
		return ImpExpTypeDescription;
	}

	/**
	 * @param impExpTypeDescription the impExpTypeDescription to set
	 */
	public void setImpExpTypeDescription(String impExpTypeDescription) {
		ImpExpTypeDescription = impExpTypeDescription;
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
	public void setUpdated(Date updated) {
		updated = updated;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ImpExpTypeDescription == null) ? 0 : ImpExpTypeDescription.hashCode());
		result = prime * result + ((ImpExpTypeName == null) ? 0 : ImpExpTypeName.hashCode());
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
		ImpExpType other = (ImpExpType) obj;
		if (ImpExpTypeDescription == null) {
			if (other.ImpExpTypeDescription != null)
				return false;
		} else if (!ImpExpTypeDescription.equals(other.ImpExpTypeDescription))
			return false;
		if (ImpExpTypeName == null) {
			if (other.ImpExpTypeName != null)
				return false;
		} else if (!ImpExpTypeName.equals(other.ImpExpTypeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImpExpType [id=" + id + ", ImpExpTypeName=" + ImpExpTypeName + ", ImpExpTypeDescription="
				+ ImpExpTypeDescription + "]";
	}

	
	
}
