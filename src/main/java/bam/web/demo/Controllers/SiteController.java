package bam.web.demo.Controllers;

import bam.web.demo.Entities.Region;
import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Tournee;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Services.RegionService;
import bam.web.demo.Services.SiteService;
import bam.web.demo.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
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
    @RequestMapping( value = "/add",method = RequestMethod.GET)
    public String siteForm(Model model){
        Iterable<Region> regions = regionService.findAllRegion();
        Iterable<Ville> villes = villeService.findAllVille();
        model.addAttribute("regions", regions);
        model.addAttribute("villes",villes);
        model.addAttribute("site", new Site());
        return "siteForm";
    }
    @RequestMapping( value = "/add",method = RequestMethod.POST)
    public RedirectView addSite(@Valid @ModelAttribute("site") Site site, @RequestParam() Long id_ville,
                                BindingResult result){
        if (result.hasErrors()) {
            new RedirectView("error");
        }
//
        System.out.println("#####################################################");
        System.out.println("Ville ID: " + id_ville);
        System.out.println("ID: " + site.getId());
        System.out.println("Nom: " + site.getNom());
        System.out.println("Type: " + site.getType());
        System.out.println("Code Postal: " + site.getCp());

        System.out.println("#####################################################");
        siteService.saveSite(site,id_ville);
        return new RedirectView("all");
    }
}
