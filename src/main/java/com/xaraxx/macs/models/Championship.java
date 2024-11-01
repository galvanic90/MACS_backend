package com.xaraxx.macs.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Championship {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private Date startEventDate;
    private Date endEventDate;

    @ManyToOne
    @JoinColumn(name = "FK_location", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name="FK_club", nullable = false)
    private Club club;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartEventDate() {
        return startEventDate;
    }

    public void setStartEventDate(Date startEventDate) {
        this.startEventDate = startEventDate;
    }

    public Date getEndEventDate() {
        return endEventDate;
    }

    public void setEndEventDate(Date endEventDate) {
        this.endEventDate = endEventDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Championship championship))
            return false;
        return Objects.equals(this.id, championship.id) && Objects.equals(this.name, championship.name) && Objects.equals(this.startEventDate, championship.startEventDate)
                && Objects.equals(this.endEventDate, championship.endEventDate) && Objects.equals(this.location, championship.location) && Objects.equals(this.club, championship.club);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.startEventDate, this.endEventDate, this.location, this.club);
    }

    @Override
    public String toString() {
        return "Championship{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", startEventDate=" + startEventDate + '\'' +
                ", endEventDate=" + endEventDate +  '\'' +
                ", location=" + location +  '\'' +
                ", club=" + club +  '\'' +
                '}';
    }
}
