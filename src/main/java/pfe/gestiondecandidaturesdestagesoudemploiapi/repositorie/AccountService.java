package pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie;



import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Role;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;


//interface qui permet de centraliser la gestion des utilisateurs et des roles
public interface AccountService {
    //definir les méthodes qu'on a besoin ds l'application
    public Utilisateur saveUser(Utilisateur user);  //ajouter un utilisateur
    public Role saveRole(Role role);
    public void addRoleToUser(String username, String roleName);//associer un role à un utilisateur
    public Utilisateur findUserByUserName(String username);//retourner l'utilisateur
}
