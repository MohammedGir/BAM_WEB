package bam.web.demo.Initializers;

import bam.web.demo.Entities.*;
import bam.web.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;


@Service
public class InitDataBase {

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private FacteurRepository facteurRepository;

    public void initSite(){

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
    public void initTournee(){

        Site site2Mars = siteRepository.findOne(new Long(7));
        Site siteMaarif = siteRepository.findOne(new Long(3));
        Site siteAgdal = siteRepository.findOne(new Long(9));
        Site siteAddouha = siteRepository.findOne(new Long(11));
        Site sitePpal = siteRepository.findOne(new Long(17));

        Set tour1 = new HashSet<Tournee>(){{
            add(new Tournee(new Long(1111),new GregorianCalendar(2017, 1, 20).getTime(),
                    new Double(10),new Double(0),site2Mars));
            add(new Tournee(new Long(1452),new GregorianCalendar(2017, 1, 1).getTime(),
                    new Double(2),new Double(2),site2Mars));
            add(new Tournee(new Long(1236),new GregorianCalendar(2017, 1, 6).getTime(),
                    new Double(3),new Double(12),site2Mars));
            add(new Tournee(new Long(1452),new GregorianCalendar(2017, 1, 25).getTime(),
                    new Double(3),new Double(0),site2Mars));
        }};

        site2Mars.setTournees(tour1);

        Set tour2 = new HashSet<Tournee>(){{
            add(new Tournee(new Long(1687),new GregorianCalendar(2017, 2, 20).getTime(),
                    new Double(10),new Double(0),siteMaarif));
            add(new Tournee(new Long(1236),new GregorianCalendar(2017, 1, 1).getTime(),
                    new Double(2),new Double(2),siteMaarif));
            add(new Tournee(new Long(9854),new GregorianCalendar(2017, 3, 6).getTime(),
                    new Double(3),new Double(12),siteMaarif));
            add(new Tournee(new Long(9635),new GregorianCalendar(2017, 1, 4).getTime(),
                    new Double(3),new Double(0),siteMaarif));
        }};

        siteMaarif.setTournees(tour2);

        Set tour3 = new HashSet<Tournee>(){{
            add(new Tournee(new Long(9574),new GregorianCalendar(2017, 2, 12).getTime(),
                    new Double(2),new Double(0),siteAgdal));
            add(new Tournee(new Long(4521),new GregorianCalendar(2017, 1, 11).getTime(),
                    new Double(4),new Double(20),siteAgdal));
            add(new Tournee(new Long(9587),new GregorianCalendar(2017, 3, 7).getTime(),
                    new Double(3),new Double(120),siteAgdal));
            add(new Tournee(new Long(9657),new GregorianCalendar(2017, 1, 6).getTime(),
                    new Double(3),new Double(100),siteAgdal));
        }};

        siteAgdal.setTournees(tour3);

        Set tour4 = new HashSet<Tournee>(){{
            add(new Tournee(new Long(5647),new GregorianCalendar(2017, 2, 20).getTime(),
                    new Double(2),new Double(10),siteAddouha));
            add(new Tournee(new Long(5698),new GregorianCalendar(2017, 1, 1).getTime(),
                    new Double(2),new Double(20),siteAddouha));
            add(new Tournee(new Long(5412),new GregorianCalendar(2017, 3, 6).getTime(),
                    new Double(5),new Double(112),siteAddouha));
            add(new Tournee(new Long(5236),new GregorianCalendar(2017, 1, 4).getTime(),
                    new Double(6),new Double(20),siteAddouha));
        }};

        siteAddouha.setTournees(tour4);

        Set tour5 = new HashSet<Tournee>(){{
            add(new Tournee(new Long(4587),new GregorianCalendar(2017, 2, 20).getTime(),
                    new Double(10),new Double(0),sitePpal));
            add(new Tournee(new Long(1236),new GregorianCalendar(2017, 1, 1).getTime(),
                    new Double(2),new Double(2),sitePpal));
            add(new Tournee(new Long(9854),new GregorianCalendar(2017, 1, 6).getTime(),
                    new Double(3),new Double(12),sitePpal));
            add(new Tournee(new Long(9635),new GregorianCalendar(2017, 2, 4).getTime(),
                    new Double(3),new Double(0),sitePpal));
        }};

        sitePpal.setTournees(tour5);


        siteRepository.save(new HashSet<Site>(){{
            add(site2Mars);
            add(siteMaarif);
            add(siteAddouha);
            add(sitePpal);
            add(siteAgdal);
        }});

    }
    public void initFacteur(){
        Site siteAnassi = siteRepository.findOne(new Long(1));
        Site site2Mars = siteRepository.findOne(new Long(7));
        Site siteMaarif = siteRepository.findOne(new Long(3));
        Site siteAgdal = siteRepository.findOne(new Long(9));
        Site siteAddouha = siteRepository.findOne(new Long(11));
        Site sitePpal = siteRepository.findOne(new Long(17));

        Set fac1 = new HashSet<Facteur>(){{
            add(new Facteur("A123654","Ed-daou","Mohammed",site2Mars));
            add(new Facteur("A1456987","Zaria","Mehdi",site2Mars));
            add(new Facteur("D123454","Khamli","Amine",site2Mars));
        }};
        site2Mars.setFacteurs(fac1);

        Set fac2 = new HashSet<Facteur>(){{
            add(new Facteur("B1234554","Zarouali","Oussama",siteMaarif));
            add(new Facteur("C1456987","Abid","Manar",siteMaarif));
            add(new Facteur("D1224454","Khamli","Laila",siteMaarif));
        }};
        siteMaarif.setFacteurs(fac2);

        Set fac3 = new HashSet<Facteur>(){{
            add(new Facteur("B123478","Fouhami","Amine",siteAgdal));
            add(new Facteur("C5696987","Fahmi","Youssra",siteAgdal));
            add(new Facteur("D156454","Yassir","Kamal",siteAgdal));
        }};
        siteAgdal.setFacteurs(fac3);

        Set fac4 = new HashSet<Facteur>(){{
            add(new Facteur("B145478","Benani","Amine",siteAddouha));
            add(new Facteur("C5696987","Alawi","Mohamed",siteAddouha));
            add(new Facteur("D156454","Alawi","Hassan",siteAddouha));
        }};

        Set fac5 = new HashSet<Facteur>(){{
            add(new Facteur("G14458","Benani","Ali",siteAddouha));
            add(new Facteur("C5696987","Miar","Salah",siteAddouha));
            add(new Facteur("D156454","Tawsi","Ayoub",siteAddouha));
        }};
        sitePpal.setFacteurs(fac5);

        Set fac6 = new HashSet<Facteur>(){{
            add(new Facteur("D914458","Benani","Youssef",siteAnassi));
            add(new Facteur("F5691187","Miar","Kawtar",siteAnassi));
            add(new Facteur("S156454","Koko","Anass",siteAnassi));
        }};
        siteAnassi.setFacteurs(fac6);

        siteRepository.save(new HashSet<Site>(){{
            add(site2Mars);
            add(siteMaarif);
            add(siteAgdal);
            add(sitePpal);
            add(siteAddouha);
            add(siteAnassi);

        }});
    }

    public void initCyclo(){
        Site siteAnassi = siteRepository.findOne(new Long(1));
        Site site2Mars = siteRepository.findOne(new Long(7));
        Site siteMaarif = siteRepository.findOne(new Long(3));
        Site siteAgdal = siteRepository.findOne(new Long(9));

        Set cyc1 = new HashSet<Cyclo>(){{
            add(new Cyclo("12A12547",new GregorianCalendar(2011, 1, 20).getTime(),
                    new GregorianCalendar(2017, 1, 20).getTime(),"fg45874",siteAnassi));
            add(new Cyclo("11A12547",new GregorianCalendar(2015, 1, 20).getTime(),
                    new GregorianCalendar(2018, 1, 20).getTime(),"ref 125478",siteAnassi));
        }};
        siteAnassi.setCyclos(cyc1);

        Set cyc2 = new HashSet<Cyclo>(){{
            add(new Cyclo("12A121257",new GregorianCalendar(2014, 5, 20).getTime(),
                    new GregorianCalendar(2017, 1, 20).getTime(),"fg4125474",site2Mars));
            add(new Cyclo("01B12547",new GregorianCalendar(2015, 1, 20).getTime(),
                    new GregorianCalendar(2017, 0, 1).getTime(),"ref 478",site2Mars));
        }};
        site2Mars.setCyclos(cyc2);

        Set cyc3 = new HashSet<Cyclo>(){{
            add(new Cyclo("18A121257",new GregorianCalendar(2013, 0, 20).getTime(),
                    new GregorianCalendar(2020, 1, 2).getTime(),"fh115474",siteMaarif));
            add(new Cyclo("01C12547",new GregorianCalendar(2015, 1, 20).getTime(),
                    new GregorianCalendar(2016, 0, 11).getTime(),"ref 11478",siteMaarif));
        }};
        siteMaarif.setCyclos(cyc3);

        Set cyc4 = new HashSet<Cyclo>(){{
            add(new Cyclo("18A1111",new GregorianCalendar(2010, 1, 20).getTime(),
                    new GregorianCalendar(2015, 1, 2).getTime(),"ref11541147",siteAgdal));
            add(new Cyclo("02C12547",new GregorianCalendar(2015, 1, 20).getTime(),
                    new GregorianCalendar(2019, 4, 1).getTime(),"ref 1865974",siteAgdal));
        }};
        siteAgdal.setCyclos(cyc4);

        siteRepository.save(new HashSet<Site>(){{
            add(siteAnassi);
            add(site2Mars);
            add(siteMaarif);
            add(siteAgdal);
        }});
    }
}
