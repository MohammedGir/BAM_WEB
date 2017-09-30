package bam.web.demo.Initializers;

import bam.web.demo.Entities.Region;
import bam.web.demo.Entities.Site;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.RegionRepository;
import bam.web.demo.Repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class InitDataBase {

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private VilleRepository villeRepository;
    public void init(){

        Region region1 = new Region("CASA-SETTAT-BERRECHID");

        Set villes1 = new HashSet<Ville>(){{
            add(new Ville("Casa",region1));
            add(new Ville("Settat",region1));
        }};
        region1.setVilles(villes1);

        Region region2 = new Region("MARRAKECH-ESSAOUIRA");
        Set villes2 = new HashSet<Ville>(){{
            add(new Ville("Marrakech",region2));
            add(new Ville("Essaouira",region2));
        }};
        region2.setVilles(villes2);

        Region region3 = new Region("RABAT-SALE-SKHIRATE-TEMARA");
        Set villes3 = new HashSet<Ville>(){{
            add(new Ville("Rabat",region3));
            add(new Ville("Sale",region3));
        }};
        region3.setVilles(villes3);

        regionRepository.save(new HashSet<Region>(){{
            add(region1);
            add(region2);
            add(region3);
        }});

        // initialiser les sites avec les villes
        Ville casaVille = villeRepository.findOne(new Long(1));
        Ville settatVille = villeRepository.findOne(new Long(2));
        Ville rabatVille = villeRepository.findOne(new Long(5));

        Set site1 = new HashSet<Site>(){{
            add(new Site("CASA 2 MARS", 20502,"CTD",casaVille));
            add(new Site("CASA AIN CHOK",20153,"CCI",casaVille));
            add(new Site("CASA AIN SEBAA",	20253,"CTD",casaVille));
            add(new Site("CASA AL QODS",	20602,"CCI",casaVille));
            add(new Site("CASA BD ABDELMOUMEN",20042,"CTD",casaVille));
            add(new Site("CASA MAARIF",	20104,"CCI",casaVille));
            add(new Site("CASABLANCA ANASSI",	20803,"CTD",casaVille));
            add(new Site("CASABLANCA GHANDI",	20026,"CCI",casaVille));
        }};

        casaVille.setSites(site1);

        Set site2 = new HashSet<Site>(){{
            add(new Site("BERRECHID CLD",	26104,"CTD",settatVille));
            add(new Site("BERRECHID HAY HASSANI",	26102,"CCI",settatVille));
            add(new Site("BERRECHID PPAL",	26103,"CTD",settatVille));
            add(new Site("BERRECHID YASMINA",	26105,"CCI",settatVille));
        }};

        settatVille.setSites(site2);

        Set site3 = new HashSet<Site>(){{
            add(new Site("RABAT ADDOHA",	10022,"CTD",rabatVille));
            add(new Site("RABAT AGDAL",		10106,"CCI",rabatVille));
            add(new Site("RABAT AKKARI",		10052,"CTD",rabatVille));
            add(new Site("RABAT AL MANAL",		10044,"CCI",rabatVille));
            add(new Site("RABAT AL MASSIRA",	10153,"CTD",rabatVille));
            add(new Site("RABAT BAB EL ALOU",	10024,"CCI",rabatVille));
        }};

        rabatVille.setSites(site3);

        villeRepository.save(new HashSet<Ville>(){{
            add(casaVille);
            add(settatVille);
            add(rabatVille);
        }});


    }
}
