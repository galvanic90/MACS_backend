package com.xaraxx.macs.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CombatsByChampionship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer combatNumber;
    private Integer pointsBlue;
    private Integer pointsRed;
    @ManyToOne
    @JoinColumn(name="FK_athlete_blue", referencedColumnName = "id")
    private RegistrationsByChampionship athleteBlue;
    @ManyToOne
    @JoinColumn(name="FK_athlete_red", referencedColumnName = "id")
    private RegistrationsByChampionship athleteRed;
    @ManyToOne
    @JoinColumn(name="FK_winner", referencedColumnName = "id")
    private RegistrationsByChampionship winner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCombatNumber() {
        return combatNumber;
    }

    public void setCombatNumber(Integer combatNumber) {
        this.combatNumber = combatNumber;
    }

    public Integer getPointsBlue() {
        return pointsBlue;
    }

    public void setPointsBlue(Integer pointsBlue) {
        this.pointsBlue = pointsBlue;
    }

    public Integer getPointsRed() {
        return pointsRed;
    }

    public void setPointsRed(Integer pointsRed) {
        this.pointsRed = pointsRed;
    }

    public RegistrationsByChampionship getAthleteBlue() {
        return athleteBlue;
    }

    public void setAthleteBlue(RegistrationsByChampionship athleteBlue) {
        this.athleteBlue = athleteBlue;
    }

    public RegistrationsByChampionship getAthleteRed() {
        return athleteRed;
    }

    public void setAthleteRed(RegistrationsByChampionship athleteRed) {
        this.athleteRed = athleteRed;
    }

    public RegistrationsByChampionship getWinner() {
        return winner;
    }

    public void setWinner(RegistrationsByChampionship winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CombatsByChampionship combats))
            return false;
        return Objects.equals(this.id, combats.id) && Objects.equals(this.combatNumber, combats.combatNumber) && Objects.equals(this.pointsBlue, combats.pointsBlue)
                && Objects.equals(combats.pointsRed, combats.pointsRed) && Objects.equals(this.athleteBlue, combats.athleteBlue)
                && Objects.equals(this.athleteRed, combats.athleteRed) && Objects.equals(this.winner, combats.winner);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.combatNumber, this.pointsBlue, this.pointsRed, this.athleteBlue, this.athleteRed, this.winner);
    }

    @Override
    public String toString() {
        return "CombatsByChampionship{" +
                "id=" + id +
                ", combatNumber=" + combatNumber +
                ", pointsBlue=" + pointsBlue +
                ", pointsRed=" + pointsRed +
                ", athleteBlue=" + athleteBlue +
                ", athleteRed=" + athleteRed +
                ", winner=" + winner +
                '}';
    }
}