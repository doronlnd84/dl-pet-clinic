package dani.springFramework.dlpetclinic.boostraper;

import dani.springFramework.dlpetclinic.model.*;
import dani.springFramework.dlpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {

         this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("in run DataLoader");
        if(petTypeService.findAll().size() ==0 ){
            LoadData();
        }

    }

    private void LoadData() {
        Specialty radiology =  new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty surgery =  new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);
    if(savedSurgery == null) {
        System.out.println("Specialty savedSurgery is null");
    }
        else if(savedSurgery.getId() == null) {
            System.out.println("Specialty savedSurgery ID is NULL");
        }
        else{
            System.out.println("Specialty savedSurgery id - ?" + savedSurgery.getId());
        }
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
        if(SavedPetTypeDog != null &&  SavedPetTypeDog.getId() !=null){
            System.out.println("SavedPetTypeDogy id - " +SavedPetTypeDog.getId());

        }

        owner1.setFirstName("Daniel");
        owner1.setLastName("Landau");
        //owner1.setId(1L);
        owner1.setAddress("Harimon 65");
        owner1.setCity("Holon");
        owner1.setTelephone("123456");


        Pet nisimsPet = new Pet();
        nisimsPet.setPetType(cat);
        nisimsPet.setName("Mitzi");
        nisimsPet.setBirthDate(LocalDate.now());
        nisimsPet.setOwner(owner1);
        owner1.getPets().add(nisimsPet);
        Owner ssavelwOwner1 =  ownerService.save(owner1);
        if(ssavelwOwner1 == null)
        {
            System.out.println("ssavelwOwner1  is NULL");

        }
        Owner owner2 = new Owner();

        owner2.setFirstName("Nissim");
        owner2.setLastName("Danino");
        owner2.setAddress("Harimon 65");
        owner2.setCity("Holon");
        owner2.setTelephone("123456");
        System.out.println("Owners loaded");


        Pet danisPet = new Pet();
        danisPet.setPetType(dog);
        danisPet.setName("Muki");
        danisPet.setBirthDate(LocalDate.now());
        danisPet.setOwner(owner2);
        owner2.getPets().add(danisPet);
        Owner saveOwner2 =  ownerService.save(owner2);


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

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("cat sick");
        catVisit.setPet(nisimsPet);

        visitService.save(catVisit);


    }
}
