package util.domain;

import java.io.Serializable;

/**
 * Clase que representa a una entidad de dominio de la aplicación.
 * 
 * @author james
 * @date 13/10/2019
 * @version 1.0
 * @see
 */
public abstract class AbstractGenericDTO implements Serializable, Cloneable {
	
	// Serial.
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public AbstractGenericDTO() {
		 super();
	}

}  // Fin GenericDTO.
