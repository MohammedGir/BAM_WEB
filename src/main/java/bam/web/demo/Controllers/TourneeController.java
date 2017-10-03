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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/add")
    public String postForm(@ModelAttribute Tournee tournee){

        return "tourneeForm";
    }
}
