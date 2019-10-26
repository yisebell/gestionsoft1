package co.gestionsoft.business.util.pagination.beans;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.correos.sava.frontoffice.business.util.pagination.beans package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServerPagination_QNAME = new QName("", "server-pagination");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.correos.sava.frontoffice.business.util.pagination.beans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

    /**
     * Create an instance of {@link SortFieldType }
     * 
     */
    public SortFieldType createSortFieldType() {
        return new SortFieldType();
    }

    /**
     * Create an instance of {@link ServerPaginationType }
     * 
     */
    public ServerPaginationType createServerPaginationType() {
        return new ServerPaginationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServerPaginationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "server-pagination")
    public JAXBElement<ServerPaginationType> createServerPagination(ServerPaginationType value) {
        return new JAXBElement<ServerPaginationType>(_ServerPagination_QNAME, ServerPaginationType.class, null, value);
    }

}

