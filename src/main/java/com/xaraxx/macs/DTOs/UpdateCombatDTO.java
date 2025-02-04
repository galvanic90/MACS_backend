package com.xaraxx.macs.DTOs;

import java.util.Objects;

public class UpdateCombatDTO {
    private Integer pointsBlue;
    private Integer pointsRed;
    private Integer athleteBlue;
    private Integer athleteRed;
    private Integer winner;

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

    public Integer getAthleteBlue() {
        return athleteBlue;
    }

    public void setAthleteBlue(Integer athleteBlue) {
        this.athleteBlue = athleteBlue;
    }

    public Integer getAthleteRed() {
        return athleteRed;
    }

    public void setAthleteRed(Integer athleteRed) {
        this.athleteRed = athleteRed;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateCombatDTO that = (UpdateCombatDTO) o;
        return Objects.equals(pointsBlue, that.pointsBlue) && Objects.equals(pointsRed, that.pointsRed) && Objects.equals(athleteBlue, that.athleteBlue) && Objects.equals(athleteRed, that.athleteRed) && Objects.equals(winner, that.winner);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(pointsBlue);
        result = 31 * result + Objects.hashCode(pointsRed);
        result = 31 * result + Objects.hashCode(athleteBlue);
        result = 31 * result + Objects.hashCode(athleteRed);
        result = 31 * result + Objects.hashCode(winner);
        return result;
    }
}
