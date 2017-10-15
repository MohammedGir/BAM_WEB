package bam.web.demo.Repositories;

import bam.web.demo.Entities.Facteur;
import bam.web.demo.Entities.Site;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacteurRepository extends CrudRepository<Facteur,Long>{

    public List<Facteur> findFacteurBySite(Site site);
}
