package pfe.gestiondecandidaturesdestagesoudemploiapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Candidat;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Candidature;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Offre;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.CandidatRepository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.CandidatureRepository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.OffreRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResponsableRHService {

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private CandidatureRepository candidatureRepository;

    // Méthode créerOffre
    public void creerOffre(Offre offre) {
        
        offreRepository.save(offre);
    }

    // Méthode modifierOffre
    public void modifierOffre(Offre offre) {
        
        offreRepository.save(offre);
    }

    // Méthode archiverOffre
    public void archiverOffre(Long offreId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();
        offre.setArchive(true);
        offreRepository.save(offre);
    }

    // Méthode listerOffres
    public List<Offre> listerOffres() {
        
        return offreRepository.findAll();
    }

    // Méthode gérerCandidatures
    public void créerCandidature(Long offreId, Long candidatId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();
        Candidat candidat = candidatRepository.findById(candidatId).orElseThrow();

        // Vérifier si le candidat est éligible pour l'offre
        // ...

        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat);
        candidature.setOffre(offre);
        candidature.setStatut("En cours");
        candidature.setDatePostulation(LocalDate.now());

        // Calculer le pourcentage d'adéquation du candidat
        // ...

        candidatureRepository.save(candidature);
    }

    public void modifierCandidature(Long candidatureId, Candidature candidature) {
        Candidature candidatureExistante = candidatureRepository.findById(candidatureId).orElseThrow();

        // Valider les modifications apportées à la candidature
        // ...

        candidatureExistante.setStatut(candidature.getStatut());
        candidatureExistante.setDateEntretien(candidature.getDateEntretien());
        candidatureExistante.setMotifRefus(candidature.getMotifRefus());
        candidatureExistante.setNiveauxAcquis(candidature.getNiveauxAcquis());
        candidatureExistante.setPourcentageAdequationGlobale(candidature.getPourcentageAdequationGlobale());

        candidatureRepository.save(candidatureExistante);
    }

    public void supprimerCandidature(Long candidatureId) {
        candidatureRepository.deleteById(candidatureId);
    }

    public Candidature consulterCandidatureDetails(Long candidatureId) {
        Candidature candidature = candidatureRepository.findById(candidatureId).orElseThrow();

        // Enrichir la candidature avec des informations supplémentaires (candidat, offre, ...)
        // ...

        return candidature;
    }

    public List<Candidature> consulterCandidaturesParOffre(Long offreId) {
        Offre offre = offreRepository.findById(offreId).orElseThrow();
        List<Candidature> candidatures = candidatureRepository.findByOffre(offre);

        // Enrichir les candidatures avec des informations supplémentaires (candidat, statut, ...)
        for (Candidature candidature : candidatures) {
            Candidat candidat = candidatRepository.findById(candidature.getCandidat().getId()).orElseThrow();
            candidature.setCandidat(candidat);

            // Enrichir avec d'autres informations selon vos besoins (statut, date entretien, ...)
        }

        return candidatures;
    }



    // ... autres méthodes du service ResponsableRH ...
}

