package ru.kata.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.management.relation.Role;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode
public class UserTable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;

    @Column(name = "birthday")
    @XmlElement(name = "birthday", required = true)

    private String birthday;

    @XmlElement(name = "email", required = true)
    @Column(name = "email")

    private String email;

    @XmlElement(name = "first_name", required = true)

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @XmlElement(name = "last_name", required = true)

    private String lastName;

    @Column(name = "role_id")
    @XmlElement(name = "role_id", required = true)



   /* private boolean imageFromSlack;
    private boolean isViewReport;
    private String avatarUrl;
    private String inactivation;

    private String password;*/


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}