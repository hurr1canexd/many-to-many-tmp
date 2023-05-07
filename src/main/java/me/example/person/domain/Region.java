package me.example.person.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "REGION")
@NoArgsConstructor
@Getter
@Setter
public class Region {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "region")
//    private Set<Address> addresses = new HashSet<>();

    public Region(String name) {
        this.name = name;
    }

}
