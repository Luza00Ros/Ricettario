/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;

/**
 *
 * @author lucia
 */
public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;
    
}
