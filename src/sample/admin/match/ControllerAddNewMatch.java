package sample.admin.match;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.controller.*;
import sample.model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerAddNewMatch implements Initializable {

    @FXML
    private ChoiceBox<String> rivalTeam;
    @FXML
    private TextField goalScored;
    @FXML
    private TextField goalReceived;
    @FXML
    private ChoiceBox<String> season;
    @FXML
    private ChoiceBox<String> comatition;
    @FXML
    private DatePicker dateMatch;
    @FXML
    private ChoiceBox<String> wherePlayed;
    @FXML
    private Button addButton;

//    @FXML
//    private TableView<AllPlayers> playerTable;
//    @FXML
//    private TableColumn<AllPlayers, String> name;
//    @FXML
//    private TableColumn<AllPlayers, String> position;
//    @FXML
//    private TableColumn<AllPlayers, Boolean> check;


    ControllerRival cr = new ControllerRival();
    ControllerSeasone cs = new ControllerSeasone();
    ControllerCompatition cc = new ControllerCompatition();

    List<String> filterRival = new ArrayList<>();
    List<String> filterSeason = new ArrayList<>();
    List<String> filterCompatation = new ArrayList<>();

    List<String> filterWherePlayed = new ArrayList<>();

    public ControllerAddNewMatch() {
        List<Rival> listRival = cr.getAll();
        for(Rival r : listRival)
            filterRival.add(r.getName());

        List<Seasone>  listSeason = cs.getAll();
        for(Seasone s : listSeason)
            filterSeason.add(s.getYear());

        List<Compatition> listCompatation = cc.getAll();
        for(Compatition c : listCompatation)
            filterCompatation.add(c.getName());

        filterWherePlayed.add("Home");
        filterWherePlayed.add("Away");
    }

    @FXML
    private void addMatch() {
        ControllerRival cr = new ControllerRival();
        ControllerSeasone cs = new ControllerSeasone();
        ControllerCompatition cc = new ControllerCompatition();

        String rivalName = rivalTeam.getValue();
        Integer idRival = cr.getIdByRivalName(rivalName);

        Integer scored = Integer.valueOf(goalScored.getText());
        Integer received = Integer.valueOf(goalReceived.getText());

        String seasonPlay = season.getValue();
        Integer idSeason = cs.getIdBySeason(seasonPlay);

        String comPlay = comatition.getValue();
        Integer idCompatition = cc.getIdByName(comPlay);

        Date date = Date.valueOf(dateMatch.getValue());
        String home = wherePlayed.getValue();

        Match match = new Match(idRival, scored, received, idSeason, idCompatition, date, (home.equals("Home")) ? (short) 1 : (short) 0);
        ControllerMatch conMatch = new ControllerMatch();
        ControllerFirstTeam conFirstTeam = new ControllerFirstTeam();
        conMatch.addMatch(match);
        conFirstTeam.addFirstTeam(match);

        Stage updateMatchStage = new Stage();
        Parent root;
        try {

            root = FXMLLoader.load(getClass().getResource("match.fxml"));
            updateMatchStage.setTitle("match");
            updateMatchStage.setResizable(false);
            updateMatchStage.setScene(new Scene(root));
            updateMatchStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) addButton.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rivalTeam.setItems(rivalModels);
        season.setItems(seasonModels);
        comatition.setItems(compatationModels);
        wherePlayed.setItems(wherePlayedModels);
    }

    final ObservableList<String> rivalModels = FXCollections.observableList(filterRival);
    final ObservableList<String> seasonModels = FXCollections.observableList(filterSeason);
    final ObservableList<String> compatationModels = FXCollections.observableList(filterCompatation);
    final ObservableList<String> wherePlayedModels = FXCollections.observableList(filterWherePlayed);
}
