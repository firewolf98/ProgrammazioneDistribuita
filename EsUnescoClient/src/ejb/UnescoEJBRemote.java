/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Eugenio
 */
@Remote
public interface UnescoEJBRemote {
    public void createSitoUnesco(Unesco unesco);
    public void removeSitoUnesco(Unesco unesco);
    public Unesco updateSitoUnesco(Unesco unesco);
    public Unesco findSitoUnescoById(int id);
    public List<Unesco> findSitoUnescoByRegione(String regione);
    public List<Unesco> findSitoUnescoByTipologia(String tipo);
    public List<Unesco> findAllSitiUnesco();
}
