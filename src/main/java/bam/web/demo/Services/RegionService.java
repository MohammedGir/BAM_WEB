package bam.web.demo.Services;

import bam.web.demo.Entities.Region;
import bam.web.demo.Repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public Iterable<Region> findAllRegion(){
        return regionRepository.findAll();
    }

    public Region findRegionById(Long region_id){
       return regionRepository.findOne(region_id);
    }

}
