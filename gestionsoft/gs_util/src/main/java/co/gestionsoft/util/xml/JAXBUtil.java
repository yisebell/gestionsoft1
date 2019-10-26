package co.gestionsoft.util.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.InputSource;

/**
 * Clase de utilidad para los procesos de marshalling y unmarshalling.
 * 
 * @author a586979
 * @date 02/10/2104
 */
public final class JAXBUtil {

	/**
	 * Constructor privado de la clase.
	 */
	private JAXBUtil() {
		super();
	}
	
	/**
	 * Metodo que permite realizar el unmarshalling de un XML string a objeto JAXB.
	 * 
	 * @param clazz clase que se desea obtener.
	 * @param xml XML String recibido.
	 * @return instancia de objeto JAXB.
	 * @throws JAXBException excepcion producida durante la ejecucion del metodo. 
	 */
	public static Object unmarshall(@SuppressWarnings("rawtypes") final Class clazz, final String xml) throws JAXBException {
		// Se obtiene el contexto a partir de la clase del objeto.
		final JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

		// Se crea el unmarshaller y se realiza la operacion.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(new InputSource(new StringReader(xml)));
	}
	
	/**
	 * Metodo que permite serializar a XML String una instancia JAXB.
	 *  
	 * @param object objeto que se quiere serializar a XML String.
	 * @return 
	 * @return resultado de la serializacion.
	 * @throws JAXBException excepcion producida durante la ejecucion del metodo.
	 */
	public static String marshall(final Object object) throws JAXBException {
		// Se obtiene el contexto a partir de la clase del objeto.
		final JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
		
		// Se crea el marshaller y se establecen las propiedades antes de la operacion.
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        // Se serializa a String.
        final StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
	}
	
}  // Final JAXBUtil.
