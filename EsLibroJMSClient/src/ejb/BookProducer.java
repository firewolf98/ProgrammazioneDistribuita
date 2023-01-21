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
public class BookProducer {
    public static void main(String[] args) throws NamingException, JMSException {
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination)ctx.lookup("jms/javaee7/Topic");
        Integer id = 1;
        Float price = 30.5f;
        try(JMSContext jmsContext = cf.createContext();){
            System.out.println("Invio messaggio");
            jmsContext.createProducer().send(topic, id);
            System.out.println(jmsContext.createConsumer(topic).receive().getBody(String.class));
            jmsContext.createProducer().send(topic, price);
        }
    }
    
}
