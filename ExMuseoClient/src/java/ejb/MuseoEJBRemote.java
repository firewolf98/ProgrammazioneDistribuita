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
 * @author lucae
 */
@Remote
public interface MuseoEJBRemote {
    public void createMuseo(Museo m);
    public void removeMuseo(Museo m);
    public Museo updateMuseo(Museo m);
    public Museo findMuseoById(int id);
    public List<Museo> findMuseoByRegione(String regione);
    public List<Museo> findAllMusei();
}
