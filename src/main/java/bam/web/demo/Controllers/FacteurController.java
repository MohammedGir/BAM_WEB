package bam.web.demo.Controllers;


import bam.web.demo.Entities.Cyclo;
import bam.web.demo.Entities.Facteur;
import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Services.FacteurService;
import bam.web.demo.Services.SiteService;
import bam.web.demo.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/facteur")
@Controller
public class FacteurController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private FacteurService facteurService;
    @Autowired
    private VilleService villeService;

    @RequestMapping("/all")
    public String facteurs(Model model) {
       Iterable<Site> sites = siteService.findAllSite();
       Iterable<Facteur> facteurs = facteurService.findAllFacteur();
       Iterable<Ville> villes = villeService.findAllVille();
       model.addAttribute("facteurs",facteurs);
       model.addAttribute("sites",sites);
       model.addAttribute("villes",villes);

        return "facteur";
    }

    @RequestMapping( value = "/bySite/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<Facteur> facteurBySite(@PathVariable("id") String id){
        Site site= siteService.findSiteById(id);
        List<Facteur> facteurs = facteurService.findFacteurBySite(site);
        return facteurs;
    }
}
