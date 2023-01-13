
package it.unibas.ricettario.vista;

import it.unibas.ricettario.modello.Pietanza;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class ModelloTabellaPietanze extends AbstractTableModel {
    private List<Pietanza> pietanze = new ArrayList<>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }

    public void setPietanze(List<Pietanza> pietanze) {
        this.pietanze = pietanze;
    }

    
    @Override
    public int getRowCount() {
        return this.pietanze.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pietanza pietanza = this.pietanze.get(rowIndex);
        if (columnIndex == 0) {
            return pietanza.getNome();
        } else if(columnIndex == 1) {
            return pietanza.getIngredienti().size();
        } else if (columnIndex == 2) {
            return pietanza.contieneAllergeni();
        }
      return "";
    }

    @Override
    public String getColumnName(int column) {
       if (column == 0) {
            return "Nome";
        } else if(column == 1) {
            return "Numero ingredienti";
        } else if (column == 2) {
            return "Contiene allergeni ";
        }
      return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
          if (columnIndex == 1) {
            return Integer.class;
        } else if(columnIndex == 2) {
            return Boolean.class;
        } 
      return String.class;
    }
    
    
    
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }
    
    
}
