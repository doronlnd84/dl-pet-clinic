package dani.springFramework.dlpetclinic.repositories;

import dani.springFramework.dlpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
