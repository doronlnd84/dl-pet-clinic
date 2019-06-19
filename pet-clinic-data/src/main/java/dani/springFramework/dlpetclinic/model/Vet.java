package dani.springFramework.dlpetclinic.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vets")
public class Vet  extends Person {

    private Set<Specialty>  specialties = new HashSet<>();
    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="vets_specialties",joinColumns =@JoinColumn(name="vet_id"),inverseJoinColumns=@JoinColumn(name="specialty_id"))
    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

}
