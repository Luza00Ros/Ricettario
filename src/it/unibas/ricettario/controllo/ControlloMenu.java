
package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.persistenza.DAOException;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class ControlloMenu {
    private Action azioneCarica=new AzioneCarica();
    
    private Action azioneEsci = new AzioneEsci();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }
    
    
    
    private class AzioneCarica extends AbstractAction {
        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica file");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
               Archivio archivio = dAOArchivio.carica("");
               Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
               Applicazione.getInstance().getFrame().mostraMessaggio("Carica l'archivio contenente " + archivio.getPietanze().size() + "pietanze");
               Applicazione.getInstance().getControlloPrincipale().getAzioneCercaTipologia().setEnabled(true);
               Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPietanzaSimile().setEnabled(true);
            } catch (DAOException ex) {
              Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio " + ex.getMessage());  
            }
        }
    }
    
    
    
    private class AzioneEsci extends AbstractAction {
        
        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
        
    }
    
}
