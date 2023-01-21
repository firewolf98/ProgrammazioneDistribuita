/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Eugenio
 */
@Remote
public interface PropostaViaggiEJBRemote {
    public void createProposta(PropostaViaggio viaggio);
    public void deleteProposta(PropostaViaggio viaggio);
    public PropostaViaggio updateProposta(PropostaViaggio viaggio);
    public PropostaViaggio findViaggioById(int id);
    public List<PropostaViaggio> findViaggioByDestinazione(String destinazione);
    public List<PropostaViaggio> findViaggioByCategoria(String categoria);
    public List<PropostaViaggio> findAllViaggi();
    
}
