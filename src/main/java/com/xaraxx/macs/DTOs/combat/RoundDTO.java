package com.xaraxx.macs.DTOs.combat;

import java.util.List;
import java.util.Objects;

public class RoundDTO {
    List<MatchDTO> matchs;

    public List<MatchDTO> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<MatchDTO> matchs) {
        this.matchs = matchs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoundDTO roundDTO = (RoundDTO) o;
        return Objects.equals(matchs, roundDTO.matchs);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matchs);
    }
}
