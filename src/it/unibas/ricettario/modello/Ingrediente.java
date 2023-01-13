/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.ricettario.modello;

/**
 *
 * @author lucia
 */
public class Ingrediente {
    
    private String nome;
    private int quantita;
    private boolean allergene;
    private int kcl100gr;

    public Ingrediente(String nome, int quantita, boolean allergene, int kcl100gr) {
        this.nome = nome;
        this.quantita = quantita;
        this.allergene = allergene;
        this.kcl100gr = kcl100gr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public boolean isAllergene() {
        return allergene;
    }

    public void setAllergene(boolean allergene) {
        this.allergene = allergene;
    }

    public int getKcl100gr() {
        return kcl100gr;
    }
    
    public double getKcal(){
        return this.quantita * this.kcl100gr / 100.0;
    }

    public void setKcl100gr(int kcl100gr) {
        this.kcl100gr = kcl100gr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ingrediente{");
        sb.append("nome=").append(nome);
        sb.append(", quantita=").append(quantita);
        sb.append(", allergene=").append(allergene);
        sb.append(", kcl100gr=").append(kcl100gr);
        sb.append('}');
        return sb.toString();
    }
    
    
}
