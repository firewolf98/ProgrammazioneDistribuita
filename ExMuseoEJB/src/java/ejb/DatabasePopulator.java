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
import javax.inject.Inject;

/**
 *
 * @author lucae
 */
@Singleton
@LocalBean
@DataSourceDefinition(
        className="org.apache.derby.jdbc.EmbeddedDataSource",
        name="jdbc/EsameDS",
        user="APP",
        password="APP",
        databaseName="EsameDB",
        properties={"connectionAttribute=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private MuseoEJB museoejb;
    private Museo m1,m2,m3;
    
    @PostConstruct
    public void createDb() {
        m1=new Museo("Museo di Paestum","Gabriel Zuchtriegel",430000,"Capaccio","Salerno","Campania");
        m2=new Museo("Musei Vaticani","Barbara Jatta",5978804,"Roma","Roma","Lazio");
        m3=new Museo("Galleria degli Uffizi","Eike Dieter Schmidt",1935901,"Firenze","Firenze","Toscana");
        museoejb.createMuseo(m1);
        museoejb.createMuseo(m2);
        museoejb.createMuseo(m3);
    }
    
    @PreDestroy
    public void cleanDb() {
        museoejb.removeMuseo(m1);
        museoejb.removeMuseo(m2);
        museoejb.removeMuseo(m3);
    }
}
