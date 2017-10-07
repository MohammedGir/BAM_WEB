package bam.web.demo.Services;

import bam.web.demo.Entities.Region;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;

    public Ville findById(Long id){return villeRepository.findOne(id);}
    public Iterable<Ville> findAllVille(){
        return villeRepository.findAll();
    }
    public List<Ville> findVilleByRegion(Region region){
        return villeRepository.findVilleByRegion(region);
    }

}
