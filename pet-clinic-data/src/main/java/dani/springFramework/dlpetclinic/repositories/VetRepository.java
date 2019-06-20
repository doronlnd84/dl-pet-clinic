package dani.springFramework.dlpetclinic.repositories;

import dani.springFramework.dlpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
