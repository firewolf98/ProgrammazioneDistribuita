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

public class DatabasePopulator {
    @Inject
    private PropostaViaggiEJB propostaViaggiEJB;
    private PropostaViaggio v1,v2,v3;
    
    @PostConstruct
    public void createDB(){
        v1 = new PropostaViaggio("Mare", "Seychelles", 500f, 10, 10);
        v2 = new PropostaViaggio("Mare", "Corfù", 200f, 0, 20);
        v3 = new PropostaViaggio("Montagna", "Cortina", 700f, 20, 30);
        propostaViaggiEJB.createProposta(v1);
        propostaViaggiEJB.createProposta(v2);
        propostaViaggiEJB.createProposta(v3);
    }
    @PreDestroy
    public void cleanDB(){
        propostaViaggiEJB.deleteProposta(v1);
        propostaViaggiEJB.deleteProposta(v2);
        propostaViaggiEJB.deleteProposta(v3);
    }
}
