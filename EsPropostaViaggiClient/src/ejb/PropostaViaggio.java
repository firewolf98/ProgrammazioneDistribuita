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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eugenio
 */
@Entity
@NamedQueries({
    @NamedQuery(name="findAllViaggi" ,query = "select v from PropostaViaggio v"),
    @NamedQuery(name="findViaggioById" ,query = "select v from PropostaViaggio v where v.id = :id"),
    @NamedQuery(name="findViaggioByDestinazione" ,query = "select v from PropostaViaggio v where v.destinazione = :destinazione"),
    @NamedQuery(name="findViaggioByCategoria" ,query = "select v from PropostaViaggio v where v.categoria = :categoria")
})
public class PropostaViaggio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String categoria;
    @NotNull
    private String destinazione;
    @NotNull
    private float prezzo;
    private int sconto;
    private int disponibilita;

    public PropostaViaggio() {
    }

    public PropostaViaggio(String categoria, String destinazione, float prezzo, int sconto, int disponibilita) {
        this.categoria = categoria;
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.disponibilita = disponibilita;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
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
        if (!(object instanceof PropostaViaggio)) {
            return false;
        }
        PropostaViaggio other = (PropostaViaggio) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PropostaViaggio{" + "id=" + id + ", categoria=" + categoria + ", destinazione=" + destinazione + ", prezzo=" + prezzo + ", sconto=" + sconto + ", disponibilita=" + disponibilita + '}';
    }

    
    
}
