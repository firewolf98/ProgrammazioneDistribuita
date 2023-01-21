/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Eugenio
 */
@Singleton
@Startup
@DataSourceDefinition(
className ="org.apache.derby.jdbc.EmbeddedDataSource",
name ="java:app/EsameDS",
user ="app",
password ="app",
databaseName ="EsameDB",
properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private UnescoEJB unescoEJB;
    private Unesco u1,u2,u3,u4;
    
    @PostConstruct
    public void createDb()
    {
        u1 = new Unesco("Isole Eolie", 2000, "Naturale", "Sicilia");
        u2 = new Unesco("Costiera Amalfitana", 1997, "Culturale", "Campania");
        u3 = new Unesco("Ville e giardini medicei in Toscana", 2013, "Misto", "Tostana");
        u4 = new Unesco("Parco Nazionale de Cilento e Vallo di Diano", 1998, "Culturale", "Campania");
    
        unescoEJB.createSitoUnesco(u1);
        unescoEJB.createSitoUnesco(u2);
        unescoEJB.createSitoUnesco(u3);
        unescoEJB.createSitoUnesco(u4);
    }
    
    @PreDestroy
    public void cleandDB()
    {
        unescoEJB.removeSitoUnesco(u1);
        unescoEJB.removeSitoUnesco(u2);
        unescoEJB.removeSitoUnesco(u3);
        unescoEJB.removeSitoUnesco(u4);
    }
    
    

}
