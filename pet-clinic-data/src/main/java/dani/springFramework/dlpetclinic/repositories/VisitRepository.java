package dani.springFramework.dlpetclinic.repositories;

import dani.springFramework.dlpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
        }

