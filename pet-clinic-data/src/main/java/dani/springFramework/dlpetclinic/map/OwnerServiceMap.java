package dani.springFramework.dlpetclinic.map;

import dani.springFramework.dlpetclinic.model.Owner;
import dani.springFramework.dlpetclinic.services.OwnerService;
import dani.springFramework.dlpetclinic.services.PetService;
import dani.springFramework.dlpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap( PetTypeService petTypeService,PetService petService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
    super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
System.out.println("IN SAVE");
        if(object != null){
            System.out.println("Owner object is not null");
            if(object.getPets() != null){
                System.out.println("Owner object Has pets");
                object.getPets().forEach(pet-> {
                    if(pet.getPetType() != null) {
                        System.out.println("PET has type");

                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                            System.out.println("Owner's pet's type saved!");
                        }
                    }
                    else{
                        throw new RuntimeException("Pettype is required");
                    }
                    if(pet.getId() == null){
                       pet.setId(petService.save(pet).getId()) ;
                    }
                        });
            }
            return super.save(object);
        }
        else
        {
            return  null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
