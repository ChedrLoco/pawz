package com.pawz.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "shelters")
@Access(AccessType.PROPERTY)
public class Shelter {
    private int id;
    private String name;
    private Date opendate;

    public Shelter(String name, Date date) {
        this.name = name;
        this.opendate = date;
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
    @Column(name = "opendate", nullable = false)
    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }
}
