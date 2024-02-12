package model;

public class Manager extends Employee{

	 public Manager(String nom) {
	        super(nom);
	    }

	    @Override
	    public void demanderFormation(DemandeFormation demande) {
	        demande.setStatut(DemandeFormation.ACCORDE);;
	        super.demanderFormation(demande);
	    }
}
