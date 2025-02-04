package com.xaraxx.macs.DTOs.combat;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchDTO {
    String id;
    String title;
    String winner;
    FeedInDTO feedIn;
    TeamDTO team1;
    TeamDTO team2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public FeedInDTO getFeedIn() {
        return feedIn;
    }

    public void setFeedIn(FeedInDTO feedIn) {
        this.feedIn = feedIn;
    }

    public TeamDTO getTeam1() {
        return team1;
    }

    public void setTeam1(TeamDTO team1) {
        this.team1 = team1;
    }

    public TeamDTO getTeam2() {
        return team2;
    }

    public void setTeam2(TeamDTO team2) {
        this.team2 = team2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchDTO matchDTO = (MatchDTO) o;
        return Objects.equals(id, matchDTO.id) && Objects.equals(title, matchDTO.title) && Objects.equals(winner, matchDTO.winner) && Objects.equals(feedIn, matchDTO.feedIn) && Objects.equals(team1, matchDTO.team1) && Objects.equals(team2, matchDTO.team2);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(winner);
        result = 31 * result + Objects.hashCode(feedIn);
        result = 31 * result + Objects.hashCode(team1);
        result = 31 * result + Objects.hashCode(team2);
        return result;
    }
}
