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
    private String currentLanguageId;

    @Column(name="namelanguage")
    private String nameLanguage;

    public String getCurrentLanguageId() {
        return currentLanguageId;
    }

    public void setCurrentLanguageId(String currentLanguageId) {
        this.currentLanguageId = currentLanguageId;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }


}