
package xhx.demo.webservice.service.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xhx.demo.webservice.service.impl package. 
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

    private final static QName _QeuryAreaResponse_QNAME = new QName("http://impl.service.webservice.demo.xhx/", "qeuryAreaResponse");
    private final static QName _QeuryArea_QNAME = new QName("http://impl.service.webservice.demo.xhx/", "qeuryArea");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xhx.demo.webservice.service.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QeuryArea }
     * 
     */
    public QeuryArea createQeuryArea() {
        return new QeuryArea();
    }

    /**
     * Create an instance of {@link QeuryAreaResponse }
     * 
     */
    public QeuryAreaResponse createQeuryAreaResponse() {
        return new QeuryAreaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QeuryAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.webservice.demo.xhx/", name = "qeuryAreaResponse")
    public JAXBElement<QeuryAreaResponse> createQeuryAreaResponse(QeuryAreaResponse value) {
        return new JAXBElement<QeuryAreaResponse>(_QeuryAreaResponse_QNAME, QeuryAreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QeuryArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.webservice.demo.xhx/", name = "qeuryArea")
    public JAXBElement<QeuryArea> createQeuryArea(QeuryArea value) {
        return new JAXBElement<QeuryArea>(_QeuryArea_QNAME, QeuryArea.class, null, value);
    }

}
