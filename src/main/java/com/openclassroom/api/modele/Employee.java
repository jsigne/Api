package com.openclassroom.api.modele;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")  // Lien avec le champ last_name de la table
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    private String mail;  // Meme nom que le champs de la table -> Pas besoin de lien @Column

    private String password;
}
