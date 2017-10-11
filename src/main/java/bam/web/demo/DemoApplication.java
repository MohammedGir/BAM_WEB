package bam.web.demo;

import bam.web.demo.Initializers.InitDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private InitDataBase initDataBase;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

	    initDataBase.initSite();
	    initDataBase.initTournee();
	    initDataBase.initFacteur();
        initDataBase.initCyclo();
        initDataBase.initBLS();

	}

}
