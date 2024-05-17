package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.*;

@Entity
@Table(name = "responsables_rh")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("RESPONSABLE_RH")
public class ResponsableRH extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public ResponsableRH() {
        super(); // Appel au constructeur par défaut de la classe Utilisateur
    }

    public ResponsableRH(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse); // Appel au constructeur avec arguments de la classe Utilisateur
    }

    // Getters, setters et autres méthodes spécifiques au responsable RH

}
