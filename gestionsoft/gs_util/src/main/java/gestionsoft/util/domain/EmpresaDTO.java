package gestionsoft.util.domain;

/**
 * DTO de la empresa
 * 
 * @author james
 * @date 14/10/2019
 * @version 1.0
 * @see
 */
public class EmpresaDTO extends AbstractGenericDTO implements Comparable<EmpresaDTO>{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	private long idEmpresa;
	
	private String nit;
	
	private String razonSocial;
	
	private String sigla;
	
	private String prefijo;
	
	private String direccion;
	
	private String departamento;
	
	private String ciudad;
	
	private String telefono;
	
	private String logo;
	
	private String mision;
	
	private String vision;
	
	private String valores;
	
	private String slogan;

	/**
	 * Constructor de la clase  
	 */
	public EmpresaDTO() {
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

	@Override
	public int compareTo(EmpresaDTO arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

} // fin class Empresa
