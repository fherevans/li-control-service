//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.09.21 at 01:09:03 PM CDT 
//


package mx.santander.liquidez.control.resolver.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestLDAP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestLDAP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claveAplicativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usuarioAplicativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestLDAP", propOrder = {
    "claveAplicativo",
    "usuarioAplicativo"
})
@XmlSeeAlso({
    RequestCorporativo.class,
    RequestLocal.class
})
public class RequestLDAP {

    protected String claveAplicativo;
    protected String usuarioAplicativo;

    /**
     * Gets the value of the claveAplicativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveAplicativo() {
        return claveAplicativo;
    }

    /**
     * Sets the value of the claveAplicativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveAplicativo(String value) {
        this.claveAplicativo = value;
    }

    /**
     * Gets the value of the usuarioAplicativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioAplicativo() {
        return usuarioAplicativo;
    }

    /**
     * Sets the value of the usuarioAplicativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioAplicativo(String value) {
        this.usuarioAplicativo = value;
    }

}
