package pfe.gestiondecandidaturesdestagesoudemploiapi.entitie;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Collection;


@Entity
public  class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @Column(nullable = false)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER) //on a utilisé eager car à chque fois je vais charger un utilisateur, j'ai besion de telecharger ses roles
    private Collection<Role> roles = new ArrayList<>();

    public Utilisateur(Long id, String nom, String prenom, String email, String motDePasse, String username, Collection<Role> roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.username = username;
        this.roles = roles;
    }

    public Utilisateur() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
// Getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Offre> getOffres() {
        return new ArrayList<>();
    }
}
