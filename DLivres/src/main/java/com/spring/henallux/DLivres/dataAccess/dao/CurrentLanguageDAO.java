package com.spring.henallux.DLivres.dataAccess.dao;


import com.spring.henallux.DLivres.dataAccess.entity.CurrentLanguageEntity;
import com.spring.henallux.DLivres.dataAccess.repository.CurrentLanguageRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CurrentLanguageDAO {


    @Autowired
    private CurrentLanguageRepository currentLanguageRepository;



    public CurrentLanguageEntity findCurrentLanguageByName(String language)
    {
        return  currentLanguageRepository.findByCurrentLanguageId(language);
    }

}
