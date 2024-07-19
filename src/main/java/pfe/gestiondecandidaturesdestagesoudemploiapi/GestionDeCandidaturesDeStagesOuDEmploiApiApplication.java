package pfe.gestiondecandidaturesdestagesoudemploiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pfe.gestiondecandidaturesdestagesoudemploiapi.security"})

@ComponentScan(basePackages = {"pfe.gestiondecandidaturesdestagesoudemploiapi.utils"})
public class GestionDeCandidaturesDeStagesOuDEmploiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeCandidaturesDeStagesOuDEmploiApiApplication.class, args);
    }

}
