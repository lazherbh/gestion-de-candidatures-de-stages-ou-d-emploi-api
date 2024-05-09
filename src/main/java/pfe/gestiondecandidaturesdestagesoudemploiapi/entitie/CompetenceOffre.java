package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.*;

@Entity
public class CompetenceOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offre_id")
    private offreEntity offre;

    @Column(nullable = false)
    private String nomCompetence;

    @Column(nullable = false)
    private String niveauRequis;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public offreEntity getOffre() {
        return offre;
    }

    public void setOffre(offreEntity offre) {
        this.offre = offre;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public String getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(String niveauRequis) {
        this.niveauRequis = niveauRequis;
    }
}
