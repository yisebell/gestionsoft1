package gestionsoft.persistence.entity;

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
 * @author james
 * @date 14/10/2019
 * @version 1.0
 * @see
 */
@Entity
@Table(name = "TB_GS_EMPRESA")
@Access(AccessType.FIELD)
public class Empresa implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SC_GS_EMPRESA", sequenceName = "SC_GS_EMPRESA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SC_GS_EMPRESA")
	@Column(name = "ID_EMPRESA")	
	private long idEmpresa;
	
	@Column(name = "NIT")
	private String nit;
	
	@Column(name = "RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name = "SIGLA")
	private String sigla;
	
	@Column(name = "PREFIJO")
	private String prefijo;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "DEPARTAMENTO")
	private String departamento;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "LOGO")
	private String logo;
	
	@Column(name = "MISION")
	private String mision;
	
	@Column(name = "VISION")
	private String vision;
	
	@Column(name = "VALORES")
	private String valores;
	
	@Column(name = "SLOGAN")
	private String slogan;

	/**
	 * Constructor de la clase  
	 */
	public Empresa() {
		super();
	}

	/**
	 * @return the idEmpresa
	 */
	public long getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the nit
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * @param nit the nit to set
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * @return the prefijo
	 */
	public String getPrefijo() {
		return prefijo;
	}

	/**
	 * @param prefijo the prefijo to set
	 */
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the mision
	 */
	public String getMision() {
		return mision;
	}

	/**
	 * @param mision the mision to set
	 */
	public void setMision(String mision) {
		this.mision = mision;
	}

	/**
	 * @return the vision
	 */
	public String getVision() {
		return vision;
	}

	/**
	 * @param vision the vision to set
	 */
	public void setVision(String vision) {
		this.vision = vision;
	}

	/**
	 * @return the valores
	 */
	public String getValores() {
		return valores;
	}

	/**
	 * @param valores the valores to set
	 */
	public void setValores(String valores) {
		this.valores = valores;
	}

	/**
	 * @return the slogan
	 */
	public String getSlogan() {
		return slogan;
	}

	/**
	 * @param slogan the slogan to set
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

} // fin class Empresa
