package bam.web.demo.Controllers;

import bam.web.demo.Entities.Cyclo;
import bam.web.demo.Entities.Facteur;
import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Services.CycloService;
import bam.web.demo.Services.SiteService;
import bam.web.demo.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
