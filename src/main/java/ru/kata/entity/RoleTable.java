package ru.kata.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



@Data
@EqualsAndHashCode
@Table(name = "roles")
public class RoleTable {


    @Id
    @Column(name = "id")
    @XmlElement(name = "role_id", required = true)

    private Long id;

    public void setRoleName(String roleName) {
        this.name = roleName;
    }
    @XmlElement(name = "name", required = true)
    @Column(name = "dtype")

    private String name;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
