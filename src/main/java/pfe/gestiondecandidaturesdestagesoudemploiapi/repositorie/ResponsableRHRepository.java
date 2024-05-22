package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.ResponsableRH;

@Repository
public interface ResponsableRHRepository extends JpaRepository<ResponsableRH, Long> {
}
