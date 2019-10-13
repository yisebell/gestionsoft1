/**
 * 
 */
package persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la entidad User
 * 
 * @author james
 * @date 13/10/2019
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "TB_GS_USER")
@Access(AccessType.FIELD)
public class User implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SC_GS_USER", sequenceName = "SC_GS_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_GS_USER")
	@Column(name = "ID_USER")
	private long idUser;
	
	@Column(name = "ALIAS")
	private String alias;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ROL")
	private Rol rol;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Temporal(TemporalType.DATE) 
	@Column(name = "CREATED")
	private Date created;
	
	@Column(name = "ACTIVE")
	private char active;

	/**
	 * Método Constructor
	 */
	public User() {
		super();
	}

	/**
	 * Metodo que permite obtener la propiedad idUser.
	 * @return idUser propiedad idUser
	 */
	public long getIdUser() {
		return idUser;
	}

	/**
	 * Metodo que permite establecer la propiedad idUser.
	 * @param idUser propiedad idUser
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	/**
	 * Metodo que permite obtener la propiedad alias.
	 * @return alias propiedad alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Metodo que permite establecer la propiedad alias.
	 * @param alias propiedad alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Metodo que permite obtener la propiedad rol.
	 * @return rol propiedad rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * Metodo que permite establecer la propiedad rol.
	 * @param rol propiedad rol
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Metodo que permite obtener la propiedad email.
	 * @return email propiedad email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que permite establecer la propiedad email.
	 * @param email propiedad email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que permite obtener la propiedad password.
	 * @return password propiedad password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo que permite establecer la propiedad password.
	 * @param password propiedad password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Metodo que permite obtener la propiedad created.
	 * @return created propiedad created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Metodo que permite establecer la propiedad created.
	 * @param created propiedad created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Metodo que permite obtener la propiedad active.
	 * @return active propiedad active
	 */
	public char getActive() {
		return active;
	}

	/**
	 * Metodo que permite establecer la propiedad active.
	 * @param active propiedad active
	 */
	public void setActive(char active) {
		this.active = active;
	}

} // Fin class User
