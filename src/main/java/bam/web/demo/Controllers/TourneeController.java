package bam.web.demo.Controllers;

import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Tournee;
import bam.web.demo.Services.TourneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tournee")
public class TourneeController {
     @Autowired
     private TourneeService tourneeService;

    @RequestMapping("/all")
    public String site(Model model) {
         Iterable<Tournee> tournees = tourneeService.findAllTournee();
         model.addAttribute("tours",tournees);
        return "tournee";
    }
}
