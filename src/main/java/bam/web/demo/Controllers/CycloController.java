package bam.web.demo.Controllers;

import bam.web.demo.Entities.*;
import bam.web.demo.Services.CycloService;
import bam.web.demo.Services.SiteService;
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

@RequestMapping("/cyclo")
@Controller
public class CycloController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private CycloService cycloService;
    @Autowired
    private VilleService villeService;

    @RequestMapping("/all")
    public String cyclos(Model model) {
        Iterable<Site> sites = siteService.findAllSite();
        Iterable<Cyclo> cyclos = cycloService.findAllCyclo();
        Iterable<Ville> villes = villeService.findAllVille();
        model.addAttribute("Cyclos",cyclos);
        model.addAttribute("sites",sites);
        model.addAttribute("villes",villes);
        return "cyclo";
    }

    @RequestMapping( value = "/bySite/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<Cyclo> cyclosBySite(@PathVariable("id") String id){
        Site site= siteService.findSiteById(id);
        List<Cyclo> cyclos = cycloService.findCycloBySite(site);
        return cyclos;
    }
    @RequestMapping( value = "/byVille/{id}",method = RequestMethod.GET)
    public @ResponseBody
    List<Cyclo> cyclosByVille(@PathVariable("id") Long id){
        List<Cyclo> cyclos = new ArrayList<>();
        Ville ville= villeService.findById(id);
        List<Site> sites = siteService.findSiteByVille(ville);

        for (Site site : sites){
          List<Cyclo> cyclos1 = cycloService.findCycloBySite(site);
            cyclos1.forEach(cyc-> cyclos.add(cyc));
        }

        return cyclos;
    }

    @RequestMapping( value = "/add",method = RequestMethod.GET)
    public String cycloForm(Model model){
        Iterable<Site> sites = siteService.findAllSite();
        Iterable<Ville> villes = villeService.findAllVille();
        model.addAttribute("sites", sites);
        model.addAttribute("villes",villes);
        model.addAttribute("cyclo", new Cyclo());
        return "cycloForm";
    }
    @PostMapping("/add")
    public RedirectView postForm(@Valid @ModelAttribute("cyclo") Cyclo cyclo, @RequestParam() String id_site,
                                 BindingResult result){
        if (result.hasErrors()) {
            new RedirectView("error");
        }

        cycloService.saveCyclo(cyclo,id_site);
        System.out.println("#####################################################");
        System.out.println("Site ID: " + id_site);
        System.out.println("ID: " + cyclo.getId());
        System.out.println("Reference: " + cyclo.getReference());
        System.out.println("Date CG: " + cyclo.getDateCarteGrise());
        System.out.println("Date: " + cyclo.getDatePU());
        System.out.println("#####################################################");
        return new RedirectView("all");
    }
}
