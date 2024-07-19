package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "domaines")
@Getter
@Setter
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Override
    public String toString() {
        return "Domaine{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
// Getters, setters et autres méthodes spécifiques au domaine
}
