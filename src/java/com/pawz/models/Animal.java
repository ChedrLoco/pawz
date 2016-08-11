package com.pawz.models;

import com.pawz.enums.Sex;
import com.pawz.enums.Species;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animals")
@Access(AccessType.PROPERTY)
public class Animal{
    private int id;
    private String name;
    private Sex sex;
    private Species species;
    private Date placementDate;
    private Shelter shelter;

    public Animal(){

    }

    public Animal(String name, Sex sex, Species species, Date placementDate) {
        this (name, sex, species, placementDate, null);
    }

    public Animal(String name, Sex sex, Species species, Date placementDate, Shelter shelter) {
        this.name = name;
        this.sex = sex;
        this.species = species;
        this.placementDate = placementDate;
        this.shelter = shelter;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "species", nullable = false )
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "placementDate", nullable = false)
    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    @ManyToOne
    @JoinColumn(name = "shelter_id", referencedColumnName = "id")
    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

}
