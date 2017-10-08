package bam.web.demo.Repositories;

import bam.web.demo.Entities.Region;
import bam.web.demo.Entities.Ville;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VilleRepository extends CrudRepository<Ville,Long>{
    public List<Ville> findVilleByRegion(Region region);
    public Ville findVilleByNom(String nom);
}
