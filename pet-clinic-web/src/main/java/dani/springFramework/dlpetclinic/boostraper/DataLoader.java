package dani.springFramework.dlpetclinic.boostraper;

import dani.springFramework.dlpetclinic.model.*;
import dani.springFramework.dlpetclinic.services.OwnerService;
import dani.springFramework.dlpetclinic.services.PetTypeService;
import dani.springFramework.dlpetclinic.services.SpecialtyService;
import dani.springFramework.dlpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {

         this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() ==0 ){
            LoadData();
        }

    }

    private void LoadData() {
        Specialty radiology =  new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty surgery =  new Specialty();
        radiology.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentice =  new Specialty();
        radiology.setDescription("dentice");
        Specialty savedDentice = specialtyService.save(dentice);


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType SavedPetTypeDog = petTypeService.save(dog);
        PetType SavedPetTypeCat = petTypeService.save(cat);
        Owner owner1 = new Owner();

        owner1.setFirstName("Daniel");
        owner1.setLastName("Landau");
        //owner1.setId(1L);
        owner1.setAddress("Harimon 65");
        owner1.setCity("Holon");
        owner1.setTelephone("123456");
        ownerService.save(owner1);
        Owner owner2 = new Owner();

        owner2.setFirstName("Nissim");
        owner2.setLastName("Danino");
        owner2.setAddress("Harimon 65");
        owner2.setCity("Holon");
        owner2.setTelephone("123456");
        //owner2.setId(2L);
        ownerService.save(owner2);
        System.out.println("Owners loaded");


        Pet danisPet = new Pet();
        danisPet.setPetType(dog);
        danisPet.setName("Muki");
        danisPet.setBirthDate(LocalDate.now());
        danisPet.setOwner(owner1);
        Set<Pet> petSet = new HashSet<>();
        petSet.add(danisPet);
        owner1.setPets(petSet);

        Pet nisimsPet = new Pet();
        nisimsPet.setPetType(cat);
        nisimsPet.setName("Mitzi");
        nisimsPet.setBirthDate(LocalDate.now());
        nisimsPet.setOwner(owner2);
        petSet = new HashSet<>();
        petSet.add(nisimsPet);
        owner2.setPets(petSet);


        Vet vet1 = new Vet();
        vet1.setFirstName("Dr");
        vet1.setLastName("Dulitul");
        //vet1.setId(1L);
        vetService.save(vet1);
        vet1.getSpecialties().add(savedRadiology);
        Vet vet2 = new Vet();
        vet2.setFirstName("Dr");
        vet2.setLastName("zivago");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Vets loaded");
    }
}
