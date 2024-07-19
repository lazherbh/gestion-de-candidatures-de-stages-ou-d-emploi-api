package pfe.gestiondecandidaturesdestagesoudemploiapi.controller;

import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Role;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;
import pfe.gestiondecandidaturesdestagesoudemploiapi.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateur") // Define base path for all controller methods
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    // CRUD Utilisateur
    @PostMapping("/role")
    public ResponseEntity<Role> creerRole( Role role) {
        administrateurService.creerRole(role);
        return ResponseEntity.ok(role);
    }

    @PostMapping("/utilisateurs")
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        administrateurService.creerUtilisateur(utilisateur);
        return ResponseEntity.ok(utilisateur);
    }

    @PutMapping("/utilisateurs/{utilisateurId}")
    public ResponseEntity<Void> modifierUtilisateur(@PathVariable Long utilisateurId, @RequestBody Utilisateur utilisateur) {
        administrateurService.modifierUtilisateur(utilisateur);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/utilisateurs/{utilisateurId}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long utilisateurId) {
        administrateurService.supprimerUtilisateur(utilisateurId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateur>> listerUtilisateurs() {
        List<Utilisateur> utilisateurs = administrateurService.listerUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    // Afficher Statistiques

   /* @GetMapping("/statistiques/utilisateurs")
    public ResponseEntity<?> afficherStatistiquesUtilisateurs() {
        // Implement logic to generate and return statistical data about users
        // ...
        return ResponseEntity.ok(); // Replace with actual response data
    }*/
}
