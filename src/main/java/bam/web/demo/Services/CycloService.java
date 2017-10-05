package bam.web.demo.Services;

import bam.web.demo.Entities.Cyclo;
import bam.web.demo.Repositories.CycloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CycloService {
    @Autowired
    private CycloRepository cycloRepository;

   public Iterable<Cyclo> findAllCyclo(){
       return cycloRepository.findAll();
   }
}
