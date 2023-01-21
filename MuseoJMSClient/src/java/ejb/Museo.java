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

/**
 *
 * @author lucae
 */
@Entity
@NamedQueries ({
    @NamedQuery(name="findMuseoById",query="select m from Museo m where m.id=:id"),
    @NamedQuery(name="findMuseoByRegione",query="select m from Museo m where m.regione=:regione"),
    @NamedQuery(name="findAllMusei",query="select m from Museo m")
})
public class Museo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String nomeMuseo;
    @NotNull
    private String direttore;
    @NotNull
    private int numeroVisitatori;
    @NotNull
    private String città;
    @NotNull
    private String provincia;
    @NotNull
    private String regione;
    
    public Museo() {
        
    }
    
    public Museo(String nomeMuseo,String direttore,int numeroVisitatori,String città,String provincia,String regione) {
        this.nomeMuseo=nomeMuseo;
        this.direttore=direttore;
        this.numeroVisitatori=numeroVisitatori;
        this.città=città;
        this.provincia=provincia;
        this.regione=regione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomeMuseo() {
        return nomeMuseo;
    }
    
    public void setNomeMuseo(String nomeMuseo) {
        this.nomeMuseo=nomeMuseo;
    }
    
    public String getDirettore(String direttore) {
        return direttore;
    }
    
    public void setDirettore(String direttore) {
        this.direttore=direttore;
    }
    
    public int getNumeroVisitatori() {
        return numeroVisitatori;
    }
    
    public void setNumeroVisitatori(int numeroVisitatori) {
        this.numeroVisitatori=numeroVisitatori;
    }
    
    public String getCittà() {
        return città;
    }
    
    public void setCittà(String città) {
        this.città=città;
    }
    
    public String getProvincia() {
        return provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia=provincia;
    }
    
    public String getRegione() {
        return regione;
    }
    
    public void setRegione(String regione) {
        this.regione=regione;
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
        if (!(object instanceof Museo)) {
            return false;
        }
        Museo other = (Museo) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Museo[ id=" + id + " ]";
    }
    
}
