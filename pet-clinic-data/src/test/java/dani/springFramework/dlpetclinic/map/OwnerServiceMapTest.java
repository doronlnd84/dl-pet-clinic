package dani.springFramework.dlpetclinic.map;

import dani.springFramework.dlpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).lastName(lastName).build());
    }


    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());

    }

    @Test
    void findById() {
       Owner o =  ownerServiceMap.findById(ownerId);
       assertEquals(ownerId,o.getId());
    }

    @Test
    void SaveExistingId() {
        Long id = 2L;
        Owner o2 = Owner.builder().id(id).build();
        Owner savedO = ownerServiceMap.save(o2);
        assertEquals(id,savedO.getId());

    }
    @Test
    void SaveNoId() {
        Owner o = Owner.builder().build();
        Owner savedO = ownerServiceMap.save(o);
        assertNotNull(savedO);
        assertNotNull(savedO.getId());

    }


    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }


    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId, smith.getId());

    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerServiceMap.findByLastName("foo");

        assertNull(smith);
    }
}