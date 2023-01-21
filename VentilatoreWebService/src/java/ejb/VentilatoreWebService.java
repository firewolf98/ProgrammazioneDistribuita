/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Eugenio
 */
@WebService(serviceName = "VentilatoreWebService")
public class VentilatoreWebService {
    @Inject
    public Event<Ventilatore> servEvent;
    
    @EJB
    private VentilatoreEJBRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    
    @WebMethod(exclude = true)
    public void createVentilatore(@WebParam(name = "v") Ventilatore v) {
        ejbRef.createVentilatore(v);
    }

    @WebMethod(exclude = true)
    public void deleteVentilatore(@WebParam(name = "v") Ventilatore v) {
        ejbRef.deleteVentilatore(v);
    }

    @WebMethod(exclude = true)
    public Ventilatore updateVentilatore(@WebParam(name = "v") Ventilatore v) {
        return ejbRef.updateVentilatore(v);
    }

    @WebMethod(exclude = true)
    public List<Ventilatore> findAllVentilatori() {
        return ejbRef.findAllVentilatori();
    }

    @WebMethod(exclude = true)
    public List<Ventilatore> printByCountry(@WebParam(name = "c") String c) {
        return ejbRef.printByCountry(c);
    }

    @WebMethod(exclude = true) 
    public Ventilatore findById(@WebParam(name = "id") int id) {
        return ejbRef.findById(id);
    }

    @WebMethod(exclude = true)
    public List<Ventilatore> printQuickFan(@WebParam(name = "f") int f) {
        return ejbRef.printQuickFan(f);
    }
    
    @WebMethod(operationName = "modificaGiri")
    public void modificaGiri(int id,int giri) {
       Ventilatore v = findById(id);
       v.setGiriMinuto(giri);
       servEvent.fire(v);
    }
    
}
