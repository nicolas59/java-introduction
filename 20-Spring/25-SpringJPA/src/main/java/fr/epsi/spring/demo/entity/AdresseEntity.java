package fr.epsi.spring.demo.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;


public class AdresseEntity {
    private String commune;

    private String departement;

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
