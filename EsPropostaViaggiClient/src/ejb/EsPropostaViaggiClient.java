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
public class EsPropostaViaggiClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        PropostaViaggiEJBRemote propostaViaggioRemoto = (PropostaViaggiEJBRemote) 
                ctx.lookup("java:global/EsPropostaViaggiEJB/PropostaViaggiEJB!ejb.PropostaViaggiEJBRemote");
        System.out.println("Stamapa di tutte le proposte di viaggio presenti nel database");
        for(PropostaViaggio v : propostaViaggioRemoto.findAllViaggi())
        {
            System.out.println(v);
        }
        System.out.println("inserimento viaggio");
        PropostaViaggio v = new PropostaViaggio("Mare", "Pontecagnano", 150.50f, 10, 230);
        propostaViaggioRemoto.createProposta(v);
        System.out.println("Ricerca per id");
        System.out.println(propostaViaggioRemoto.findViaggioById(1));
        System.out.println("Ricerca per destinazione (Pontecagano)");
        for (PropostaViaggio v2 : propostaViaggioRemoto.findViaggioByDestinazione("Pontecagnano"))
        {
            System.out.println(v2);
        }
        System.out.println("Ricerca per categoria (Mare)");
        for (PropostaViaggio v2 : propostaViaggioRemoto.findViaggioByCategoria("Mare"))
        {
            System.out.println(v2);
        }
        
    }
    
}
