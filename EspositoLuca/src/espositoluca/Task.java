/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espositoluca;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Luca
 */
@Entity
@NamedQueries({
@NamedQuery(name= "findAllTask" ,query="Select t from Task t"),
@NamedQuery(name= "findTaskById" ,query="Select t from Task t where t.id = :id"),
@NamedQuery(name= "findTaskByType" ,query="Select t from Task t where t.tipo = :tipo"),
@NamedQuery(name= "findTaskByOre" ,query="Select t from Task t where t.ore = :ore"),
@NamedQuery(name= "findTaskByAssegnatario" ,query="Select t from Task t where t.assegnatario = :assegnatario"),
@NamedQuery(name= "findTaskByMinOre" ,query="Select t from Task t where t.ore < :ore"),
@NamedQuery(name= "findTaskByTaskCompletate" ,query="Select t from Task t where t.completamento = 100"),
@NamedQuery(name= "findTaskByTaskNonCompletate" ,query="Select t from Task t where t.completamento < 100")
})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    private String tipo;
    @Size(min=1,max=8)
    private int ore;
    private String assegnatario;
    @Size(min=0,max=100)
    private int completamento;

    public int getId() {
        return id;
    }

    public Task() {
    }

    public Task(String name, String tipo, int ore, String assegnatario, int completamento) {
        this.name = name;
        this.tipo = tipo;
        this.ore = ore;
        this.assegnatario = assegnatario;
        this.completamento = completamento;
    }

    public String getAssegnatario() {
        return assegnatario;
    }

    public int getCompletamento() {
        return completamento;
    }

    public String getName() {
        return name;
    }

    public int getOre() {
        return ore;
    }

    public String getTipo() {
        return tipo;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public void setAssegnatario(String assegnatario) {
        this.assegnatario = assegnatario;
    }

    public void setCompletamento(int completamento) {
        this.completamento = completamento;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ id= " + id + " name = " +name+" tipo= " +tipo+" ore= " +ore+ " assegnatario= " +assegnatario+" completamento= "+completamento+" ]";
    }
    
}
