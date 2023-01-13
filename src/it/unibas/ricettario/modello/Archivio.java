/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucia
 */
public class Archivio {
    private List<Pietanza> pietanze =new ArrayList<Pietanza>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }
   
    public void aggiungiPietanza (Pietanza pietanza) {
        this.pietanze.add(pietanza);
    }
    
    public List<Pietanza> cercaPietanzaPerCategoria(String categoria){
    List <Pietanza> listaFiltrata= new ArrayList <Pietanza>();
        for (Pietanza pietanza : this.pietanze) {
           if (pietanza.getCategoria().equals(categoria)){
               listaFiltrata.add(pietanza);
           }
        }
    return listaFiltrata;
    }
    
    public Pietanza cercaPietanzaSimile(Pietanza pietanza) {
        Pietanza pietanzaSimile = null;
        for(Pietanza altraPietanza : pietanze){
            if(!altraPietanza.getNome().equals(pietanza.getNome())) {
                if (pietanzaSimile == null || (Math.abs(altraPietanza.getKcal() - pietanza.getKcal()) < Math.abs(pietanzaSimile.getKcal() - pietanza.getKcal()))) {
                    pietanzaSimile = altraPietanza;
                }
            }
        }
        return pietanzaSimile;
    }

    public Object cercaPietanzePerCategoria(String DESSERT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
