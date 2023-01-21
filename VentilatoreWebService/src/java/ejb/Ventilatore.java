package ejb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eugenio
 */
@Entity
@NamedQueries({
@NamedQuery(name = "findById",query="select v from Ventilatore v where v.id = :id"),
    @NamedQuery(name = "findByRegione",query="select v from Ventilatore v where v.nazione = :nazione"),
    @NamedQuery(name = "findByQuickFan",query="select v from Ventilatore v where v.giriMinuto > :giri"),
    @NamedQuery(name = "findAllVentilatori",query="select v from Ventilatore v")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ventilatore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute(required = true)
    private int id;
    @NotNull
    @XmlAttribute(required = true)
    private String marca;
    @NotNull
    @XmlAttribute(required = true)
    private String modello;
    @NotNull
    @XmlAttribute(required = true)
    private int giriMinuto;
    @XmlAttribute(required = true)
    private int rumore;
    @NotNull
    @XmlAttribute(required = true)
    private int elementiVenduti;
    @NotNull
    @XmlAttribute(required = true)
    private String nazione;

    public Ventilatore() {
    }

    public Ventilatore(String marca, String modello, int giriMinuto, int rumore, int elementiVenduti, String nazione) {
        this.marca = marca;
        this.modello = modello;
        this.giriMinuto = giriMinuto;
        this.rumore = rumore;
        this.elementiVenduti = elementiVenduti;
        this.nazione = nazione;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getGiriMinuto() {
        return giriMinuto;
    }

    public void setGiriMinuto(int giriMinuto) {
        this.giriMinuto = giriMinuto;
    }

    public int getRumore() {
        return rumore;
    }

    public void setRumore(int rumore) {
        this.rumore = rumore;
    }

    public int getElementiVenduti() {
        return elementiVenduti;
    }

    public void setElementiVenduti(int elementiVenduti) {
        this.elementiVenduti = elementiVenduti;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventilatore)) {
            return false;
        }
        Ventilatore other = (Ventilatore) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ventilatore{" + "id=" + id + ", marca=" + marca + ", modello=" + modello + ", giriMinuto=" + giriMinuto + ", rumore=" + rumore + ", elementiVenduti=" + elementiVenduti + ", nazione=" + nazione + '}';
    }

    
}
