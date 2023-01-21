package ejb;


import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucae
 */
public class MuseoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException{
        Context ctx=new InitialContext();
        MuseoEJBRemote mejbr=(MuseoEJBRemote) ctx.lookup("java:global/ExMuseoEJB/MuseoEJB!ejb.MuseoEJBRemote");
        Scanner in=new Scanner(System.in);
        System.out.println("Inserisci la regione dei musei da cercare:");
        String regione=in.nextLine();
        System.out.println("I musei della/del "+regione+"sono: ");
        for(Museo m:mejbr.findMuseoByRegione(regione)) {
            System.out.println(m);
        }
    }
    
}
