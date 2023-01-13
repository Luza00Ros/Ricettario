
package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;


public class Pietanza {
    
    private String nome;
    private double costo;
    private String categoria;
    private List<Ingrediente> ingredienti=new ArrayList<Ingrediente>();

    public Pietanza(String nome, double costo, String categoria) {
        this.nome = nome;
        this.costo = costo;
        this.categoria = categoria;
    }

    

    

    public String getNome() {
        return nome;
    }

    public double getCosto() {
        return costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public void aggiungiIngrediente(Ingrediente e) {
         ingredienti.add(e);
    }
    
    public double getKcal() {
        double somma = 0.0;
        for (Ingrediente ingrediente : ingredienti){
            somma+=ingrediente.getKcal();
        }
        return somma;
    }
    
    public boolean contieneAllergeni() {
        for (Ingrediente ingrediente : ingredienti) {
            if(ingrediente.isAllergene()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pietanza{");
        sb.append("nome=").append(nome);
        sb.append(", costo=").append(costo);
        sb.append(", categoria=").append(categoria);
        sb.append(", ingredienti=").append(ingredienti);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
