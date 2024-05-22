package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.CompetenceOffre;

@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceOffre, Long> {
}
