package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Domaine;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long> {
}
