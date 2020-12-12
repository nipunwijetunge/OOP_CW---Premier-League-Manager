package com.premierLeague.GUI;

import com.premierLeague.PremierLeagueClubs.FootballClub;
import com.premierLeague.PremierLeagueManager.FootballClubComparatorByWins;
import com.premierLeague.PremierLeagueManager.FootballClubsComparatorByGoals;
import com.premierLeague.PremierLeagueManager.PremierLeagueManager;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Collections;

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

        exit.setOnAction(event -> {
            viewStage.close();
        });

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

        /*Label sort = new Label("Sort by");
        sort.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: WHITE; -fx-font-family: 'Century Gothic'");
        gp.add(sort,1,5,1,1);

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "Points",
                "Goals Scored",
                "Wins"
        );
        comboBox.getSelectionModel().selectFirst();
        gp.add(comboBox,2,5,2,1);

        if (String.valueOf(comboBox.getValue()).equals("Points")){
            leagueManager.getFootballClubList().sort(Collections.reverseOrder());
        } else if (String.valueOf(comboBox.getValue()).equals("Goals Scored")){
            Collections.sort(leagueManager.getFootballClubList(), new FootballClubsComparatorByGoals());
        } else {
            Collections.sort(leagueManager.getFootballClubList(), new FootballClubComparatorByWins());
        }*/

        Button exit = new Button("CLOSE");
        exit.setStyle("-fx-pref-height: 40; -fx-pref-width: 100; -fx-border-radius: 10; -fx-background-color: RED; " +
                "-fx-text-fill: WHITE; -fx-font-size: 20; -fx-font-family: 'Century Gothic'");
        gp.add(exit, 8, 5, 2, 1);

        exit.setOnAction(event -> {
            pointTable.close();
        });

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
                    Collections.sort(leagueManager.getFootballClubList(), new FootballClubsComparatorByGoals().reversed());
                    pointTable();
                    break;
                case "Wins":
                    Collections.sort(leagueManager.getFootballClubList(), new FootballClubComparatorByWins().reversed());
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
}
