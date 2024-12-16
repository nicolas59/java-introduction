package fr.epsi.spring.demo.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "gare")
public class GareEntity {
    @Id
    private Long id;

    private Long uic;

    private String libelle;

    private Boolean supportFret;

    private Boolean supportVoyageurs;

    private String codeLigne;

    @Embedded
    private AdresseEntity adresse;

    @OneToMany(mappedBy = "gare")
    private List<GuichetEntity> guichets;

    public GareEntity(AdresseEntity adresse, String codeLigne, Long id, String libelle, Boolean supportFret, Boolean supportVoyageurs) {
        this.adresse = adresse;
        this.codeLigne = codeLigne;
        this.id = id;
        this.libelle = libelle;
        this.supportFret = supportFret;
        this.supportVoyageurs = supportVoyageurs;
    }

    public GareEntity() {
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }

    public String getCodeLigne() {
        return codeLigne;
    }

    public void setCodeLigne(String codeLigne) {
        this.codeLigne = codeLigne;
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

    public Boolean getSupportFret() {
        return supportFret;
    }

    public void setSupportFret(Boolean supportFret) {
        this.supportFret = supportFret;
    }

    public Boolean getSupportVoyageurs() {
        return supportVoyageurs;
    }

    public void setSupportVoyageurs(Boolean supportVoyageurs) {
        this.supportVoyageurs = supportVoyageurs;
    }

    public Long getUic() {
        return uic;
    }

    public void setUic(Long uic) {
        this.uic = uic;
    }

    public List<GuichetEntity> getGuichets() {
        return guichets;
    }

    public void setGuichets(List<GuichetEntity> guichets) {
        this.guichets = guichets;
    }
}
