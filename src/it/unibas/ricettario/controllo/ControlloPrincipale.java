
package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Modello;
import it.unibas.ricettario.modello.Pietanza;
import it.unibas.ricettario.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ControlloPrincipale {
    
    private Action azioneCercaTipologia = new AzioneCercaTipologia();
    private Action azioneCercaPietanzaSimile = new AzioneCercaPietanzaSimile();

    public Action getAzioneCercaTipologia() {
        return azioneCercaTipologia;
    }
    public Action getAzioneCercaPietanzaSimile() {
        return azioneCercaPietanzaSimile;
    }

    
    private class AzioneCercaTipologia extends AbstractAction {
        
        private Logger logger = LoggerFactory.getLogger(AzioneCercaTipologia.class);
        
        public AzioneCercaTipologia() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca tutte le pietanze della tipologia scelta");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
            this.setEnabled(false);
        }
                

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String categoria = vistaPrincipale.getComboCategoria();
            if(categoria.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Selezione prima una categoria di pietanze");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List <Pietanza> pietanzeFiltrate = archivio.cercaPietanzaPerCategoria(categoria);
            logger.debug("Lista filtrata" + pietanzeFiltrate.size());
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, pietanzeFiltrate);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
        
    }
    
    private class AzioneCercaPietanzaSimile extends AbstractAction {
        private Logger logger = LoggerFactory.getLogger(AzioneCercaTipologia.class);
        
        public AzioneCercaPietanzaSimile() {
            this.putValue(NAME, "Cerca pietanza simile ");
            this.putValue(SHORT_DESCRIPTION, "Cerca la pietanza più simile nelle calorie");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
            this.setEnabled(false);
        }
                

        @Override
        public void actionPerformed(ActionEvent e) {
           VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
           int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
           if (rigaSelezionata == -1) {
               Applicazione.getInstance().getFrame().mostraMessaggio("Devi selezionare prima una riga");
               return;
           }
           Modello modello = Applicazione.getInstance().getModello();
           List<Pietanza> listaFiltrata = (List <Pietanza>) modello.getBean(Costanti.LISTA_FILTRATA);
           Pietanza pietanzaSelezionata = listaFiltrata.get(rigaSelezionata);
           Archivio archivio = (Archivio) modello.getBean(Costanti.ARCHIVIO);
           Pietanza pietanzaSimile = archivio.cercaPietanzaSimile(pietanzaSelezionata);
           if (pietanzaSimile == null) {
               Applicazione.getInstance().getFrame().mostraMessaggioErrore("Non esiste alcuna pietanza simile");
               return;
           }
           Applicazione.getInstance().getFrame().mostraMessaggio("La pietanza piu' simile a " + pietanzaSelezionata.getNome() + " e' " + pietanzaSimile.getNome());
           
        }
        
    }
        
 }
