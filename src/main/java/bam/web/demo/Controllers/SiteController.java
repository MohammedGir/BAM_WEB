package bam.web.demo.Controllers;

import bam.web.demo.Entities.Site;
import bam.web.demo.Services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping("/all")
    public String site(Model model) {
        Iterable<Site>  sites = siteService.findAllSite();
        model.addAttribute("sites",sites);
        return "site";
    }
}
