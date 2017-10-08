package bam.web.demo.Services;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.SiteRepository;
import bam.web.demo.Repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private VilleRepository villeRepository;

    public Iterable<Site> findAllSite(){
        return siteRepository.findAll();
    }

    public Site findSiteById(String param){
        Long id = Long.parseLong(param);

        return siteRepository.findOne(id);
    }

    public List<Site> findSiteByVille(Ville ville){
        return siteRepository.findSiteByVille(ville);
    }

    public void saveSite(Site site, Long id_ville){

        Ville ville = villeRepository.findOne(id_ville);
        site.setVille(ville);
        siteRepository.save(site);




    }
}
