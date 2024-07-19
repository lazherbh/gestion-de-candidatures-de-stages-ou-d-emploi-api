package pfe.gestiondecandidaturesdestagesoudemploiapi.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pfe.gestiondecandidaturesdestagesoudemploiapi.entitie.Utilisateur;

import java.io.IOException;
import java.util.Date;

/**
 * @author omrani
 * @project intelligentCommercialManagement
 * @Date févr., 2020
 */
//Un filtre qui intervient dans les operations d'authentification
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    // @Autowired
    // ObjectMapper objectMapper; //utiliser lorsque les donnes envoyés par l'utilisateur sont en format json: prendre des objets json et les stocker ds un objet java

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Utilisateur appUser=null;
        /** si les donnees ne sont pas envoyées en format json et sont par exemple envoyées en format wwwURLEncoded on ecrit les 2 lignes svtes:
         *String username=request.getParameter("username");
         *String password=request.getParameter("password");
         */
        //request.getInputStream():permet de recuperer le corps de la requete(username et mdp) et le stocker ds l'objet appUser.class
        try {
            appUser=new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);       //on peut mettre new ObjectMapper mais ds ce cas pour chaque tentative de connexion on va creer un object objectMapper, donc on l' cree ocomme etant un bean ds la classe principale de l'app
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //retourner un objet de type Authentication
        // System.out.println("******************");
        //  System.out.println("username:"+appUser.getUsername());
        //System.out.println("password:"+appUser.getPassword());
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getEmail(), appUser.getMotDePasse()));
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {  //FilterChain est le filtre de springSecurity**** authResult c'est le resultat de la fonction attemptAuthentication(un user)
        User springUser= (User) authResult.getPrincipal(); //getPrincipal permet de recuperer à partir de authResult le user de spring  qui contient les informations sur l'utilsateur qui est authentifié(nom,mdp rt roles)
        String jwt= Jwts.builder()  //creation du token
                .setSubject(springUser.getUsername())  //registred claims
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET) //Le token est signé avec l'algorithme HS256
                .claim("roles", springUser.getAuthorities())   //roles est le nom du claim: c'est un claim personnel on l'appelle comme on veut
                .compact(); //compacter le token avec baseURLEncoder
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt); //ajouter le token ds response; généralement lors du génartion du token on met pas le prefixe et lorsque l'utilisateur envoit le token on met le prefixe
    }




}