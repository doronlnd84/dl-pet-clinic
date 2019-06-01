package dani.springFramework.dlpetclinic.services;

import dani.springFramework.dlpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();

}
