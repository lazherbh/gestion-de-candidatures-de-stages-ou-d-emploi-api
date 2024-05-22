package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "candidatures")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "offre_id")
    private Offre offre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

    @Column(nullable = false)
    private String statut; // (en_cours/entretien_programme/refuse/entretien_technique_confirme/entretien_RH_confirme/accepte)

    @Column(nullable = false)
    private LocalDate datePostulation;

    @Column
    private LocalDate dateEntretien;

    @Column
    private String motifRefus;

    @MapKey(name = "competence")
    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "niveau_acquis")
    private Map<CompetenceOffre, String> niveauxAcquis; // (connaissance_theorique/connaissance_pratique/debutant/intermediaire/maitrise/aucune_competence)

    @Column(nullable = false)
    private float pourcentageAdequationGlobale;

    // Getters, setters, et autres méthodes spécifiques à la candidature

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDate getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(LocalDate datePostulation) {
        this.datePostulation = datePostulation;
    }

    public LocalDate getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(LocalDate dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public String getMotifRefus() {
        return motifRefus;
    }

    public void setMotifRefus(String motifRefus) {
        this.motifRefus = motifRefus;
    }

    public Map<CompetenceOffre, String> getNiveauxAcquis() {
        return niveauxAcquis;
    }

    public void setNiveauxAcquis(Map<CompetenceOffre, String> niveauxAcquis) {
        this.niveauxAcquis = niveauxAcquis;
    }

    public float getPourcentageAdequationGlobale() {
        return pourcentageAdequationGlobale;
    }

    public void setPourcentageAdequationGlobale(float pourcentageAdequationGlobale) {
        this.pourcentageAdequationGlobale = pourcentageAdequationGlobale;
    }
}
