package com.premierLeague.PremierLeagueManager;

import com.premierLeague.PremierLeagueClubs.FootballClub;

import java.util.Comparator;

public class FootballClubsComparatorByGoals implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub f1, FootballClub f2) {
        return f1.getGoalsScored() - f2.getGoalsScored();
    }
}
