package fr.epsi.spring.demo.domain;

import com.opencsv.bean.CsvBindByName;

public class Adresse {

    @CsvBindByName(column = "COMMUNE")
    private String commune;

    @CsvBindByName(column = "DEPARTEMEN")
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


