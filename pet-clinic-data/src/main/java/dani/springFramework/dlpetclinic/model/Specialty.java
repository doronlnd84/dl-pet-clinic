package dani.springFramework.dlpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Specialty")
public class Specialty extends BaseEntity {

    @Column(name="description")
    private  String description;



}
