/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author David Fernandez
 */
public class Seu {
    
    private String nomSeu;

    public Seu(String nomSeu) {
        this.nomSeu = nomSeu;
    }

    public String getNomSeu() {
        return nomSeu;
    }

    public void setNomSeu(String nomSeu) {
        this.nomSeu = nomSeu;
    }

    @Override
    public String toString() {
        return "Nom de la Seu: " + nomSeu;
    }
    
}
