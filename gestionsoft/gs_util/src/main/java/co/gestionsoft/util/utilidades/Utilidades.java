package co.gestionsoft.util.utilidades;

/**
 * Clase para definir utilidades comunes a toda la aplicación
 * @author james
 * @date 29/10/2019
 * @version 1.0
 * @see
 */
public final class Utilidades {

	/**
	 * Metodo constructor privado de la clase estática
	 */
	private Utilidades() {
		super();
	}
	
	public static Boolean isNull(Object obj) {
		return obj == null;
	}

}
