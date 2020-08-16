package com.spring.henallux.DLivres.dataAccess.dao;

import com.spring.henallux.DLivres.Model.CommandLine;
import com.spring.henallux.DLivres.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.DLivres.dataAccess.repository.CommandLineRepository;
import com.spring.henallux.DLivres.dataAccess.util.ProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommandLineDAO {
    @Autowired
    private CommandLineRepository commandLineRepository;


    public void addCommandeLine(CommandLineEntity commandLineEntity)
    {

        commandLineRepository.save(commandLineEntity);
    }
}


