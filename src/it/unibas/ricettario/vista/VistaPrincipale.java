
package it.unibas.ricettario.vista;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import java.util.List;



public class VistaPrincipale extends javax.swing.JPanel {

    
    public void inizializza() {
        initComponents();
        inizializzaComponenti();
        inizializzaAzioni();
        this.jTable1.setModel(new ModelloTabellaPietanze());
        
    }
    
    private void inizializzaComponenti() {
        this.comboCategoria.removeAllItems();
        this.comboCategoria.addItem("");
        this.comboCategoria.addItem(Costanti.ANTIPASTO);
        this.comboCategoria.addItem(Costanti.PRIMO);
        this.comboCategoria.addItem(Costanti.SECONDO);
        this.comboCategoria.addItem(Costanti.DESSERT);
    }
    
    private void inizializzaAzioni() {
     this.bottoneCercaCategoria.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaTipologia());
     this.bottoneCercaSimile.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPietanzaSimile());   
    }
    
    public String getComboCategoria() {
        return (String) comboCategoria.getSelectedItem();
    }
    
    public int getRigaSelezionata() {
        return this.jTable1.getSelectedRow();
        
    }
    
    public void aggiornaTabella() {
      List <Pietanza>  listaPietanze = (List <Pietanza>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
      ModelloTabellaPietanze modelloTabella = (ModelloTabellaPietanze) this.jTable1.getModel();
      modelloTabella.setPietanze(listaPietanze);
      modelloTabella.aggiornaContenuto();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        bottoneCercaCategoria = new javax.swing.JButton();
        tabellaPietanze = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bottoneCercaSimile = new javax.swing.JButton();

        jLabel1.setText("Categoria: ");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCercaCategoria.setText("jButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabellaPietanze.setViewportView(jTable1);

        bottoneCercaSimile.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabellaPietanze, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(bottoneCercaCategoria))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneCercaSimile)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCategoria)
                    .addComponent(bottoneCercaCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabellaPietanze, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneCercaSimile)
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaCategoria;
    private javax.swing.JButton bottoneCercaSimile;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane tabellaPietanze;
    // End of variables declaration//GEN-END:variables

    
}
