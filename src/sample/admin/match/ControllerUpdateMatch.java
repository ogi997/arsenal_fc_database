package sample.admin.match;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.*;
import sample.model.Compatition;
import sample.model.Match;
import sample.model.Rival;
import sample.model.Seasone;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerUpdateMatch implements Initializable {

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
    private Button updateButton;

    @FXML
    private void updateMatch() {
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

        Match match = new Match(data, idRival, scored, received, idSeason, idCompatition, date, (home.equals("Home")) ? (short) 1 : (short) 0);
        ControllerMatch conMatch = new ControllerMatch();
        conMatch.updateMatch(match);

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
        Stage s = (Stage) updateButton.getScene().getWindow();
        s.close();

    }

    ControllerMatch cm = new ControllerMatch();
    ControllerRival cr = new ControllerRival();
    ControllerSeasone cs = new ControllerSeasone();
    ControllerCompatition cc = new ControllerCompatition();

    private static Integer data;
    public static void setData(Integer data) {
        ControllerUpdateMatch.data = data;
    }

    List<String> filterRival = new ArrayList<>();
    List<String> filterSeason = new ArrayList<>();
    List<String> filterCompatation = new ArrayList<>();

    List<String> filterWherePlayed = new ArrayList<>();

    public ControllerUpdateMatch() {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(data == 0)
            return;

        rivalTeam.setItems(rivalModels);
        season.setItems(seasonModels);
        comatition.setItems(compatationModels);
        wherePlayed.setItems(wherePlayedModels);

        Match match = cm.getMatchById(data);

        Rival rival = cr.getRivalById(match.getRival_id());
        Seasone seas = cs.getSeasoneById(match.getSeasone_id_for_match());
        Compatition comp = cc.getCompatitionById(match.getGame_id());

       rivalTeam.getSelectionModel().select(rival.getName());
       season.getSelectionModel().select(seas.getYear());
       comatition.getSelectionModel().select(comp.getName());
       wherePlayed.getSelectionModel().select(match.getHome() == (short)1 ? "Home" : "Away" );

        goalScored.setText(String.valueOf(match.getGoals_scored()));
        goalReceived.setText(String.valueOf(match.getGoals_received()));

        LocalDate localDate = match.getDate().toLocalDate();
        dateMatch.setValue(localDate);

    }
    final ObservableList<String> rivalModels = FXCollections.observableList(filterRival);
    final ObservableList<String> seasonModels = FXCollections.observableList(filterSeason);
    final ObservableList<String> compatationModels = FXCollections.observableList(filterCompatation);
    final ObservableList<String> wherePlayedModels = FXCollections.observableList(filterWherePlayed);
}
