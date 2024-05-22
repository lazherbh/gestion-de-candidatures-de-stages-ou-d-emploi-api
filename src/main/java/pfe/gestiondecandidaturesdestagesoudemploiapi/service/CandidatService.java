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
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private CandidatureRepository candidatureRepository;

    // Méthode postuler
    public void postuler(Long candidatId, Long offreId) {
        Candidat candidat = candidatRepository.findById(candidatId).orElseThrow();
        Offre offre = offreRepository.findById(offreId).orElseThrow();

        // Vérifier l'éligibilité du candidat et l'existence d'une candidature existante

        Candidature candidature = new Candidature();
        candidature.setCandidat(candidat);
        candidature.setOffre(offre);
        candidature.setStatut("En cours");
        candidature.setDatePostulation(LocalDate.now());

        // Calculer le pourcentage d'adéquation du candidat

        candidatureRepository.save(candidature);
    }

    // Méthode consulterHistoriqueCandidature
    public List<Candidature> consulterHistoriqueCandidature(Long candidatId) {
        Candidat candidat = candidatRepository.findById(candidatId).orElseThrow();
        List<Candidature> candidatures = candidatureRepository.findByCandidat(candidat);

        // Enrichir les candidatures avec des informations détaillées

        return candidatures;
    }


}

