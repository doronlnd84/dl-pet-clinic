package dani.springFramework.dlpetclinic.repositories;

import dani.springFramework.dlpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
