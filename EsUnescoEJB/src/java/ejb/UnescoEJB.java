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
public class UnescoEJB implements UnescoEJBRemote {
    @Inject
    private EntityManager em;
    
    @Override
    public void createSitoUnesco(Unesco unesco) {
        em.persist(unesco);
    }

    @Override
    public void removeSitoUnesco(Unesco unesco) {
        em.remove(em.merge(unesco));
    }

    @Override
    public Unesco updateSitoUnesco(Unesco unesco) {
        return em.merge(unesco);
    }
    
    @Override
    public Unesco findSitoUnescoById(int id) {
        return em.createNamedQuery("findById",Unesco.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Unesco> findSitoUnescoByRegione(String regione) {
        return em.createNamedQuery("findByRegione",Unesco.class).setParameter("regione", regione).getResultList();
    }

    @Override
    public List<Unesco> findAllSitiUnesco() {
        return em.createNamedQuery("findAllSiti",Unesco.class).getResultList();
    }
    
    @Interceptors(CounterInterceptor.class)
    @Override
    public List<Unesco> findSitoUnescoByTipologia(String tipo) {
      return em.createNamedQuery("findByTipologia",Unesco.class).setParameter("tipo", tipo).getResultList();
    }

}
