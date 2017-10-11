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
    @Autowired
    private TourneeRepository tourneeRepository;

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
        Ville casaVille = villeRepository.findVilleByNom("Casa");
        Ville settatVille = villeRepository.findVilleByNom("Settat");
        Ville rabatVille = villeRepository.findVilleByNom("Rabat");

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
        Site siteAnassi = siteRepository.findSiteByNom("CASABLANCA ANASSI");
        Site site2Mars = siteRepository.findSiteByNom("CASA 2 MARS");
        Site siteMaarif = siteRepository.findSiteByNom("CASA MAARIF");
        Site siteAgdal = siteRepository.findSiteByNom("RABAT AGDAL");

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
    public void initBLS(){
        Tournee tour1 = tourneeRepository.findOne(new Long(1));
        Tournee tour2 = tourneeRepository.findOne(new Long(2));
        Tournee tour3 = tourneeRepository.findOne(new Long(3));
        Tournee tour4 = tourneeRepository.findOne(new Long(4));
        Tournee tour5 = tourneeRepository.findOne(new Long(5));

        Set bls1 = new HashSet<BoiteLettre>(){{
            add(new BoiteLettre("N° 12, agdal","personnel",10124,"active",tour1));
            add(new BoiteLettre("N° 125, agdal ","sociate",10200,"active",tour1));
            add(new BoiteLettre("N° 1254, agdal","personnel",10111,"active",tour1));
            add(new BoiteLettre("N° 5214, agdal ","personnel",10124,"active",tour1));
            add(new BoiteLettre("N° 5478, agdal","sociate",10124,"active",tour1));
        }};
        tour1.setBoiteLettres(bls1);

        Set bls2 = new HashSet<BoiteLettre>(){{
            add(new BoiteLettre("N° 1562, agdal","societe",10569,"active",tour2));
            add(new BoiteLettre("N° 9125, agdal","sociate",10201,"active",tour2));
            add(new BoiteLettre("N° 2254, agdal","personnel",10181,"active",tour2));
            add(new BoiteLettre("N° 8214, agdal ","societe",10784,"active",tour2));
            add(new BoiteLettre("N° 6478, agdal","sociate",10421,"active",tour2));
            add(new BoiteLettre("N° 7478, agdal","sociate",10181,"active",tour2));
        }};
        tour2.setBoiteLettres(bls2);

        Set bls3 = new HashSet<BoiteLettre>(){{
            add(new BoiteLettre("N° 5562, agdal","personnel",10999,"active",tour3));
            add(new BoiteLettre("N° 925, agdal","sociate",10985,"active",tour3));
            add(new BoiteLettre("N° 54, agdal","personnel",10451,"active",tour3));
            add(new BoiteLettre("N° 8288, agdal ","societe",10789,"active",tour3));
            add(new BoiteLettre("N° 647, agdal","sociate",10452,"active",tour3));
            add(new BoiteLettre("N° 7477, agdal","personnel",10771,"active",tour3));
            add(new BoiteLettre("N° 0178, agdal","personnel",10189,"active",tour3));
        }};
        tour3.setBoiteLettres(bls3);

        Set bls4 = new HashSet<BoiteLettre>(){
            {
                add(new BoiteLettre("N° 2262, agdal", "personnel", 10222, "active", tour4));
                add(new BoiteLettre("N° 9254, agdal", "personnel", 10111, "active", tour4));
                add(new BoiteLettre("N° 5774, agdal", "personnel", 10771, "active", tour4));
                add(new BoiteLettre("N° 1188, agdal ", "societe", 10119, "active", tour4));
                add(new BoiteLettre("N° 6147, agdal", "sociate", 10152, "active", tour4));
            }};
        tour4.setBoiteLettres(bls4);

        Set bls5 = new HashSet<BoiteLettre>(){
            {
                add(new BoiteLettre("N° 2211, agdal", "personnel", 10422, "active", tour5));
                add(new BoiteLettre("N° 9114, agdal", "personnel", 10911, "active", tour5));
                add(new BoiteLettre("N° 5794, agdal", "personnel", 10551, "active", tour5));
                add(new BoiteLettre("N° 88, agdal ", "societe", 10419, "active", tour5));

            }};
        tour5.setBoiteLettres(bls5);

        tourneeRepository.save(new HashSet<Tournee>(){{
            add(tour1);
            add(tour2);
            add(tour3);
            add(tour4);
            add(tour5);
        }});
    }

}
