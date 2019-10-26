package co.gestionsoft.business.util.pagination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Component;

import co.gestionsoft.business.util.pagination.beans.EntityType;
import co.gestionsoft.business.util.pagination.beans.ServerPaginationType;
import co.gestionsoft.business.util.pagination.beans.SortFieldType;
import co.gestionsoft.util.xml.JAXBUtil;
import co.gestionsoft.util.xml.XMLSchemaValidator;


/**
 * Clase que permite realizar el mapeo entre atributos de ordenacion y estructura de las entities de persistencia.
 * 
 * @author a586979
 * @date 02/02/2015
 * @version 1.0
 * @see
 */
@Component
public final class ServerPaginationMapping {

	// Constante que posee la ruta del esquema para la validacion de la paginacion.
	private static final String XSD_PAGINATION_SCHEMA_PATH = "co/gestionsoft/business/util/pagination/serverPaginationScheme.xsd";
	
	// Constante que posee la ruta del XML de configuracion para la paginacion.
	private static final String XML_PAGINATION_RULES_PATH = "co/gestionsoft/business/util/pagination/serverPagination.xml";
	
	private Map<String, Map<String, String>> pagination = null;
	
	/**
	 * Constructor por defecto de la clase.
	 */
	public ServerPaginationMapping() {
		super();
	}
	
	/**
	 * Metodo que permite cargar las reglas de mapeo definidas en el XML de configuracion. 
	 * @throws Exception 
	 */
	@PostConstruct
	private void loadRules() throws Exception {
		try {
			pagination = new HashMap<String, Map<String, String>>();
			
			// Se lee el XML de configuracion.
			final URL xmlURL = Thread.currentThread().getContextClassLoader().getResource(XML_PAGINATION_RULES_PATH);
			BufferedReader in = new BufferedReader(new InputStreamReader(xmlURL.openStream()));
	        String inputLine;
	        StringBuilder xml = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	        	xml.append(inputLine); 
	        }
	        in.close();			
	        
	        // Se cargan los valores.
	        ServerPaginationType value = (ServerPaginationType) JAXBUtil.unmarshall(ServerPaginationType.class, xml.toString().trim());
	        
	        // Se itera sobre todos los campos y se crea el mapa.
	        for (EntityType entity : value.getEntity()) {
	        	Map<String, String> fieldsMap = new HashMap<String,String>();
	        	for (SortFieldType field : entity.getSortField()) {
	        		fieldsMap.put(field.getName(), field.getValue());
	        	}
	        	
	        	// Al finalizar el conjunto de campos se anyade el valor por defecto y se anyade al mapa global.
	        	fieldsMap.put("default", entity.getDefault());
	        	pagination.put(entity.getClazz(), fieldsMap); 
	        }
	        
		} catch (IOException e) {
			e.printStackTrace();
		}catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite obtener el valor de mapeo de una entidad y un campo. 
	 *
	 * @param clazz entidad.
	 * @param field campo.
	 * @return valor de mapeo.
	 */
	public String getMapping(final String clazz, final String field) {
		Map<String, String> tmp = pagination.get(clazz);
		return tmp.get(field);
	}
	
}  // Final ServerPaginationMapping.
