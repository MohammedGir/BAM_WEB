package bam.web.demo.Repositories;

import bam.web.demo.Entities.Site;
import org.springframework.data.repository.CrudRepository;

public interface SiteRepository extends CrudRepository<Site,Long> {
}
