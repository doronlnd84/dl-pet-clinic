package dani.springFramework.dlpetclinic.map;

import dani.springFramework.dlpetclinic.model.Visit;
import dani.springFramework.dlpetclinic.services.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit,Long>  implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getId() == null ||
                visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null  ) {
            throw new RuntimeException("Invalid visit");
        }
    return super.save(visit);
    }

}
