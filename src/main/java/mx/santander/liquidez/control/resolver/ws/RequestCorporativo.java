//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.09.21 at 01:09:03 PM CDT 
//


package mx.santander.liquidez.control.resolver.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestCorporativo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestCorporativo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.resolver.isban.mx/}requestLDAP"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identificadorCorporativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestCorporativo", propOrder = {
    "identificadorCorporativo"
})
public class RequestCorporativo
    extends RequestLDAP
{

    protected String identificadorCorporativo;

    /**
     * Gets the value of the identificadorCorporativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificadorCorporativo() {
        return identificadorCorporativo;
    }

    /**
     * Sets the value of the identificadorCorporativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificadorCorporativo(String value) {
        this.identificadorCorporativo = value;
    }

}
