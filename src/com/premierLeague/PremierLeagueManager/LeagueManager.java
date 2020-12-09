package com.premierLeague.PremierLeagueManager;

import com.premierLeague.PremierLeagueClubs.FootballClub;

import java.io.File;
import java.io.IOException;

public interface LeagueManager {
    void createFootballClubAndAddToPL(FootballClub f);
    void removeFootballClubFromPL(String name, int regNo);
    void displayStatsOnATeam(String name, int regNo);
    void displayPLTable();
    void addAPlayedMatch(Match match);
    void saveData(File file1, File file2) throws IOException;
    void loadData(File file1, File file2) throws IOException, ClassNotFoundException;
}
