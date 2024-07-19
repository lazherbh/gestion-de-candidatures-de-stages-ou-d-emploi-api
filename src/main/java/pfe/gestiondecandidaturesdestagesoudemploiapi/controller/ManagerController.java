package pfe.gestiondecandidaturesdestagesoudemploiapi.controller;

import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.CompetenceOffre;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Offre;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Domaine;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Candidature;
import pfe.gestiondecandidaturesdestagesoudemploiapi.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager") // Define base path for all controller methods
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    // Valider Offre (POST)
    @PostMapping("/offres/valider")
    public ResponseEntity<Void> validerOffre(@RequestBody Offre offre) {
        managerService.validerOffre(offre);
        return ResponseEntity.noContent().build();
    }

    // CRUD Domaines
    @PostMapping("/domaines")
    public ResponseEntity<Domaine> creerDomaine(@RequestBody Domaine domaine) {
        managerService.creerDomaine(domaine);
        return ResponseEntity.ok(domaine);
    }

    @PutMapping("/domaines/{domaineId}")
    public ResponseEntity<Void> modifierDomaine(@PathVariable Long domaineId, @RequestBody Domaine domaine) {
        managerService.modifierDomaine(domaine);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/domaines/{domaineId}")
    public ResponseEntity<Void> supprimerDomaine(@PathVariable Long domaineId) {
        managerService.supprimerDomaine(domaineId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/domaines")
    public ResponseEntity<List<Domaine>> listerDomaines() {
        List<Domaine> domaines = managerService.listerDomaines();
        return ResponseEntity.ok(domaines);
    }

    // CRUD Competences
    @PostMapping("/competences")
    public ResponseEntity<CompetenceOffre> creerCompetence( CompetenceOffre competence) {
        managerService.creerCompetence(competence);
        return ResponseEntity.ok(competence);
    }

    @PutMapping("/competences/{competenceId}")
    public ResponseEntity<Void> modifierCompetence(@PathVariable Long competenceId, @RequestBody CompetenceOffre competence) {
        managerService.modifierCompetence(competence);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/competences/{competenceId}")
    public ResponseEntity<Void> supprimerCompetence(@PathVariable Long competenceId) {
        managerService.supprimerCompetence(competenceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/competences")
    public ResponseEntity<List<CompetenceOffre>> listerCompetences() {
        List<CompetenceOffre> competences = managerService.listerCompetences();
        return ResponseEntity.ok(competences);
    }

    // Consulter Historique Offres
    @GetMapping("/offres/historique")
    public ResponseEntity<List<Offre>> consulterHistoriqueOffres() {
        List<Offre> offres = managerService.consulterHistoriqueOffres();
        return ResponseEntity.ok(offres);
    }

    // Consulter Historique Candidatures par Offre
    @GetMapping("/offres/{offreId}/candidatures/historique")
    public ResponseEntity<List<Candidature>> consulterHistoriqueCandidatures(@PathVariable Long offreId) {
        List<Candidature> candidatures = managerService.consulterHistoriqueCandidatures(offreId);
        return ResponseEntity.ok(candidatures);
    }
}
