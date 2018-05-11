package be.oniryx.mapstruct.dto;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.List;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private XMLGregorianCalendar dateNaissance;
    private Adresse adresse;

    private List<Competence> competences;

    public Personne() {
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

    public XMLGregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(XMLGregorianCalendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
