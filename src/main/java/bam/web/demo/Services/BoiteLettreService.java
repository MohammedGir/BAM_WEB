package bam.web.demo.Services;

import bam.web.demo.Entities.BoiteLettre;
import bam.web.demo.Entities.Tournee;
import bam.web.demo.Repositories.BoiteLettreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoiteLettreService {
    @Autowired
    private BoiteLettreRepository boiteLettreRepository;

    public Iterable<BoiteLettre> findAllBLS(){
        return boiteLettreRepository.findAll();
    }
    public List<BoiteLettre> findBlsByTournee(Tournee tournee){
        return boiteLettreRepository.findBoiteLettreByTournee(tournee);
    }
}
