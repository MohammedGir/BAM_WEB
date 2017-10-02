package bam.web.demo.Services;

import bam.web.demo.Entities.Tournee;
import bam.web.demo.Repositories.TourneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourneeService {
    @Autowired
    private TourneeRepository tourneeRepository;

    public Iterable<Tournee> findAllTournee(){
        return tourneeRepository.findAll();
    }
}
