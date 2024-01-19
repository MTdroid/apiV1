package ru.kata.entity.adminUserRestController;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlElement;


@Data
@EqualsAndHashCode
@Table(name = "roles")
public class RoleTable {


    @Id
    @Column(name = "id")
    @XmlElement(name = "role_id", required = true)
    private Integer id;


    @XmlElement(name = "name", required = true)
    @Column(name = "dtype")
    private String name;

}
