package bam.web.demo.Services;

import bam.web.demo.Entities.Facteur;
import bam.web.demo.Repositories.FacteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacteurService {
    @Autowired
    private FacteurRepository facteurRepository;

    public Iterable<Facteur> findAllFacteur(){
        return facteurRepository.findAll();
    }
}
