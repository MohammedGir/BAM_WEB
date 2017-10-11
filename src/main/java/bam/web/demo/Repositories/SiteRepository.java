package bam.web.demo.Repositories;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SiteRepository extends CrudRepository<Site,Long> {

    public List<Site> findSiteByVille(Ville ville);
    public Site findSiteByNom(String nom);

}
