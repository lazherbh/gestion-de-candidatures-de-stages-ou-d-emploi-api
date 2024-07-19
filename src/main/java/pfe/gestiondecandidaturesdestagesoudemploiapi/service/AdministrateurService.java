package pfe.gestiondecandidaturesdestagesoudemploiapi.service;

import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Offre;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Role;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.OffreRepository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.RoleRepository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdministrateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private OffreRepository offreRepository;


    public void creerRole(Role role) {
        roleRepository.save(role);
    }

    // CRUD Utilisateur

    public void creerUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public void supprimerUtilisateur(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
    }

    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Afficher Statistiques
    public Map<String, Object> afficherStatistique() {
        Map<String, Object> statistiques = new HashMap<>();

        // Statistiques Offres Publiées par Mois/Année
        statistiques.put("offresParMoisAnnee", getOffresParMoisAnneeStatistiques());

        // Statistiques Offres Publiées par Responsable/Assistant RH
        statistiques.put("offresParRole", getOffresParRoleStatistiques());

        return statistiques;
    }

    // Statistiques Offres Publiées par Mois/Année
    private Map<String, Integer> getOffresParMoisAnneeStatistiques() {
        List<Offre> offres = offreRepository.findAll();

        Map<String, Integer> offresParMoisAnnee = new HashMap<>();

        for (Offre offre : offres) {
            LocalDate datePublication = offre.getDatePublication();
            String moisAnnee = datePublication.getMonth().toString() + " " + datePublication.getYear();

            offresParMoisAnnee.put(moisAnnee, offresParMoisAnnee.getOrDefault(moisAnnee, 0) + 1);
        }

        return offresParMoisAnnee;
    }

    // Statistiques Offres Publiées par Responsable/Assistant RH
    private Map<String, Integer> getOffresParRoleStatistiques() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        List<Offre> offres = offreRepository.findAll();

        Map<String, Integer> offresParRole = new HashMap<>();

        for (Offre offre : offres) {
            Utilisateur utilisateur = utilisateurs.stream()
                    .filter(u -> u.getOffres().contains(offre))
                    .findFirst()
                    .orElse(null);

            if (utilisateur != null) {
                Role role = (Role) utilisateur.getRoles();
                //String roleLabel = role.equals(Role.Responsable_RH) ? "Responsable RH" : "Assistant RH";

                //offresParRole.put(roleLabel, offresParRole.getOrDefault(roleLabel, 0) + 1);
            }
        }

        return offresParRole;
    }

    // ... other methods ...
}

