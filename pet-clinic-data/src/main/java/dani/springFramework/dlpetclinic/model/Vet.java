package dani.springFramework.dlpetclinic.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PetTypes")
public class Vet  extends Person {

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="vets_specialties",joinColumns =@JoinColumn(name="vet_id"),inverseJoinColumns=@JoinColumn(name="specialty_id"))
    private Set<Specialty>  specialties = new HashSet<>();
    public Set<Specialty> getSpecialties() {
        return specialties;
    }


    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

}
