package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByRoleName(String roleName);
}
