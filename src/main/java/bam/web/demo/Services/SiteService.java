package bam.web.demo.Services;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;

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
}
