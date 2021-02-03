package com.mag.magasin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Enseigne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adresseSiegeSocial;
    @OneToMany(mappedBy = "enseigne")
    private Collection<Magasin> magasins = new ArrayList<>();
    @ManyToOne
    private User user;

}
