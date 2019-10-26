package co.gestionsoft.util.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


/**
 * Clase que permite realizar la validacion de un xml con un esquema de datos.
 *  
 * @author a586979
 * @date 02/02/2015
 */
public final class XMLSchemaValidator {

	/**
	 * Constructor privado de la clase.
	 */
	private XMLSchemaValidator() {
		super();
	}
	
	/**
	 * Metodo que permite realizar la validacion de un fichero XML con un esquema XSD.
	 * 
	 * @param xml stream con el contenido del xml.
	 * @param xsd stream con el contenido del xsd.
	 * @return valor que indica si la validacion es correcta o no.
	 */
	public static boolean validateAgainstXSD(final InputStream xml, final InputStream xsd) {
		boolean isValid = false;
		
		// Se carga la factoria y se lee el esquema como stream.
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	    try {
		    final Schema schema = factory.newSchema(new StreamSource(xsd));

	    	
	    	final Validator validator = schema.newValidator();
	        validator.validate(new StreamSource(xml));		
	        isValid = true;
	    } catch (SAXException  e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
		}
	    return isValid;
	}	

	/**
	 * Metodo que permite validar el contenido de un fichero XML en formato cadena sobre un esquema XSD cuya
	 * referencia se pasa como ruta del fichero.
	 * 
	 * @param xmlString contenido del xml en formato cadena.
	 * @param schemaLocation localizacion del esquema xsd.
	 * @return valor que indica si la validacion es correcta o no.
	 */
	public static boolean validateAgainstXSD(final String xml, final String schemaLocation) {
		boolean isValid = false;
		
		// Se carga la factoria y se lee el esquema como stream.
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		try {
			// Se crea el esquema a partir de la ruta del fichero.
			final URL xsdURL = Thread.currentThread().getContextClassLoader().getResource(schemaLocation);
			final Schema schema = factory.newSchema(xsdURL);
	        final Validator validator = schema.newValidator();
	        
	        // Se valida el XML contra el XSD.
	        final StringReader xmlReader = new StringReader(xml); 
	        validator.validate(new StreamSource(xmlReader));
	        
	        isValid = true;
		} catch (SAXException  e) {
			// En caso de error de validacion, se obtendra una SAXException.
			
			StringBuilder mensaje = new StringBuilder("Error de validacion del xml con el esquema ");
			mensaje.append(e.toString());
			
	    	
	    } catch (IOException e) {
	    	
	    	StringBuilder mensaje = new StringBuilder("Error al crear el stream sobre el XML-String en la valildacion del esquema ");
			mensaje.append(e.toString());
			
	    	
		} catch (IllegalArgumentException e) {
			
			StringBuilder mensaje = new StringBuilder("No se ha podido validar contra el esquema XSD el mensaje recibido ");
			mensaje.append(e.toString());
			
			
		}
	    return isValid;
	}		
	
}  // Final XMLSchemaValidator.
