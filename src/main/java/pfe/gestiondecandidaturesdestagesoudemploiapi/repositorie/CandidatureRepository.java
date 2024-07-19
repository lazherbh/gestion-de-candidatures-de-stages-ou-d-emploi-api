package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Candidature;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Offre;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;

import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    List<Candidature> findByCandidat(Utilisateur utilisateur);

    List<Candidature> findByOffre(Offre offre);
}
