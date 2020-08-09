package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currentlanguage")
public class CurrentLanguageEntity {

    @Id
    @Column(name="currentlanguage_id")
    private String currentLanguage_id;

    @Column(name="namelanguage")
    private String nameLanguage;

    public String getCurrentLanguage_id() {
        return currentLanguage_id;
    }

    public void setCurrentLanguage_id(String currentLanguage_id) {
        this.currentLanguage_id = currentLanguage_id;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }


}