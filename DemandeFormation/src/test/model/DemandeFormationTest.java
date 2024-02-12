package test.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DemandeFormation;
import model.Employee;
import model.Manager;

class DemandeFormationTest {

	private Manager manager;
    private Employee employee;
    
    @BeforeEach
    void ajouterFormation() {
        manager = new Manager("Bob");
        employee = new Employee("Bill");
        DemandeFormation demande = new DemandeFormation();
        DemandeFormation demande2 = new DemandeFormation();
        DemandeFormation demande3 = new DemandeFormation();
        DemandeFormation demande4 = new DemandeFormation();
        
        manager.demanderFormation(demande);
        manager.demanderFormation(demande2);
        
        employee.demanderFormation(demande3);
        employee.demanderFormation(demande4);
    }

    @Test
    void employee_Doit_Avoir_Formations_enAttente() {
        
        List<DemandeFormation>  demandes = employee.getDemandes();
        assertTrue(demandes.stream().allMatch(d -> DemandeFormation.ATTENTE.equals(d.getStatut())));
    }
    
    @Test
    void manager_Doit_Avoir_Formations_enAttente() {
        
        List<DemandeFormation>  demandes = manager.getDemandes();
        assertTrue(demandes.stream().allMatch(d -> DemandeFormation.ACCORDE.equals(d.getStatut())));
    }

}
