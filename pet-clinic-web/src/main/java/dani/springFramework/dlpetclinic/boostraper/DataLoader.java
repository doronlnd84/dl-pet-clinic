package dani.springFramework.dlpetclinic.boostraper;

import dani.springFramework.dlpetclinic.model.Owner;
import dani.springFramework.dlpetclinic.model.PetType;
import dani.springFramework.dlpetclinic.model.Vet;
import dani.springFramework.dlpetclinic.services.OwnerService;
import dani.springFramework.dlpetclinic.services.PetTypeService;
import dani.springFramework.dlpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

         this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType SavedPetTypeDog = petTypeService.save(dog);
        PetType SavedPetTypeCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Danniel");
        owner1.setLastName("Landau");
        owner1.setId(1L);
        ownerService.save(owner1);
        Owner owner2 = new Owner();

        owner2.setFirstName("Nissim");
        owner2.setLastName("Danino");
        owner2.setId(2L);
        ownerService.save(owner2);
        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr");
        vet1.setLastName("Dulitul");
        //vet1.setId(1L);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr");
        vet2.setLastName("zivago");
        //vet2.setId(3L);
        vetService.save(vet2);
         System.out.println("Vets loaded");

    }
}
