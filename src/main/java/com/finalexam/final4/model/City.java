package com.finalexam.final4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;
    private int Area;
    private int population;
    private int GDP;
    private String description;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    Nation nation;
}
