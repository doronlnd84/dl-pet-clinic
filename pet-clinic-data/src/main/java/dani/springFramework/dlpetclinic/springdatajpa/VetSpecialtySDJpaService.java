package dani.springFramework.dlpetclinic.springdatajpa;

import dani.springFramework.dlpetclinic.model.Specialty;
import dani.springFramework.dlpetclinic.repositories.SpecialityRepository;
import dani.springFramework.dlpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VetSpecialtySDJpaService  implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public VetSpecialtySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialityRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        Optional<Specialty> specialty = specialityRepository.findById(aLong);
        return specialty.orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
    specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
specialityRepository.deleteById(aLong);
    }
}
