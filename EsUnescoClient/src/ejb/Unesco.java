/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Eugenio
 */
@Entity
@NamedQueries({
@NamedQuery(name = "findById" , query = "select u from Unesco u where u.id = :id"),
@NamedQuery(name = "findByRegione" , query = "select u from Unesco u where u.regione = :regione"),
@NamedQuery(name = "findByTipologia" , query = "select u from Unesco u where u.tipologia = :tipo"),
@NamedQuery(name = "findAllSiti" , query = "select u from Unesco u")
})
public class Unesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomeSito;
    private int data;
    private String tipologia;
    private String regione;

    public Unesco(String nomeSito, int data, String tipologia, String regione) {
        this.nomeSito = nomeSito;
        this.data = data;
        this.tipologia = tipologia;
        this.regione = regione;
    }

    public Unesco() {
    }

    public String getNomeSito() {
        return nomeSito;
    }

    public void setNomeSito(String nomeSito) {
        this.nomeSito = nomeSito;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
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
        if (!(object instanceof Unesco)) {
            return false;
        }
        Unesco other = (Unesco) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Unesco{" + "id=" + id + ", nomeSito=" + nomeSito + ", data=" + data + ", tipologia=" + tipologia + ", regione=" + regione + '}';
    }

    
}
