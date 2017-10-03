package bam.web.demo.Services;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Tournee;
import bam.web.demo.Repositories.TourneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourneeService {
    @Autowired
    private TourneeRepository tourneeRepository;
    @Autowired
    private SiteService siteService;

    public Iterable<Tournee> findAllTournee(){
        return tourneeRepository.findAll();
    }

    public void saveTournee(Tournee tournee, String site_id){

        Site site = siteService.findSiteById(site_id);
        tournee.setSite(site);
        tourneeRepository.save(tournee);
    }
}
