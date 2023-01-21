/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author Eugenio
 */
public class ObserverClass {
    @Inject
    private VentilatoreWebService service;
    public void aggiornaGiri(@Observes Ventilatore v)
    {
        System.out.println("Aggiornati i giri del ventilatore "+service.updateVentilatore(v));
    }
    
}
