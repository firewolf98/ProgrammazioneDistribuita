/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.enterprise.event.Observes;

/**
 *
 * @author Eugenio
 */
@Remote
public interface VentilatoreEJBRemote {
    public void createVentilatore(Ventilatore v);
    public void deleteVentilatore(Ventilatore v);
    public Ventilatore updateVentilatore(Ventilatore v);
    public List<Ventilatore> findAllVentilatori();
    public List<Ventilatore> printByCountry(String c);
    public Ventilatore findById(int id);
    public List<Ventilatore> printQuickFan();
    
}
