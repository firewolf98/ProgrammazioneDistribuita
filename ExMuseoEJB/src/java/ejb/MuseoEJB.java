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
import javax.persistence.EntityManager;

/**
 *
 * @author lucae
 */
@Stateless
@LocalBean
public class MuseoEJB implements MuseoEJBRemote{
    @Inject
    private EntityManager em;
    
    @Override
    public void createMuseo(Museo m) {
        em.persist(m);
    }
    
    @Override
    public void removeMuseo(Museo m) {
        em.remove(em.merge(m));
    }
    
    @Override
    public Museo updateMuseo(Museo m) {
        return em.merge(m);
    }
    
    @Override
    public Museo findMuseoById(int id) {
        return em.createNamedQuery("findMuseoById", Museo.class).setParameter("id",id).getSingleResult();
    }
    
    @Override
    public List<Museo> findMuseoByRegione(String regione) {
        return em.createNamedQuery("findMuseoByRegione", Museo.class).setParameter("regione", regione).getResultList();
    }
    
    @Override
    public List<Museo> findAllMusei() {
        return em.createNamedQuery("findAllMusei", Museo.class).getResultList();
    }
}
