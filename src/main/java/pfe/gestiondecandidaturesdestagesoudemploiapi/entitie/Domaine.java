package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.*;

@Entity
@Table(name = "domaines")
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    // Getters, setters et autres méthodes spécifiques au domaine
}
