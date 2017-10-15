package bam.web.demo.Controllers;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Tournee;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Services.SiteService;
import bam.web.demo.Services.TourneeService;
import bam.web.demo.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/tournee")
public class TourneeController {
     @Autowired
     private TourneeService tourneeService;
     @Autowired
     private SiteService siteService;
     @Autowired
     private VilleService villeService;

    @RequestMapping("/all")
    public String site(Model model) {
         Iterable<Tournee> tournees = tourneeService.findAllTournee();
         Iterable<Ville> villes = villeService.findAllVille();
         Iterable<Site> sites = siteService.findAllSite();

         model.addAttribute("tours",tournees);
         model.addAttribute("villes",villes);
         model.addAttribute("sites",sites);
        return "tournee";
    }
    @GetMapping("/add")
    public String getForm(Model model){
        Iterable<Site> sites = siteService.findAllSite();
        model.addAttribute("tournee", new Tournee());
        model.addAttribute("sites",sites);
        return "tourneeForm";
    }

    @RequestMapping( value = "/bySite/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<Tournee> tourneeBySite(@PathVariable("id") String id){
        Site site = siteService.findSiteById(id);
        List<Tournee> tournees = tourneeService.findTourneeBySite(site);
        return tournees;
    }
    @RequestMapping( value = "/byVille/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<Tournee> tourneeByVille(@PathVariable("id") Long id){
        List<Tournee> tournees = new ArrayList<>();
        Ville ville = villeService.findById(id);
        Set<Site> sites = ville.getSites();
        for (Site site : sites) {
            List<Tournee> tours = tourneeService.findTourneeBySite(site);
            tours.forEach(tournee -> tournees.add(tournee));
        }
        return tournees;
    }


    @PostMapping("/add")
    public RedirectView  postForm(@Valid @ModelAttribute("tournee") Tournee tournee
            ,@RequestParam() String id_site
            ,@RequestParam(value = "id_cyclo", required=false, defaultValue="0") Long id_cyclo
            ,@RequestParam(value = "id_facteur", required=false, defaultValue="0") Long id_facteur
            , BindingResult result){
        if (result.hasErrors()) {
            new RedirectView("error");
        }

        tourneeService.saveTournee(tournee,id_site,id_cyclo,id_facteur);
        System.out.println("#####################################################");
        System.out.println("Site ID: " + id_site);
        System.out.println("ID Cyclo: " + id_cyclo);
        System.out.println("ID Facteur: " + id_facteur);

        System.out.println("#####################################################");
        return new RedirectView("all");
    }

    @GetMapping("/error")
    public String pageError(){
        return "error";
    }
}
