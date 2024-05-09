package pfe.gestiondecandidaturesdestagesoudemploiapi.model;

import java.util.Map;

public class offreModel {
    private String titre;
    private String details;
    private int periode;
    private String domaine;
    private String mode;
    private Map<String, String> competences;

    public offreModel(String titre, String details, int periode, String domaine, String mode, Map<String, String> competences) {
        this.titre = titre;
        this.details = details;
        this.periode = periode;
        this.domaine = domaine;
        this.mode = mode;
        this.competences = competences;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Map<String, String> getCompetences() {
        return competences;
    }

    public void setCompetences(Map<String, String> competences) {
        this.competences = competences;
    }
}
