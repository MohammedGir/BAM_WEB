package bam.web.demo.Services;

import bam.web.demo.Entities.Cyclo;
import bam.web.demo.Entities.Site;
import bam.web.demo.Repositories.CycloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycloService {
    @Autowired
    private CycloRepository cycloRepository;
    @Autowired
    private SiteService siteService;

   public Iterable<Cyclo> findAllCyclo(){
       return cycloRepository.findAll();
   }
   public List<Cyclo> findCycloBySite(Site site){
     return   cycloRepository.findCycloBySite(site);
   }
   public void saveCyclo(Cyclo cyclo, String id_site){

       Site site = siteService.findSiteById(id_site);
       cyclo.setSite(site);
       cycloRepository.save(cyclo);

   }
}
