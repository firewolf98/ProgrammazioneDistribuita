/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espositoluca;

import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luca
 */
public class ClientTask {
    static EntityManagerFactory emf;
    static EntityManager em;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("EsamePU");   
        em = emf.createEntityManager();
        System.out.println("lista : "+getAllTask());
        System.out.println("byId : "+findTaskById(1));
        System.out.println("byType : "+findTaskByType("amministrazione"));
        System.out.println("byOre : "+findTaskByOre(0));
        System.out.println("byMinOre : "+findTaskByMinOre(7));
        System.out.println("byCompletate : "+findTaskByTaskCompletate());
        System.out.println("byNonCompletate : "+findTaskByTaskNonCompletate());
        
        
    }
    @Counter
    private static List<Task> getAllTask(){
        List<Task> tasks = em.createNamedQuery("findAllTask",Task.class).getResultList();
        return tasks;
    }
    private static Task findTaskById(int id){
        
        Task task = em.createNamedQuery("findTaskById",Task.class).setParameter("id", id).getSingleResult();
        return task;
    }
    private static List<Task> findTaskByType(String tipo){
        
        List<Task> tasks = em.createNamedQuery("findTaskByType",Task.class).setParameter("tipo", tipo).getResultList();
        return tasks;
    }
    private static  List<Task> findTaskByOre(int ore){
        
        List<Task> tasks = em.createNamedQuery("findTaskByOre",Task.class).setParameter("ore", ore).getResultList();
        return tasks;
    }
    private static List<Task> findTaskByAssegnatario(String assegnatario){
        
        List<Task> tasks = em.createNamedQuery("findTaskByAssegnatario",Task.class).setParameter("assegnatario", assegnatario).getResultList();
        return tasks;
    }
    private static List<Task> findTaskByMinOre(int ore){
        
        List<Task> tasks = em.createNamedQuery("findTaskByMinOre",Task.class).setParameter("ore", ore).getResultList();
        return tasks;
    }
    private static List<Task> findTaskByTaskCompletate(){
        
        List<Task> tasks = em.createNamedQuery("findTaskByTaskCompletate",Task.class).getResultList();
        return tasks;
    }
    private static List<Task> findTaskByTaskNonCompletate(){
        
        List<Task> tasks = em.createNamedQuery("findTaskByTaskNonCompletate",Task.class).getResultList();
        return tasks;
    }
}
