package bam.web.demo.Repositories;

import bam.web.demo.Entities.BoiteLettre;
import bam.web.demo.Entities.Tournee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoiteLettreRepository extends CrudRepository<BoiteLettre,Long>{
    public List<BoiteLettre> findBoiteLettreByTournee(Tournee tournee);
}
