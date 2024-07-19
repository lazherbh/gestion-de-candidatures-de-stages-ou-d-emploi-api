package pfe.gestiondecandidaturesdestagesoudemploiapi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;
import pfe.gestiondecandidaturesdestagesoudemploiapi.repositorie.AccountService;

import java.util.ArrayList;
import java.util.Collection;


@Service

public class UserDetailsServiceImpl implements UserDetailsService {


    AccountService accountService;
    @Autowired
    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user=accountService.findUserByUserName(username);
        if(user==null) throw new UsernameNotFoundException(username);

        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new User(user.getEmail(), user.getMotDePasse(), authorities); //on doit retourner un user de spring qui contien le nom le mdp et les role sous la forme d'une collection de type GrantedAuthority

    }
   /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  //UserDetails:objet d'une classe qui implemente l'interface userDetail
        AppUser user=accountService.findUserByUserName(username);
        if(user==null) throw new UsernameNotFoundException(username);

        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new User(user.getUsername(), user.getPassword(), authorities); //on doit retourner un user de spring qui contien le nom le mdp et les role sous la forme d'une collection de type GrantedAuthority
    }*/
}
