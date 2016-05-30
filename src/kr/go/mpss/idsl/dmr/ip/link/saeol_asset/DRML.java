//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.22 at 07:13:56 ���� GMT+09:00 
//


package kr.go.mpss.idsl.dmr.ip.link.saeol_asset;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="organInfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="organID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="summaryInfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="dataCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="equipmentCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="materialCount" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="isAll" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="resources">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="equipmentInfos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="sfTeamCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="depCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="deptNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="purcSNO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="govAtclCatNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="atclSizNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="sizNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="korAtclNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="astNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="purcYmd" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="chYmd" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="chgWhy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="atclUnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="useTerm" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="qt" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="ucst" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="depoPlc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="inOutExpGbn" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="chgCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="tagUseYn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "resources"
})
@XmlRootElement(name = "DRML")
public class DRML {

    @XmlElement(required = true)
    protected DRML.Header header;
    @XmlElement(required = true)
    protected DRML.Resources resources;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link DRML.Header }
     *     
     */
    public DRML.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link DRML.Header }
     *     
     */
    public void setHeader(DRML.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the resources property.
     * 
     * @return
     *     possible object is
     *     {@link DRML.Resources }
     *     
     */
    public DRML.Resources getResources() {
        return resources;
    }

    /**
     * Sets the value of the resources property.
     * 
     * @param value
     *     allowed object is
     *     {@link DRML.Resources }
     *     
     */
    public void setResources(DRML.Resources value) {
        this.resources = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="organInfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="organID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="summaryInfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="dataCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="equipmentCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="materialCount" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="isAll" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "organInfo",
        "summaryInfo"
    })
    public static class Header {

        @XmlElement(required = true)
        protected DRML.Header.OrganInfo organInfo;
        @XmlElement(required = true)
        protected DRML.Header.SummaryInfo summaryInfo;

        /**
         * Gets the value of the organInfo property.
         * 
         * @return
         *     possible object is
         *     {@link DRML.Header.OrganInfo }
         *     
         */
        public DRML.Header.OrganInfo getOrganInfo() {
            return organInfo;
        }

        /**
         * Sets the value of the organInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRML.Header.OrganInfo }
         *     
         */
        public void setOrganInfo(DRML.Header.OrganInfo value) {
            this.organInfo = value;
        }

        /**
         * Gets the value of the summaryInfo property.
         * 
         * @return
         *     possible object is
         *     {@link DRML.Header.SummaryInfo }
         *     
         */
        public DRML.Header.SummaryInfo getSummaryInfo() {
            return summaryInfo;
        }

        /**
         * Sets the value of the summaryInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRML.Header.SummaryInfo }
         *     
         */
        public void setSummaryInfo(DRML.Header.SummaryInfo value) {
            this.summaryInfo = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="organID" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "organID"
        })
        public static class OrganInfo {

            protected int organID;

            /**
             * Gets the value of the organID property.
             * 
             */
            public int getOrganID() {
                return organID;
            }

            /**
             * Sets the value of the organID property.
             * 
             */
            public void setOrganID(int value) {
                this.organID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="dataCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="equipmentCount" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="materialCount" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="isAll" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "date",
            "resultCode",
            "dataCount",
            "equipmentCount",
            "materialCount",
            "isAll"
        })
        public static class SummaryInfo {

            @XmlElement(name = "ID", required = true)
            protected String id;
            @XmlElement(required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar date;
            protected byte resultCode;
            protected short dataCount;
            protected short equipmentCount;
            protected byte materialCount;
            @XmlElement(required = true)
            protected String isAll;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setID(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the date property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDate() {
                return date;
            }

            /**
             * Sets the value of the date property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDate(XMLGregorianCalendar value) {
                this.date = value;
            }

            /**
             * Gets the value of the resultCode property.
             * 
             */
            public byte getResultCode() {
                return resultCode;
            }

            /**
             * Sets the value of the resultCode property.
             * 
             */
            public void setResultCode(byte value) {
                this.resultCode = value;
            }

            /**
             * Gets the value of the dataCount property.
             * 
             */
            public short getDataCount() {
                return dataCount;
            }

            /**
             * Sets the value of the dataCount property.
             * 
             */
            public void setDataCount(short value) {
                this.dataCount = value;
            }

            /**
             * Gets the value of the equipmentCount property.
             * 
             */
            public short getEquipmentCount() {
                return equipmentCount;
            }

            /**
             * Sets the value of the equipmentCount property.
             * 
             */
            public void setEquipmentCount(short value) {
                this.equipmentCount = value;
            }

            /**
             * Gets the value of the materialCount property.
             * 
             */
            public byte getMaterialCount() {
                return materialCount;
            }

            /**
             * Sets the value of the materialCount property.
             * 
             */
            public void setMaterialCount(byte value) {
                this.materialCount = value;
            }

            /**
             * Gets the value of the isAll property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsAll() {
                return isAll;
            }

            /**
             * Sets the value of the isAll property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsAll(String value) {
                this.isAll = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="equipmentInfos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="sfTeamCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="depCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="deptNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="purcSNO" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="govAtclCatNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="atclSizNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="sizNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="korAtclNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="astNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="purcYmd" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="chYmd" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="chgWhy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="atclUnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="useTerm" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="qt" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="ucst" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="depoPlc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="inOutExpGbn" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="chgCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="tagUseYn" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "equipmentInfos"
    })
    public static class Resources {

        protected List<DRML.Resources.EquipmentInfos> equipmentInfos;

        /**
         * Gets the value of the equipmentInfos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the equipmentInfos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEquipmentInfos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DRML.Resources.EquipmentInfos }
         * 
         * 
         */
        public List<DRML.Resources.EquipmentInfos> getEquipmentInfos() {
            if (equipmentInfos == null) {
                equipmentInfos = new ArrayList<DRML.Resources.EquipmentInfos>();
            }
            return this.equipmentInfos;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="sfTeamCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="depCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="deptNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="purcSNO" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="govAtclCatNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="atclSizNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="sizNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="korAtclNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="astNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="purcYmd" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="chYmd" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="chgWhy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="atclUnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="useTerm" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="qt" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="ucst" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="depoPlc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="inOutExpGbn" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="chgCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="tagUseYn" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sfTeamCode",
            "depCode",
            "deptNm",
            "purcSNO",
            "govAtclCatNo",
            "atclSizNo",
            "sizNm",
            "korAtclNm",
            "astNo",
            "purcYmd",
            "chYmd",
            "chgWhy",
            "atclUnt",
            "useTerm",
            "qt",
            "ucst",
            "depoPlc",
            "inOutExpGbn",
            "chgCode",
            "tagUseYn"
        })
        public static class EquipmentInfos {

            protected String sfTeamCode;
            protected String depCode;
            protected String deptNm;
            protected String purcSNO;
            protected String govAtclCatNo;
            protected String atclSizNo;
            protected String sizNm;
            @XmlElement(required = true)
            protected String korAtclNm;
            protected String astNo;
            @XmlElement(required = true)
            @XmlSchemaType(name = "date")
            protected String purcYmd;
            @XmlElement(required = true)
            @XmlSchemaType(name = "date")
            protected String chYmd;
            protected String chgWhy;
            protected String atclUnt;
            protected String useTerm;
            protected String qt;
            protected String ucst;
            protected String depoPlc;
            protected String inOutExpGbn;
            protected String chgCode;
            @XmlElement(required = true)
            protected String tagUseYn;

            /**
             * Gets the value of the sfTeamCode property.
             * 
             */
            public String getSfTeamCode() {
                return sfTeamCode;
            }

            /**
             * Sets the value of the sfTeamCode property.
             * 
             */
            public void setSfTeamCode(String value) {
                this.sfTeamCode = value;
            }

            /**
             * Gets the value of the depCode property.
             * 
             */
            public String getDepCode() {
                return depCode;
            }

            /**
             * Sets the value of the depCode property.
             * 
             */
            public void setDepCode(String value) {
                this.depCode = value;
            }

            /**
             * Gets the value of the deptNm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDeptNm() {
                return deptNm;
            }

            /**
             * Sets the value of the deptNm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDeptNm(String value) {
                this.deptNm = value;
            }

            /**
             * Gets the value of the purcSNO property.
             * 
             */
            public String getPurcSNO() {
                return purcSNO;
            }

            /**
             * Sets the value of the purcSNO property.
             * 
             */
            public void setPurcSNO(String value) {
                this.purcSNO = value;
            }

            /**
             * Gets the value of the govAtclCatNo property.
             * 
             */
            public String getGovAtclCatNo() {
                return govAtclCatNo;
            }

            /**
             * Sets the value of the govAtclCatNo property.
             * 
             */
            public void setGovAtclCatNo(String value) {
                this.govAtclCatNo = value;
            }

            /**
             * Gets the value of the atclSizNo property.
             * 
             */
            public String getAtclSizNo() {
                return atclSizNo;
            }

            /**
             * Sets the value of the atclSizNo property.
             * 
             */
            public void setAtclSizNo(String value) {
                this.atclSizNo = value;
            }

            /**
             * Gets the value of the sizNm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSizNm() {
                return sizNm;
            }

            /**
             * Sets the value of the sizNm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSizNm(String value) {
                this.sizNm = value;
            }

            /**
             * Gets the value of the korAtclNm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKorAtclNm() {
                return korAtclNm;
            }

            /**
             * Sets the value of the korAtclNm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKorAtclNm(String value) {
                this.korAtclNm = value;
            }

            /**
             * Gets the value of the astNo property.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public String getAstNo() {
                return astNo;
            }

            /**
             * Sets the value of the astNo property.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setAstNo(String value) {
                this.astNo = value;
            }

            /**
             * Gets the value of the purcYmd property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public String getPurcYmd() {
                return purcYmd;
            }

            /**
             * Sets the value of the purcYmd property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setPurcYmd(String value) {
                this.purcYmd = value;
            }

            /**
             * Gets the value of the chYmd property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public String getChYmd() {
                return chYmd;
            }

            /**
             * Sets the value of the chYmd property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setChYmd(String value) {
                this.chYmd = value;
            }

            /**
             * Gets the value of the chgWhy property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChgWhy() {
                return chgWhy;
            }

            /**
             * Sets the value of the chgWhy property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChgWhy(String value) {
                this.chgWhy = value;
            }

            /**
             * Gets the value of the atclUnt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAtclUnt() {
                return atclUnt;
            }

            /**
             * Sets the value of the atclUnt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAtclUnt(String value) {
                this.atclUnt = value;
            }

            /**
             * Gets the value of the useTerm property.
             * 
             */
            public String getUseTerm() {
                return useTerm;
            }

            /**
             * Sets the value of the useTerm property.
             * 
             */
            public void setUseTerm(String value) {
                this.useTerm = value;
            }

            /**
             * Gets the value of the qt property.
             * 
             */
            public String getQt() {
                return qt;
            }

            /**
             * Sets the value of the qt property.
             * 
             */
            public void setQt(String value) {
                this.qt = value;
            }

            /**
             * Gets the value of the ucst property.
             * 
             */
            public String getUcst() {
                return ucst;
            }

            /**
             * Sets the value of the ucst property.
             * 
             */
            public void setUcst(String value) {
                this.ucst = value;
            }

            /**
             * Gets the value of the depoPlc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDepoPlc() {
                return depoPlc;
            }

            /**
             * Sets the value of the depoPlc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDepoPlc(String value) {
                this.depoPlc = value;
            }

            /**
             * Gets the value of the inOutExpGbn property.
             * 
             */
            public String getInOutExpGbn() {
                return inOutExpGbn;
            }

            /**
             * Sets the value of the inOutExpGbn property.
             * 
             */
            public void setInOutExpGbn(String value) {
                this.inOutExpGbn = value;
            }

            /**
             * Gets the value of the chgCode property.
             * 
             */
            public String getChgCode() {
                return chgCode;
            }

            /**
             * Sets the value of the chgCode property.
             * 
             */
            public void setChgCode(String value) {
                this.chgCode = value;
            }

            /**
             * Gets the value of the tagUseYn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTagUseYn() {
                return tagUseYn;
            }

            /**
             * Sets the value of the tagUseYn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTagUseYn(String value) {
                this.tagUseYn = value;
            }

        }

    }

}