package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "candidats")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("CANDIDAT")
@Getter
@Setter
public class Candidat extends Utilisateur{

    @Column(nullable = false)
    private String telephone;

    public Candidat(String nom, String prenom, String email, String motDePasse, String telephone) {
        super(nom, prenom, email, motDePasse);
        this.telephone = telephone;
    }


}
