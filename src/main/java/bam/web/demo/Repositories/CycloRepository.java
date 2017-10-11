package bam.web.demo.Repositories;

import bam.web.demo.Entities.Cyclo;
import bam.web.demo.Entities.Site;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CycloRepository extends CrudRepository<Cyclo,Long> {

    public List<Cyclo> findCycloBySite(Site site);
}
