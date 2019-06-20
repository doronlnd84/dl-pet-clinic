package dani.springFramework.dlpetclinic.repositories;

import dani.springFramework.dlpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository  extends CrudRepository<Specialty,Long> {
        }
