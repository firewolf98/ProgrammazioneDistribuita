/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Eugenio
 */
public class ClientVentilatoreEJB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context c = new InitialContext();
        VentilatoreEJBRemote ventilatoreRemoto = (VentilatoreEJBRemote) c.lookup("java:global/EsVentilatoreEJB/VentilatoreEJB!ejb.VentilatoreEJBRemote");
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire il nome di una nazione di cui vuoi stampare i ventilatori :");
        String nazione = in.nextLine();
        System.out.println("Stampa di tutti i ventilatori della nazione "+nazione);
        for (Ventilatore v : ventilatoreRemoto.printByCountry(nazione))
        {
            System.out.println(v);
        }

        System.out.println("Stampa dei ventilatori piu veloci di 2000");
       for (Ventilatore v : ventilatoreRemoto.printQuickFan())
        {
            System.out.println(v);
        }
  
        in.close();
    }       
    
}
