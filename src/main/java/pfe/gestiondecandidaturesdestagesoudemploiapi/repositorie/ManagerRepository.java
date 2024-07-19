package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;

@Repository
public interface ManagerRepository extends JpaRepository<Utilisateur, Long> {
}
