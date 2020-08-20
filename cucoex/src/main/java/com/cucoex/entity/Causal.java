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
public class Causal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492504495415651138L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=254)
	private String causalDescription;
	
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=10)
	private String causalFraction;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=6)
	private String causalOsCe;
	
	@Column(nullable=false)
	@NotEmpty
	private Long CausalClasification;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=6)
	private String causalExclusiva;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=1, max=254)
	private String causalCumplimiento;
	
	
	@Column(nullable=false)
	@NotEmpty
	private Long causalType;   // El tipo sera una agrupacion para determinar el comportamiento de la interfaz de usuario para fijar el cumplimiento
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;
	
	@Column(nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updated;
	
	

	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="causales_instructions"
		,joinColumns=@JoinColumn(name="causal_id")
		,inverseJoinColumns=@JoinColumn(name="instruction_id"))
	private Set<Instruction> instruction;
	
	
	@OneToOne(mappedBy="causal")
	private Cumplimiento cumplimiento;
	
	/**
	 * 
	 */
	public Causal() {
		
	}


	/**
	 * @param causalDescription
	 * @param causalFraction
	 * @param causalOsCe
	 * @param causalClasification
	 * @param causalExclusiva
	 * @param causalCumplimiento
	 * @param causalType
	 */
	public Causal(@NotEmpty @Size(min = 1, max = 254) String causalDescription,
			@NotEmpty @Size(min = 1, max = 10) String causalFraction,
			@NotEmpty @Size(min = 1, max = 6) String causalOsCe, @NotEmpty Long causalClasification,
			@NotEmpty @Size(min = 1, max = 6) String causalExclusiva,
			@NotEmpty @Size(min = 1, max = 254) String causalCumplimiento, @NotEmpty Long causalType) {
		super();
		this.causalDescription = causalDescription;
		this.causalFraction = causalFraction;
		this.causalOsCe = causalOsCe;
		CausalClasification = causalClasification;
		this.causalExclusiva = causalExclusiva;
		this.causalCumplimiento = causalCumplimiento;
		this.causalType = causalType;
	}


	/**
	 * @return the causalDescription
	 */
	public String getCausalDescription() {
		return causalDescription;
	}


	/**
	 * @param causalDescription the causalDescription to set
	 */
	public void setCausalDescription(String causalDescription) {
		this.causalDescription = causalDescription;
	}


	/**
	 * @return the causalFraction
	 */
	public String getCausalFraction() {
		return causalFraction;
	}


	/**
	 * @param causalFraction the causalFraction to set
	 */
	public void setCausalFraction(String causalFraction) {
		this.causalFraction = causalFraction;
	}


	/**
	 * @return the causalOsCe
	 */
	public String getCausalOsCe() {
		return causalOsCe;
	}


	/**
	 * @param causalOsCe the causalOsCe to set
	 */
	public void setCausalOsCe(String causalOsCe) {
		this.causalOsCe = causalOsCe;
	}


	/**
	 * @return the causalClasification
	 */
	public Long getCausalClasification() {
		return CausalClasification;
	}


	/**
	 * @param causalClasification the causalClasification to set
	 */
	public void setCausalClasification(Long causalClasification) {
		CausalClasification = causalClasification;
	}


	/**
	 * @return the causalExclusiva
	 */
	public String getCausalExclusiva() {
		return causalExclusiva;
	}


	/**
	 * @param causalExclusiva the causalExclusiva to set
	 */
	public void setCausalExclusiva(String causalExclusiva) {
		this.causalExclusiva = causalExclusiva;
	}


	/**
	 * @return the causalCumplimiento
	 */
	public String getCausalCumplimiento() {
		return causalCumplimiento;
	}


	/**
	 * @param causalCumplimiento the causalCumplimiento to set
	 */
	public void setCausalCumplimiento(String causalCumplimiento) {
		this.causalCumplimiento = causalCumplimiento;
	}


	/**
	 * @return the causalType
	 */
	public Long getCausalType() {
		return causalType;
	}


	/**
	 * @param causalType the causalType to set
	 */
	public void setCausalType(Long causalType) {
		this.causalType = causalType;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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


	/**
	 * @return the instruction
	 */
	public Set<Instruction> getInstruction() {
		return instruction;
	}


	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(Set<Instruction> instruction) {
		this.instruction = instruction;
	}


	/**
	 * @return the cumplimiento
	 */
	public Cumplimiento getCumplimiento() {
		return cumplimiento;
	}


	/**
	 * @param cumplimiento the cumplimiento to set
	 */
	public void setCumplimiento(Cumplimiento cumplimiento) {
		this.cumplimiento = cumplimiento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CausalClasification == null) ? 0 : CausalClasification.hashCode());
		result = prime * result + ((causalCumplimiento == null) ? 0 : causalCumplimiento.hashCode());
		result = prime * result + ((causalDescription == null) ? 0 : causalDescription.hashCode());
		result = prime * result + ((causalExclusiva == null) ? 0 : causalExclusiva.hashCode());
		result = prime * result + ((causalFraction == null) ? 0 : causalFraction.hashCode());
		result = prime * result + ((causalOsCe == null) ? 0 : causalOsCe.hashCode());
		result = prime * result + ((causalType == null) ? 0 : causalType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Causal other = (Causal) obj;
		if (CausalClasification == null) {
			if (other.CausalClasification != null)
				return false;
		} else if (!CausalClasification.equals(other.CausalClasification))
			return false;
		if (causalCumplimiento == null) {
			if (other.causalCumplimiento != null)
				return false;
		} else if (!causalCumplimiento.equals(other.causalCumplimiento))
			return false;
		if (causalDescription == null) {
			if (other.causalDescription != null)
				return false;
		} else if (!causalDescription.equals(other.causalDescription))
			return false;
		if (causalExclusiva == null) {
			if (other.causalExclusiva != null)
				return false;
		} else if (!causalExclusiva.equals(other.causalExclusiva))
			return false;
		if (causalFraction == null) {
			if (other.causalFraction != null)
				return false;
		} else if (!causalFraction.equals(other.causalFraction))
			return false;
		if (causalOsCe == null) {
			if (other.causalOsCe != null)
				return false;
		} else if (!causalOsCe.equals(other.causalOsCe))
			return false;
		if (causalType == null) {
			if (other.causalType != null)
				return false;
		} else if (!causalType.equals(other.causalType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Causal [id=" + id + ", causalDescription=" + causalDescription + ", causalFraction=" + causalFraction
				+ ", causalOsCe=" + causalOsCe + ", CausalClasification=" + CausalClasification + ", causalExclusiva="
				+ causalExclusiva + ", causalCumplimiento=" + causalCumplimiento + ", causalType=" + causalType + "]";
	}
	
	

}
