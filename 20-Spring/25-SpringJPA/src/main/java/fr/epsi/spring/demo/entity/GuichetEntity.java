package fr.epsi.spring.demo.entity;

import fr.epsi.spring.demo.web.v1.dto.Gare;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "guichet")
public class GuichetEntity {

    @Id
    private Long id;

    public enum Type{
        AUTOMATE, NON_AUTOMATE
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private GareEntity gare;

    private String libelle;

    private LocalTime heureOuverture;

    private LocalTime heureFermeture;

    public GareEntity getGare() {
        return gare;
    }

    public void setGare(GareEntity gare) {
        this.gare = gare;
    }

    public LocalTime getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(LocalTime heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public LocalTime getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(LocalTime heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
