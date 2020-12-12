package com.premierLeague.PremierLeagueManager;

import com.premierLeague.PremierLeagueClubs.FootballClub;

import java.util.Comparator;

public class FootballClubComparatorByWins implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        return o1.getWins() - o2.getWins();
    }
}
