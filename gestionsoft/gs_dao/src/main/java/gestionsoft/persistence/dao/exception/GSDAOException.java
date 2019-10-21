package gestionsoft.persistence.dao.exception;

/**
 * Clase que representa el tipo de excepcion que propaga la capa DAO y que extiende
 * de la excepcion padre.
 * 
 * @author ljhidalgo
 * @date 17/10/2019
 * @version 1.0
 * @see
 */
public final class GSDAOException extends Exception {

	// Serial.
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param exception excepcion encapsulada.
	 */
	public GSDAOException(final Exception exception) {
		super(exception);
	}
	
}  // Fin class GSDAOException.
