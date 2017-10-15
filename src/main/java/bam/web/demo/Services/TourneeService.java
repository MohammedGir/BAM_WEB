package bam.web.demo.Services;

import bam.web.demo.Entities.*;
import bam.web.demo.Repositories.CycloRepository;
import bam.web.demo.Repositories.FacteurRepository;
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
    private CycloRepository cycloRepository;
    @Autowired
    private FacteurRepository facteurRepository;

    public Iterable<Tournee> findAllTournee(){
        return tourneeRepository.findAll();
    }
    public List<Tournee> findTourneeBySite(Site site){
       return tourneeRepository.findTourneeBySite(site);
    }

    public void saveTournee(Tournee tournee, String site_id, Long id_cyclo, Long id_facteur){

        if(id_cyclo != 0){
            Cyclo cyc = cycloRepository.findOne(id_cyclo);
            tournee.setCyclo(cyc);
        }
        if(id_facteur != 0){
            Facteur fac = facteurRepository.findOne(id_facteur);
            tournee.setFacteur(fac);
        }

        Site site = siteService.findSiteById(site_id);
        tournee.setSite(site);
        tourneeRepository.save(tournee);
    }
    public Tournee findTourneeById(Long id){
        return tourneeRepository.findOne(id);
    }
}
