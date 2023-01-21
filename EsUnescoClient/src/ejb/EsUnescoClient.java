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
public class EsUnescoClient {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        UnescoEJBRemote unescoRemote = (UnescoEJBRemote) ctx.lookup("java:global/EsUnescoEJB/UnescoEJB!ejb.UnescoEJBRemote");
        
        System.out.println(unescoRemote.findAllSitiUnesco());
        System.out.println(unescoRemote.findSitoUnescoByTipologia("Misto"));
    }
    
}
