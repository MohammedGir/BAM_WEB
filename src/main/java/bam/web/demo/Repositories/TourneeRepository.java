package bam.web.demo.Repositories;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Tournee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TourneeRepository  extends CrudRepository<Tournee,Long>{
    public List<Tournee> findTourneeBySite(Site site);
    public Tournee findTourneeByNumero(Long numero);
}
