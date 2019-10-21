package gestionsoft.web.view.session;

import java.io.Serializable;

import util.domain.AbstractGenericDTO;

/**
 * Clase que permite salvar el estado de filtro y regla de navegacion de retorno
 * a una pantalla previa.
 * 
 * @author james
 * @date 20/10/2019
 * @version 1.0
 * @see
 */
public final class BackwardState implements Serializable {

	// Identificador de Serial Version.
	private static final long serialVersionUID = 3938848032806559385L;
	
	// Atributos de la clase.
	private String navigationRule;
	private AbstractGenericDTO filter;
	
	/**
	 * Constructor por defecto de la clase, que recibe los dos valores de 
	 * conservacion del estado.
	 * 
	 * @param navigationRule regla de navegacion para regresar a la pantalla.
	 * @param filter filtro de navegacion.
	 */
	public BackwardState(final String navigationRule, final AbstractGenericDTO filter) {
		this.navigationRule = navigationRule;
		this.filter = filter;
	}

	/**
	 * Metodo que permite obtener la regla de navegacion de retorno. 
	 *
	 * @return regla de navegacion de retorno.
	 */
	public String getNavigationRule() {
		return navigationRule;
	}

	/**
	 * Metodo que permite obtener el filtro de la pantalla de retorno. 
	 *
	 * @return filtro de la pantalla de retorno.
	 */
	public AbstractGenericDTO getFilter() {
		return filter;
	}

}  
