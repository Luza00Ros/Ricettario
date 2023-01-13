
package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Ingrediente;
import it.unibas.ricettario.modello.Pietanza;


public class DAOArchivioMock implements IDAOArchivio {
    
    @Override
    public Archivio carica (String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();
        
        Pietanza pietanzaPastaAlleNociPietanza = new Pietanza("Pasta alle noci", 10.0, Costanti.PRIMO);
        pietanzaPastaAlleNociPietanza.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAlleNociPietanza.aggiungiIngrediente(new Ingrediente("Noci", 30, true, 700));
        pietanzaPastaAlleNociPietanza.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAlleNociPietanza);
        Pietanza pietanzaPastaAiGamberi = new Pietanza( "Pasta ai Gamberi",12.0, Costanti.PRIMO);
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Pasta",80, false, 400));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Gamberi",100, false, 120));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Panna",100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAiGamberi);
        Pietanza pietanzaPastaEPanna = new Pietanza("Pasta e Panna", 8.0, Costanti.PRIMO);
        pietanzaPastaEPanna.aggiungiIngrediente(new Ingrediente("Pasta",80, false, 400));
        pietanzaPastaEPanna.aggiungiIngrediente(new Ingrediente("Panna",150, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaEPanna);
        Pietanza pietanzaGamberoni = new Pietanza("Gamberi alla griglia", 12.0, Costanti.SECONDO);
        pietanzaGamberoni.aggiungiIngrediente(new Ingrediente("Gamberi",200, false, 120));
        archivio.aggiungiPietanza(pietanzaGamberoni);
        
        return archivio;
    }
    
}
