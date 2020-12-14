package com.premierLeague.GUI;

import com.premierLeague.PremierLeagueClubs.FootballClub;
import com.premierLeague.PremierLeagueManager.FootballClubComparatorByWins;
import com.premierLeague.PremierLeagueManager.FootballClubsComparatorByGoals;
import com.premierLeague.PremierLeagueManager.Match;
import com.premierLeague.PremierLeagueManager.PremierLeagueManager;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class GUI {
    PremierLeagueManager leagueManager = PremierLeagueManager.getInstance();

    public void gui(){
        Stage viewStage = new Stage();
        viewStage.initModality(Modality.APPLICATION_MODAL);
        viewStage.setTitle("Premier League");

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #3D195B; -fx-max-width: Infinity; -fx-max-height: Infinity");
        gp.setPadding(new Insets(0,5,0,5));

        ColumnConstraints column1 = new ColumnConstraints(200);
        ColumnConstraints column2 = new ColumnConstraints(300);
        column2.setHalignment(HPos.CENTER);
        ColumnConstraints column3 = new ColumnConstraints(300);
        ColumnConstraints column4 = new ColumnConstraints(200);
        column4.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().addAll(column1,column2,column3,column4);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(15);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(5);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(15);
        row3.setValignment(VPos.CENTER);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(15);
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(15);
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(15);
        RowConstraints row7 = new RowConstraints();
        row7.setPercentHeight(5);
        RowConstraints row8 = new RowConstraints();
        row8.setPercentHeight(15);
        gp.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6,row7,row8);

        Label title = new Label("WELCOME TO PREMIER LEAGUE");
        title.setStyle("-fx-font-size: 30; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
        gp.add(title,1,0,2,1);

        Separator sep1 = new Separator();
        gp.add(sep1,1, 1, 2,1);
        Separator sep2 = new Separator();
        gp.add(sep2,1, 6, 2,1);

        Button pointTable = new Button("Points Table");
        pointTable.setStyle("-fx-pref-height: 50; -fx-pref-width: 400; -fx-border-radius: 10; -fx-background-color: DEEPPINK;" +
                " -fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(pointTable, 1, 2, 2, 1);

        Button randomMatch = new Button("Generate a Random Match");
        randomMatch.setStyle("-fx-pref-height: 50; -fx-pref-width: 400; -fx-border-radius: 10; -fx-background-color: DEEPPINK;" +
                " -fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(randomMatch, 1, 3, 2, 1);

        Button playedMatches = new Button("View All Played Matches");
        playedMatches.setStyle("-fx-pref-height: 50; -fx-pref-width: 400; -fx-border-radius: 10; -fx-background-color: DEEPPINK;" +
                " -fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(playedMatches, 1, 4, 2, 1);

        Button searchMatches = new Button("Search a Match");
        searchMatches.setStyle("-fx-pref-height: 50; -fx-pref-width: 400; -fx-border-radius: 10; -fx-background-color: DEEPPINK;" +
                " -fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(searchMatches, 1, 5, 2, 1);

        Button exit = new Button("EXIT");
        exit.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: RED; " +
                "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(exit, 3, 7, 1, 1);

        pointTable.setOnAction(event -> sortOptionSelection());

        randomMatch.setOnAction(event -> {
            try {
                randomMatchGenerator();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        playedMatches.setOnAction(event -> matchTable());

        searchMatches.setOnAction(event -> searchMatch());

        exit.setOnAction(event -> viewStage.close());

        Scene scene = new Scene(gp,1010,670);
        viewStage.setScene(scene);
        viewStage.showAndWait();
    }

    public void pointTable(){
        Stage pointTable = new Stage();
        pointTable.initModality(Modality.APPLICATION_MODAL);
        pointTable.setTitle("Premier League Point Table");

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #3D195B; -fx-max-width: Infinity; -fx-max-height: Infinity");
        gp.setPadding(new Insets(0,5,0,5));

        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(100);
        ColumnConstraints column3 = new ColumnConstraints(100);
        ColumnConstraints column4 = new ColumnConstraints(100);
        ColumnConstraints column5 = new ColumnConstraints(100);
        ColumnConstraints column6 = new ColumnConstraints(100);
        ColumnConstraints column7 = new ColumnConstraints(100);
        ColumnConstraints column8 = new ColumnConstraints(100);
        ColumnConstraints column9 = new ColumnConstraints(100);
        ColumnConstraints column10 = new ColumnConstraints(100);
        gp.getColumnConstraints().addAll(column1,column2,column3,column4,column5,column6,column7,column8,column9,column10);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(10);
        row1.setValignment(VPos.CENTER);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(3);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(64);
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(3);
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(10);
        gp.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6);

        Label title = new Label("POINTS TABLE");
        title.setStyle("-fx-font-size: 30; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 5");
        gp.add(title,4,0,3,1);

        Separator sep1 = new Separator();
        gp.add(sep1,1, 1, 8,1);
        Separator sep2 = new Separator();
        gp.add(sep2,1, 4, 8,1);

        Label lbl1 = new Label("Club Name");
        lbl1.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 110");
        Label lbl2 = new Label("Points");
        lbl2.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 30");
        Label lbl3 = new Label("Wins");
        lbl3.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 30");
        Label lbl4 = new Label("Defeats");
        lbl4.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 25");
        Label lbl5 = new Label("Draws");
        lbl5.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 30");
        Label lbl6 = new Label("Goals Rec.");
        lbl6.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 10");
        Label lbl7 = new Label("Goals Sco.");
        lbl7.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 10");

        gp.add(lbl1,0,2,3,1);
        gp.add(lbl2,3,2,1,1);
        gp.add(lbl3,4,2,1,1);
        gp.add(lbl4,5,2,1,1);
        gp.add(lbl5,6,2,1,1);
        gp.add(lbl6,7,2,1,1);
        gp.add(lbl7,8,2,1,1);

        FlowPane flowPane1 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane1);
        FlowPane flowPane2 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane2);
        FlowPane flowPane3 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane3);
        FlowPane flowPane4 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane4);
        FlowPane flowPane5 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane5);
        FlowPane flowPane6 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane6);
        FlowPane flowPane7 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane7);

        gp.add(flowPane1,0,3,3,1);
        gp.add(flowPane2,3,3,1,1);
        gp.add(flowPane3,4,3,1,1);
        gp.add(flowPane4,5,3,1,1);
        gp.add(flowPane5,6,3,1,1);
        gp.add(flowPane6,7,3,1,1);
        gp.add(flowPane7,8,3,1,1);

        Button exit = new Button("CLOSE");
        exit.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: RED; " +
                "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(exit, 8, 5, 2, 1);

        exit.setOnAction(event -> pointTable.close());

        for (FootballClub f : leagueManager.getFootballClubList()){
            Label name = new Label();
            name.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label points = new Label();
            points.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label wins = new Label();
            wins.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label defeats = new Label();
            defeats.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label draws = new Label();
            draws.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label goalsScored = new Label();
            goalsScored.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label goalsReceived = new Label();
            goalsReceived.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");

            name.setText(f.getClubName());
            points.setText(String.valueOf(f.getPoints()));
            wins.setText(String.valueOf(f.getWins()));
            defeats.setText(String.valueOf(f.getDefeats()));
            draws.setText(String.valueOf(f.getDraws()));
            goalsScored.setText(String.valueOf(f.getGoalsScored()));
            goalsReceived.setText(String.valueOf(f.getGoalsReceived()));

            flowPane1.getChildren().add(name);
            flowPane2.getChildren().add(points);
            flowPane3.getChildren().add(wins);
            flowPane4.getChildren().add(defeats);
            flowPane5.getChildren().add(draws);
            flowPane6.getChildren().add(goalsScored);
            flowPane7.getChildren().add(goalsScored);
        }

        Scene scene = new Scene(gp,1010,800);
        pointTable.setScene(scene);
        pointTable.showAndWait();
    }

    public void sortOptionSelection(){
        Stage sortOption = new Stage();
        sortOption.initModality(Modality.APPLICATION_MODAL);
        sortOption.setTitle("Sort Option Selection");

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #3D195B; -fx-max-width: Infinity; -fx-max-height: Infinity");
        gp.setPadding(new Insets(0,20,13,5));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        col1.setHalignment(HPos.CENTER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        col2.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().addAll(col1,col2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(60);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(40);
        gp.getRowConstraints().addAll(row1,row2);

        Label sort = new Label("Sort by");
        sort.setStyle("-fx-font-size: 25; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 70");
        gp.add(sort,0,0);

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "Points",
                "Goals Scored",
                "Wins"
        );
        gp.add(comboBox,1,0);

        Button go = new Button("GO");
        go.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: DEEPPINK; " +
                "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(go,0,1,2,1);

        go.setOnAction(event -> {
            switch (String.valueOf(comboBox.getValue())) {
                case "Points":
                    leagueManager.getFootballClubList().sort(Collections.reverseOrder());
                    pointTable();
                    break;
                case "Goals Scored":
                    leagueManager.getFootballClubList().sort(new FootballClubsComparatorByGoals().reversed());
                    pointTable();
                    break;
                case "Wins":
                    leagueManager.getFootballClubList().sort(new FootballClubComparatorByWins().reversed());
                    pointTable();
                    break;
            }
        });

        Scene scene = new Scene(gp,400,200);
        sortOption.setScene(scene);
        sortOption.showAndWait();
    }

    private void flowPaneGenerator(FlowPane flowPane){
        flowPane.setPadding(new Insets(10,0,0,0));
        flowPane.setVgap(1);
        flowPane.setAlignment(Pos.TOP_CENTER);
    }

    public void randomMatchGenerator() throws ParseException {
        if (leagueManager.getFootballClubList().size() >= 2) {
            Random random = new Random();
            FootballClub team1 = leagueManager.getFootballClubList().get(random.nextInt(leagueManager.getFootballClubList().size()));
            FootballClub team2 = leagueManager.getFootballClubList().get(random.nextInt(leagueManager.getFootballClubList().size()));

            while (team1.equals(team2)) {
                team2 = leagueManager.getFootballClubList().get(random.nextInt(leagueManager.getFootballClubList().size()));
            }

            int team1Score = random.nextInt(10);
            int team2Score = random.nextInt(10);

            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate today = LocalDate.now();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = Date.from(today.atStartOfDay(defaultZoneId).toInstant());

            Match match = new Match(team1.getClubName(), team2.getClubName(), team1Score, team2Score, date1);
            leagueManager.addAPlayedMatch(match);

            Alert generatedMatch = new Alert(Alert.AlertType.INFORMATION);
            generatedMatch.setTitle("Randomly Generated Match");
            generatedMatch.setContentText("Team 1 : " + team1.getClubName() + "\n" +
                    "Team 2 : " + team2.getClubName() + "\n" +
                    "Team 1 Score : " + team1Score + "\n" +
                    "Team 2 Score : " + team2Score + "\n" +
                    "Date : " + dateFormat.format(date1));
            generatedMatch.showAndWait();
        } else {
            System.out.println("Football club list empty or no enough teams!");
        }
    }

    public void matchTable(){
        Stage matchTable = new Stage();
        matchTable.initModality(Modality.APPLICATION_MODAL);
        matchTable.setTitle("Match List");

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #3D195B; -fx-max-width: Infinity; -fx-max-height: Infinity");
        gp.setPadding(new Insets(0,5,0,5));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(20);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPercentWidth(20);
        gp.getColumnConstraints().addAll(col1,col2,col3,col4,col5);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(10);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(3);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(64);
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(3);
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(10);
        gp.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6);

        Label title = new Label("MATCH LIST");
        title.setStyle("-fx-font-size: 30; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 20");
        gp.add(title,2,0,1,1);

        Separator sep1 = new Separator();
        gp.add(sep1,1,1,3,1);
        Separator sep2 = new Separator();
        gp.add(sep2,1,4,3,1);

        Label lbl1 = new Label("Date");
        lbl1.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 70");
        Label lbl2 = new Label("Team-01");
        lbl2.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 60");
        Label lbl3 = new Label("Team-02");
        lbl3.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 60");
        Label lbl4 = new Label("Team-01 Score");
        lbl4.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 45");
        Label lbl5 = new Label("Team-02 Score");
        lbl5.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 45");

        gp.add(lbl1,0,2,1,1);
        gp.add(lbl2,1,2,1,1);
        gp.add(lbl3,2,2,1,1);
        gp.add(lbl4,3,2,1,1);
        gp.add(lbl5,4,2,1,1);

        FlowPane flowPane1 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane1);
        FlowPane flowPane2 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane2);
        FlowPane flowPane3 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane3);
        FlowPane flowPane4 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane4);
        FlowPane flowPane5 = new FlowPane(Orientation.VERTICAL);
        flowPaneGenerator(flowPane5);

        gp.add(flowPane1,0,3);
        gp.add(flowPane2,1,3);
        gp.add(flowPane3,2,3);
        gp.add(flowPane4,3,3);
        gp.add(flowPane5,4,3);

        Button exit = new Button("CLOSE");
        exit.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: RED; " +
                "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(exit,4,5);

        exit.setOnAction(event -> matchTable.close());

        Collections.sort(leagueManager.getMatchList());

        for (Match m : leagueManager.getMatchList()){
            Label date = new Label();
            date.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label team1 = new Label();
            team1.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label team2 = new Label();
            team2.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label team1Score = new Label();
            team1Score.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
            Label team2Score = new Label();
            team2Score.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");

            date.setText(m.getDate());
            team1.setText(m.getTeam1());
            team2.setText(m.getTeam2());
            team1Score.setText(String.valueOf(m.getTeam1Score()));
            team2Score.setText(String.valueOf(m.getTeam2Score()));

            flowPane1.getChildren().add(date);
            flowPane2.getChildren().add(team1);
            flowPane3.getChildren().add(team2);
            flowPane4.getChildren().add(team1Score);
            flowPane5.getChildren().add(team2Score);
        }

        Scene scene = new Scene(gp,1010,800);
        matchTable.setScene(scene);
        matchTable.showAndWait();
    }

    public void searchMatch(){
        Stage sortOption = new Stage();
        sortOption.initModality(Modality.APPLICATION_MODAL);
        sortOption.setTitle("Sort Option Selection");

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: #3D195B; -fx-max-width: Infinity; -fx-max-height: Infinity");
        gp.setPadding(new Insets(0,20,13,5));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        col1.setHalignment(HPos.CENTER);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        col2.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().addAll(col1,col2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(60);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(40);
        gp.getRowConstraints().addAll(row1,row2);

        Label sort = new Label("Enter date in \"DD-MM-YYYY\" format : ");
        sort.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 60");
        gp.add(sort,0,0);

        TextField tf = new TextField();
        tf.setPromptText("eg: DD-MM-YYYY");
        gp.add(tf,1,0);

        Button search = new Button("GO");
        search.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: DEEPPINK; " +
                "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(search,0,1,2,1);

        search.setOnAction(event -> {
            if (!leagueManager.getMatchList().isEmpty()) {
                Stage matchListOnSearchedDate = new Stage();
                matchListOnSearchedDate.initModality(Modality.APPLICATION_MODAL);
                matchListOnSearchedDate.setTitle("Match List");

                GridPane gp1 = new GridPane();
                gp1.setStyle("-fx-background-color: #3D195B; -fx-max-width: Infinity; -fx-max-height: Infinity");
                gp1.setPadding(new Insets(0, 5, 0, 5));

                ColumnConstraints col01 = new ColumnConstraints();
                col01.setPercentWidth(20);
                ColumnConstraints col02 = new ColumnConstraints();
                col02.setPercentWidth(20);
                ColumnConstraints col3 = new ColumnConstraints();
                col3.setPercentWidth(20);
                ColumnConstraints col4 = new ColumnConstraints();
                col4.setPercentWidth(20);
                ColumnConstraints col5 = new ColumnConstraints();
                col5.setPercentWidth(20);
                gp1.getColumnConstraints().addAll(col01, col02, col3, col4, col5);

                RowConstraints row01 = new RowConstraints();
                row01.setPercentHeight(10);
                RowConstraints row02 = new RowConstraints();
                row02.setPercentHeight(3);
                RowConstraints row3 = new RowConstraints();
                row3.setPercentHeight(10);
                RowConstraints row4 = new RowConstraints();
                row4.setPercentHeight(64);
                RowConstraints row5 = new RowConstraints();
                row5.setPercentHeight(3);
                RowConstraints row6 = new RowConstraints();
                row6.setPercentHeight(10);
                gp1.getRowConstraints().addAll(row01, row02, row3, row4, row5, row6);

                Label title = new Label("MATCH LIST ON SEARCHED DATE");
                title.setStyle("-fx-font-size: 30; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 60");
                gp1.add(title, 1, 0, 3, 1);

                Separator sep1 = new Separator();
                gp1.add(sep1, 1, 1, 3, 1);
                Separator sep2 = new Separator();
                gp1.add(sep2, 1, 4, 3, 1);

                Label lbl1 = new Label("Date");
                lbl1.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 70");
                Label lbl2 = new Label("Team-01");
                lbl2.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 60");
                Label lbl3 = new Label("Team-02");
                lbl3.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 60");
                Label lbl4 = new Label("Team-01 Score");
                lbl4.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 45");
                Label lbl5 = new Label("Team-02 Score");
                lbl5.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'; -fx-padding: 0 0 0 45");

                gp1.add(lbl1, 0, 2, 1, 1);
                gp1.add(lbl2, 1, 2, 1, 1);
                gp1.add(lbl3, 2, 2, 1, 1);
                gp1.add(lbl4, 3, 2, 1, 1);
                gp1.add(lbl5, 4, 2, 1, 1);

                FlowPane flowPane1 = new FlowPane(Orientation.VERTICAL);
                flowPaneGenerator(flowPane1);
                FlowPane flowPane2 = new FlowPane(Orientation.VERTICAL);
                flowPaneGenerator(flowPane2);
                FlowPane flowPane3 = new FlowPane(Orientation.VERTICAL);
                flowPaneGenerator(flowPane3);
                FlowPane flowPane4 = new FlowPane(Orientation.VERTICAL);
                flowPaneGenerator(flowPane4);
                FlowPane flowPane5 = new FlowPane(Orientation.VERTICAL);
                flowPaneGenerator(flowPane5);

                gp1.add(flowPane1, 0, 3);
                gp1.add(flowPane2, 1, 3);
                gp1.add(flowPane3, 2, 3);
                gp1.add(flowPane4, 3, 3);
                gp1.add(flowPane5, 4, 3);

                Button exit = new Button("CLOSE");
                exit.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: RED; " +
                        "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
                gp1.add(exit, 4, 5);

                exit.setOnAction(event1 -> matchListOnSearchedDate.close());

                if (!tf.getText().isEmpty()) {
                    for (Match m : leagueManager.getMatchList()) {
                        if (tf.getText().equals(m.getDate())) {
                            Label date = new Label();
                            date.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
                            Label team1 = new Label();
                            team1.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
                            Label team2 = new Label();
                            team2.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
                            Label team1Score = new Label();
                            team1Score.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
                            Label team2Score = new Label();
                            team2Score.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");

                            date.setText(m.getDate());
                            team1.setText(m.getTeam1());
                            team2.setText(m.getTeam2());
                            team1Score.setText(String.valueOf(m.getTeam1Score()));
                            team2Score.setText(String.valueOf(m.getTeam2Score()));

                            flowPane1.getChildren().add(date);
                            flowPane2.getChildren().add(team1);
                            flowPane3.getChildren().add(team2);
                            flowPane4.getChildren().add(team1Score);
                            flowPane5.getChildren().add(team2Score);
                        }
                    }
                    Scene scene = new Scene(gp1, 1010, 800);
                    matchListOnSearchedDate.setScene(scene);
                    matchListOnSearchedDate.showAndWait();
                } else {
                    Alert emptyMatchList = new Alert(Alert.AlertType.WARNING);
                    emptyMatchList.setTitle("ERROR!");
                    emptyMatchList.setContentText("Please enter date to search!");
                    emptyMatchList.showAndWait();
                }

            } else {
                Alert emptyMatchList = new Alert(Alert.AlertType.WARNING);
                emptyMatchList.setTitle("ERROR!");
                emptyMatchList.setContentText("There are no matches played yet!");
                emptyMatchList.showAndWait();
            }
        });

        Scene scene = new Scene(gp,800,300);
        sortOption.setScene(scene);
        sortOption.showAndWait();
    }
}
