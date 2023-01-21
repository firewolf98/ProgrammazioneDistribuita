/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import libreria2.Book;

/**
 *
 * @author Luca
 */
public class Libreria2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Book book = new Book("H2G2", 350.50F, "Un libro bello", "1-23456-789-8", 10, false);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsamePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(book);
        et.commit();
        System.out.println("#####"+book.getDescription());
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        List<Book> books = em.createNamedQuery("findAllBook", Book.class).getResultList();
       for(int i = 0;i<books.size();i++)
       {
            System.out.println("#####"+books.get(i).getDescription());
       }
        System.out.println("#####"+book.getDescription());
        em.close();
        emf.close();
    }
    
}
