package bam.web.demo.Services;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Tournee;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.TourneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TourneeService {
    @Autowired
    private TourneeRepository tourneeRepository;
    @Autowired
    private SiteService siteService;
    @Autowired
    private VilleService villeService;

    public Iterable<Tournee> findAllTournee(){
        return tourneeRepository.findAll();
    }
    public List<Tournee> findTourneeBySite(Site site){
       return tourneeRepository.findTourneeBySite(site);
    }

    public void saveTournee(Tournee tournee, String site_id){

        Site site = siteService.findSiteById(site_id);
        tournee.setSite(site);
        tourneeRepository.save(tournee);
    }
    public Tournee findTourneeById(Long id){
        return tourneeRepository.findOne(id);
    }
}
