package dani.springFramework.dlpetclinic.springdatajpa;

import dani.springFramework.dlpetclinic.model.Vet;
import dani.springFramework.dlpetclinic.repositories.VetRepository;
import dani.springFramework.dlpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VetSDJpa implements VetService {
    private final VetRepository vetRepository;

    public VetSDJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        Optional<Vet> owner = vetRepository.findById(aLong);
        return owner.orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
         vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
