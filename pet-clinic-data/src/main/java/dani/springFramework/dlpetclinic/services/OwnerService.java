package dani.springFramework.dlpetclinic.services;

import dani.springFramework.dlpetclinic.model.Owner;

public interface OwnerService  extends CrudService<Owner,Long>  {

    Owner findByLastName(String lastName);

}
