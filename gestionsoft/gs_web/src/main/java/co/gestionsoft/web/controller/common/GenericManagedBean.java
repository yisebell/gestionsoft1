package co.gestionsoft.web.controller.common;

import java.io.Serializable;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Clase que representa el controlador generico faces 
 * y que sera extendido por aquellos 
 * managed beans que requieran tener un scope de tipo vista o session.
 * 
 * @author james
 * @date 27/10/2019
 * @version 1.0
 * @see
 */
public abstract class GenericManagedBean implements Serializable {

	// Identificador de Serial Version.
	private static final long serialVersionUID = 1L;
	
	// Constante que define la ruta del recurso de mensajes.
	protected static final String MESSAGE_RESOURCE = "co.gestionsoft.web.view.messages";
	
	// Resource Bundle para la gestion de los mensajes de error.
	protected static final ResourceBundle BUNDLE = ResourceBundle.getBundle(MESSAGE_RESOURCE);	
	
	// Constante numerica de valor cero.
	protected static final Long ZERO_LONG = Long.valueOf(0);
	
	// Constante para administrar los logs
	protected static final Logger LOGGER = Logger.getLogger(GenericManagedBean.class);
	
	// Atributos de la clase.
	protected boolean loadSuccess;
	
	/**
	 * Constructor por defecto de la clase.
	 */
	public GenericManagedBean() {
		super();
	}
	
	/**
     * Metodo que permite conocer si la pagina ha cargado correctamente.  
     *
     * @return valor que indica si la pagina ha cargado correctamente.
     */
	public boolean isLoadSuccess() {
		return loadSuccess;
	}	

}  // Final GenericManagedBean.
