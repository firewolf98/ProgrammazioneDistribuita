/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Eugenio
 */
public class EsLibroJMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        LibroEJBRemote libroRemoto = (LibroEJBRemote)ctx.lookup("java:global/EsLibroJMS/LibroEJB!ejb.LibroEJBRemote");
        Book libro = new Book("Autobiografia Eugenio", "Eugenio Corbisiero", 185.25f);
        libroRemoto.createBook(libro);
        System.out.println(libroRemoto.searchAllBook());
        
    }
    
}
