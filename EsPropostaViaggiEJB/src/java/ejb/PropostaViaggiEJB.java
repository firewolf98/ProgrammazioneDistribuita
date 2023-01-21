/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;

/**
 *
 * @author Eugenio
 */
@Stateless
@LocalBean
@Interceptors(CounterMethodInterceptor.class)
public class PropostaViaggiEJB implements PropostaViaggiEJBRemote {
    @Inject
    private EntityManager em;
        
    @Override
    public void createProposta(PropostaViaggio viaggio) {
     em.persist(viaggio);
    }

    @Override
    public void deleteProposta(PropostaViaggio viaggio) {
      em.remove(em.merge(viaggio));
    }

    @Override
    public PropostaViaggio updateProposta(PropostaViaggio viaggio) {
        return em.merge(viaggio);
    }

    @Override
    public PropostaViaggio findViaggioById(int id) {
        return em.createNamedQuery("findViaggioById",PropostaViaggio.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<PropostaViaggio> findViaggioByDestinazione(String destinazione) {
        return em.createNamedQuery("findViaggioByDestinazione",PropostaViaggio.class).setParameter("destinazione", destinazione).getResultList();
    }

    @Override
    public List<PropostaViaggio> findViaggioByCategoria(String categoria) {
      return em.createNamedQuery("findViaggioByCategoria",PropostaViaggio.class).setParameter("categoria", categoria).getResultList();
    }

    @Override
    public List<PropostaViaggio> findAllViaggi() {
        return em.createNamedQuery("findAllViaggi",PropostaViaggio.class).getResultList();
    }

}
