package dani.springFramework.dlpetclinic.repositories;

import dani.springFramework.dlpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
     Owner findByLastName(String lastName);
}
