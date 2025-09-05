
package com.exlibris.dps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für getDepositActivityByUpdateDateByMaterialFlowResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="getDepositActivityByUpdateDateByMaterialFlowResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateDateResultByMF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDepositActivityByUpdateDateByMaterialFlowResponse", propOrder = {
    "updateDateResultByMF"
})
public class GetDepositActivityByUpdateDateByMaterialFlowResponse {

    protected String updateDateResultByMF;

    /**
     * Ruft den Wert der updateDateResultByMF-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateDateResultByMF() {
        return updateDateResultByMF;
    }

    /**
     * Legt den Wert der updateDateResultByMF-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateDateResultByMF(String value) {
        this.updateDateResultByMF = value;
    }

}
