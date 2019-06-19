package dani.springFramework.dlpetclinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Specialty")
public class Specialty extends BaseEntity {
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="description")
    private  String description;
}
