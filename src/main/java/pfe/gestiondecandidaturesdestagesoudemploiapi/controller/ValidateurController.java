package pfe.gestiondecandidaturesdestagesoudemploiapi.controller;


import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Candidature;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;
import pfe.gestiondecandidaturesdestagesoudemploiapi.service.ValidateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validateur") // Define base path for all controller methods
public class ValidateurController {

    @Autowired
    private ValidateurService validateurService;

    // Consulter Candidatures Assignees
    @GetMapping("/candidatures/assignees")
    public ResponseEntity<List<Candidature>> consulterCandidaturesAssignees() {
        List<Candidature> candidatures = validateurService.consulterCandidaturesAssignees();
        return ResponseEntity.ok(candidatures);
    }

    // Remplir Fiche Candidat
    @PostMapping("/candidats/{candidatId}/fiche")
    public ResponseEntity<Void> remplirFicheCandidat(@PathVariable Long candidatId, @RequestBody Utilisateur candidat) {
        validateurService.remplirFicheCandidat(candidat);
        return ResponseEntity.noContent().build();
    }

    // Valider Candidature
    @PutMapping("/candidatures/{candidatureId}/valider")
    public ResponseEntity<Void> validerCandidature(@PathVariable Candidature candidature) {
        validateurService.validerCandidature(candidature);
        return ResponseEntity.noContent().build();
    }

    // Consulter Historique Candidatures
    @GetMapping("/candidatures/historique")
    public ResponseEntity<List<Candidature>> consulterHistoriqueCandidatures() {
        List<Candidature> candidatures = validateurService.consulterHistoriqueCandidatures();
        return ResponseEntity.ok(candidatures);
    }
}
