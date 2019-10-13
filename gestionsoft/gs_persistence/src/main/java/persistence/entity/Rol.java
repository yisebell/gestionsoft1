/**
 * Paquete ubicación
 */
package persistence.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Rol
 * 
 * @author james
 * @date 13/10/2019
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "TB_GS_ROL")
@Access(AccessType.FIELD)
public class Rol implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SC_GS_ROL", sequenceName = "SC_GS_ROL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_GS_ROL")
	@Column(name = "ID_ROL")
	private long idRol;
	
	@Column(name = "ROL")
	private String nameRol;
	
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * Método Constructor
	 */
	public Rol() {
		super();
	}
	
	/**
	 * @return the idRol
	 */
	public long getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the rol
	 */
	public String getNameRol() {
		return nameRol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setNameRol(String nameRol) {
		this.nameRol = nameRol;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
} // Fin class Rol