package bam.web.demo.Controllers;

import bam.web.demo.Entities.Region;
import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Services.RegionService;
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

@Controller
@RequestMapping("/site")
public class SiteController {
    @Autowired
    private RegionService regionService;
    @Autowired
    private VilleService villeService;
    @Autowired
    private SiteService siteService;


    @RequestMapping("/all")
    public String site(Model model) {
        Iterable<Region> regions = regionService.findAllRegion();
        Iterable<Ville> villes = villeService.findAllVille();
        Iterable<Site>  sites = siteService.findAllSite();
        model.addAttribute("regions",regions);
        model.addAttribute("villes",villes);
        model.addAttribute("sites",sites);
        return "site";
    }
    @RequestMapping( value = "/byVille/{id}",method = RequestMethod.GET)
    public @ResponseBody List<Site> sitesByVille(@PathVariable("id") Long id){
        Ville ville = villeService.findById(id);
        List<Site> sites = siteService.findSiteByVille(ville);
        return sites;
    }
}
