package pfe.gestiondecandidaturesdestagesoudemploiapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Role;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.AccountService;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.RoleRepository;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.UtilisateurRepository;



@Service
@Transactional //les methodes sont transactionnelles càd dès qu'il fait commit, il sait qu'on a ajouté un role à l'utilisateur et il l'a ajoute à la BD ds la table d'association
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //on va l'utiliser pour cryter le mdp de user lors de l'ajout de ce user ds la BD
    @Autowired
    private UtilisateurRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public AccountServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UtilisateurRepository userRepository, RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Utilisateur saveUser(Utilisateur user) {
        String hashPW=bCryptPasswordEncoder.encode(user.getMotDePasse());
        user.setMotDePasse(hashPW);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    Role role= roleRepository.findByRoleName(roleName);
        Utilisateur user=userRepository.findByUsername(username);
    user.getRoles().add(role);
    }

    @Override
    public Utilisateur findUserByUserName(String username) {
        return userRepository.findByUsername((username));
    }
}
