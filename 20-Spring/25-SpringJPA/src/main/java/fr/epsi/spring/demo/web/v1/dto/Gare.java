package fr.epsi.spring.demo.web.v1.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvRecurse;
import fr.epsi.spring.demo.converter.BooleanConverter;

import java.util.StringJoiner;

public class Gare  {

    private Long id;

    private String libelle;

    private Boolean supportFret;

    private Boolean supportVoyageurs;

    private String codeLigne;

    private Adresse adresse;

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public Boolean getSupportFret() {
        return supportFret;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setSupportFret(Boolean supportFret) {
        this.supportFret = supportFret;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getCodeLigne() {
        return codeLigne;
    }

    public void setCodeLigne(String codeLigne) {
        this.codeLigne = codeLigne;
    }

    public Boolean getSupportVoyageurs() {
        return supportVoyageurs;
    }

    public void setSupportVoyageurs(Boolean supportVoyageurs) {
        this.supportVoyageurs = supportVoyageurs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Gare.class.getSimpleName() + "[", "]")
                .add("adresse=" + adresse)
                .add("id=" + id)
                .add("libelle='" + libelle + "'")
                .add("supportFret=" + supportFret)
                .add("supportVoyageurs=" + supportVoyageurs)
                .add("codeLigne='" + codeLigne + "'")
                .toString();
    }
}
