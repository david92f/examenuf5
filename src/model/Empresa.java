/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author David Fernandez
 */
public class Empresa {

    private String nomEmpresa;
    private HashMap<Seu, ArrayList<Cotxe>> seus = new HashMap<>();

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public Empresa() {
        String nomSeu = "Tarragona";
        Seu seu = new Seu(nomSeu);
//        afegirSeu(nomSeu);
        afegirCotxeASeu(seu, new Cotxe("1234", "Peugeot 206"));
        afegirCotxeASeu(seu, new Cotxe("1232", "Seat Ibiza"));
    }

    public List<Seu> getSeus() {
//        Set<Seu> keySet = seus.keySet();
//        List<Seu> s = new ArrayList<>();
//        for (Seu seu : keySet) {
//            s.add(seu);
//        }
        return new ArrayList<>(seus.keySet());
    }

    public List<Cotxe> getCotxesSeu(Seu seu) {
        return seus.get(seu);
    }

    public void afegirSeu(String nomSeu) {
        boolean troba = false;
//        Seu s = null;
        for (Seu seu : getSeus()) {
            if (seu.getNomSeu().equals(nomSeu)) {
                troba = true;
            }

        }
        // si no troba considencia crees la seu
        if (!troba) {
            seus.put(new Seu(nomSeu), new ArrayList<>());
        }
    }

    public Seu getSeu(String matricula) {
        Seu s = null;
        for (Seu seu : getSeus()) {
            // guardo si troba una considencia
            if (getCotxe(seu, matricula) != null) {
                s = seu;
            }
        }
        return s;
    }

    public Cotxe getCotxe(Seu seu, String matricula) {
        Cotxe cotxe = null;
        for (Seu seu1 : getSeus()) {
            if (seu.equals(seu1)) {
                // list cotxe
                for (Cotxe c : seus.get(seu1)) {
                    if (c.getMatricula().equals(matricula)) {
                        cotxe = c;
                    }
                }
            }
        }
        return cotxe;
    }

    public void afegirCotxeASeu(Seu seu, Cotxe cotxe) {
        ArrayList<Cotxe> list;
        if (seus.get(seu) == null) {
            list = new ArrayList<>();
            
        } else {
            list = seus.get(seu);
            
        }
        
        list.add(cotxe);

        if (seus.containsKey(seu)) {
            seus.replace(seu, list);
        }else{
            seus.put(seu, list);
        }
    }
}
