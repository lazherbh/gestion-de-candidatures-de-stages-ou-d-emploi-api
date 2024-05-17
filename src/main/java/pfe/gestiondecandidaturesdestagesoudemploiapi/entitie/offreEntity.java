package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class offreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Integer periodeEnMois;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

    @Column(nullable = false)
    private String mode;

    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL)
    private List<CompetenceOffre> competencesOffres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsable_rh_id")
    private ResponsableRH responsableRH;

    // Getters and setters
    public ResponsableRH getResponsableRH() {
        return responsableRH;
    }

    public void setResponsableRH(ResponsableRH responsableRH) {
        this.responsableRH = responsableRH;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getPeriodeEnMois() {
        return periodeEnMois;
    }

    public void setPeriodeEnMois(Integer periodeEnMois) {
        this.periodeEnMois = periodeEnMois;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<CompetenceOffre> getCompetencesOffres() {
        return competencesOffres;
    }

    public void setCompetencesOffres(List<CompetenceOffre> competencesOffres) {
        this.competencesOffres = competencesOffres;
    }
}
