package bam.web.demo.Services;

import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;

    public Iterable<Ville> findAllVille(){
        return villeRepository.findAll();
    }
}
