package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {


	    
private String nom;
    
    private List<DemandeFormation> demandes= new ArrayList<>();
    
    

    public Employee(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<DemandeFormation> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<DemandeFormation> demandes) {
        this.demandes = demandes;
    }
    
    
    public void demanderFormation(DemandeFormation demande) {
        demandes.add(demande);
    }
}
