/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Luca
 */
@Entity
@NamedQueries({
@NamedQuery(name="findAllTask",query="select t from Task t"),
@NamedQuery(name ="findBookH2G2",query ="SELECT b FROM Book b WHERE b.title = 'H2G2'")
})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int percentuale;

    public Task() {
    }

    public Task(String name,int percentuale) {
        this.name = name;
        this.percentuale = percentuale;
    }

    public String getName() {
        return name;
    }

    public int getPercentuale() {
        return percentuale;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "archivio.Task[ id=" + id + " ]";
    }
    
}