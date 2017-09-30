package bam.web.demo;

import bam.web.demo.Entities.Region;
import bam.web.demo.Entities.Ville;
import bam.web.demo.Repositories.RegionRepository;
import bam.web.demo.Repositories.SiteRepository;
import bam.web.demo.Repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
	private RegionRepository regionRepository;
    @Autowired
    private VilleRepository villeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		Region region1 = new Region("Casa Settat");

		Set villes1 = new HashSet<Ville>(){{
            add(new Ville("Casa",region1));
			add(new Ville("Settat",region1));
		}};
		region1.setVilles(villes1);

		Region region2 = new Region("Marrakech Essaouira");
		Set villes2 = new HashSet<Ville>(){{
			add(new Ville("Marrakech",region2));
			add(new Ville("Essaouira",region2));
		}};
		region2.setVilles(villes2);

        Region region3 = new Region("Rabat Sale");
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


//		Ville casaVille = villeRepository.findOne(new Long(1));





	}
}
