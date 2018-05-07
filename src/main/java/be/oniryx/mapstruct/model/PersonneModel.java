package be.oniryx.mapstruct.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PersonneModel {
    @Id
    private Integer id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private AdresseModel adresse;

    private List<CompetenceModel> competences;

    public PersonneModel() {
    }

    public PersonneModel(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<CompetenceModel> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceModel> competences) {
        this.competences = competences;
    }

    public AdresseModel getAdresseModel() {
        return adresse;
    }

    public void setAdresseModel(AdresseModel adresse) {
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
