package bam.web.demo.Controllers;

import bam.web.demo.Entities.*;
import bam.web.demo.Services.BoiteLettreService;
import bam.web.demo.Services.SiteService;
import bam.web.demo.Services.TourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/bls")
@Controller
public class blsController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private TourneeService tourneeService;
    @Autowired
    private BoiteLettreService boiteLettreService;

    @RequestMapping("/all")
    public String cyclos(Model model) {
        Iterable<Site> sites = siteService.findAllSite();
        Iterable<Tournee> tournees = tourneeService.findAllTournee();
        Iterable<BoiteLettre> bls = boiteLettreService.findAllBLS();
        model.addAttribute("tournees",tournees);
        model.addAttribute("sites",sites);
        model.addAttribute("bls",bls);
        return "bls";
    }
    @RequestMapping( value = "/byTournee/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<BoiteLettre> blsByTournee(@PathVariable("id") Long id){
        Tournee tournee= tourneeService.findTourneeById(id);
        List<BoiteLettre> bls = boiteLettreService.findBlsByTournee(tournee);
        bls.forEach(bl -> System.out.println(bl.getId()));
        return bls;
    }

    @RequestMapping( value = "/bySite/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<BoiteLettre> blsBySite(@PathVariable("id") String id){
        List<BoiteLettre> bls = new ArrayList<>();
        Site site= siteService.findSiteById(id);
        List<Tournee> tournees = tourneeService.findTourneeBySite(site);

        for (Tournee tour : tournees){
            List<BoiteLettre> bl = boiteLettreService.findBlsByTournee(tour);
            bl.forEach(cyc-> bls.add(cyc));
        }
        return bls;
    }

    @RequestMapping( value = "/add",method = RequestMethod.GET)
    public String blsForm(Model model){
        Iterable<Site> sites = siteService.findAllSite();
        model.addAttribute("sites", sites);
        model.addAttribute("bls", new BoiteLettre());
        return "blsForm";
    }
    @PostMapping("/add")
    public RedirectView postForm(@Valid @ModelAttribute("bls") BoiteLettre bls, @RequestParam() Long id_tournee,
                                 BindingResult result){
        if (result.hasErrors()) {
            new RedirectView("error");
        }

        boiteLettreService.saveBLS(bls,id_tournee);
        System.out.println("#####################################################");
        System.out.println("Site ID: " + id_tournee);
        System.out.println("ID: " + bls.getAdresse());
        System.out.println("Reference: " + bls.getCp());
        System.out.println("#####################################################");
        return new RedirectView("all");
    }
}
