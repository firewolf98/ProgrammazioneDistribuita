/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Eugenio
 */
public class BookConsumer {
    public static void main(String[] args) throws NamingException, JMSException {
        Context ctx = new InitialContext();
        LibroEJBRemote libroRemoto = (LibroEJBRemote)ctx.lookup("java:global/EsLibroJMS/LibroEJB!ejb.LibroEJBRemote");
    
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination)ctx.lookup("jms/javaee7/Topic");
        try(JMSContext jmsContext = cf.createContext()){
            while(true)
            {
                System.out.println("Resto in attesa di un messaggio");
                Integer i = jmsContext.createConsumer(topic).receive().getBody(Integer.class);
                Book b = libroRemoto.searchById(i);
                System.out.println("Trovato il libro:  "+b);
                jmsContext.createProducer().send(topic, "Messaggio ricevuto");
                Float p = jmsContext.createConsumer(topic).receive().getBody(Float.class);
                b.setPrezzo(p);
                b = libroRemoto.updateBook(b);
                System.out.println("Il libro è stato aggiornato, il nuovo libro è il seguente: "+b);
            }
            
        }
    }
}
