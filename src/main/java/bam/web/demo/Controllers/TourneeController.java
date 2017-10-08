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
import java.util.List;

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


    @PostMapping("/add")
    public RedirectView  postForm(@Valid @ModelAttribute("tournee") Tournee tournee,@RequestParam() String id_site,
                                  BindingResult result){
        if (result.hasErrors()) {
            new RedirectView("error");
        }

        tourneeService.saveTournee(tournee,id_site);
        System.out.println("#####################################################");
        System.out.println("Site ID: " + id_site);
        System.out.println("ID: " + tournee.getId());
        System.out.println("Numero: " + tournee.getNumero());
        System.out.println("Date: " + tournee.getDateTournee());
        System.out.println("Montant: " + tournee.getMntIndemnite());
        System.out.println("Trajet: " + tournee.getTrajetLongeur());
        System.out.println("#####################################################");
        return new RedirectView("all");
    }

    @GetMapping("/error")
    public String pageError(){
        return "error";
    }
}
