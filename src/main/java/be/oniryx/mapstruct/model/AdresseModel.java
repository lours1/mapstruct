package be.oniryx.mapstruct.model;


import be.oniryx.mapstruct.dto.Personne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdresseModel {

    @Id
    private Integer id;
    private String rue;
    private int numero;
    private String ville;

    private PersonneModel personne;


    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonneModel getPersonne() {
        return personne;
    }

    public void setPersonne(PersonneModel personne) {
        this.personne = personne;
    }
}
