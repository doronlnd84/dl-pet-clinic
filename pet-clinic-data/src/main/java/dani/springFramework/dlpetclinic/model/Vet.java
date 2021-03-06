package dani.springFramework.dlpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="PetTypes")
public class Vet  extends Person {

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="vets_specialties",joinColumns =@JoinColumn(name="vet_id"),inverseJoinColumns=@JoinColumn(name="specialty_id"))
    private Set<Specialty>  specialties = new HashSet<>();

}
