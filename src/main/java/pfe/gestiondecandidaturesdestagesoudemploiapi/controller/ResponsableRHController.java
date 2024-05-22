package pfe.gestiondecandidaturesdestagesoudemploiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Candidature;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Offre;
import pfe.gestiondecandidaturesdestagesoudemploiapi.service.ResponsableRHService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/responsable-rh/offres")
public class ResponsableRHController {

    @Autowired
    private ResponsableRHService responsableRHService;

    // Endpoint pour lister toutes les offres
    @GetMapping
    public ResponseEntity<List<Offre>> listerOffres() {
        List<Offre> offres = responsableRHService.listerOffres();
        return ResponseEntity.ok(offres);
    }

    // Endpoint pour archiver une offre (à adapter selon votre implémentation)
    @PutMapping("/{offreId}/archiver")
    public ResponseEntity archiverOffre(@PathVariable Long offreId) {
        responsableRHService.archiverOffre(offreId);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour gérer les candidatures d'une offre spécifique
    @RequestMapping(value = "/{offreId}/candidatures", method = RequestMethod.GET)
    public ResponseEntity<List<Candidature>> consulterCandidaturesOffre(@PathVariable Long offreId) {
        List<Candidature> candidatures = responsableRHService.consulterCandidaturesParOffre(offreId); // Assuming this method exists in ResponsableRHService
        return ResponseEntity.ok(candidatures);
    }

    // Endpoint pour créer une candidature (requête POST avec body contenant l'ID du candidat)
    @PostMapping("/{offreId}/candidatures/creer")
    public ResponseEntity creerCandidature(@PathVariable Long offreId, @Valid @RequestBody Long candidatId) {
        responsableRHService.créerCandidature(offreId, candidatId);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour modifier une candidature (requête PUT avec body contenant la candidature modifiée)
    @PutMapping("/{offreId}/candidatures/{candidatureId}")
    public ResponseEntity modifierCandidature(@PathVariable Long offreId, @PathVariable Long candidatureId, @Valid @RequestBody Candidature candidature) {
        responsableRHService.modifierCandidature(candidatureId, candidature);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour supprimer une candidature
    @DeleteMapping("/{offreId}/candidatures/{candidatureId}")
    public ResponseEntity supprimerCandidature(@PathVariable Long offreId, @PathVariable Long candidatureId) {
        responsableRHService.supprimerCandidature(candidatureId);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour consulter les détails d'une candidature
    @GetMapping("/{offreId}/candidatures/{candidatureId}")
    public ResponseEntity<Candidature> consulterDetailsCandidature(@PathVariable Long offreId, @PathVariable Long candidatureId) {
        Candidature candidature = responsableRHService.consulterCandidatureDetails(candidatureId);
        return ResponseEntity.ok(candidature);
    }

    // ... autres méthodes du contrôleur ResponsableRH ...

}

