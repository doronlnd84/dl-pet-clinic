package dani.springFramework.dlpetclinic.springdatajpa;

import dani.springFramework.dlpetclinic.model.PetType;
import dani.springFramework.dlpetclinic.repositories.PetTypeRepository;
import dani.springFramework.dlpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        Optional<PetType> types = petTypeRepository.findById(aLong);
        return types.orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
