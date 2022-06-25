package sample.admin.match;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.client.ControllerShowFirstTeam;
import sample.controller.ControllerAllResults;
import sample.controller.ControllerFirstTeam;
import sample.controller.ControllerMatch;
import sample.model.AllResults;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMa implements Initializable {

    @FXML
    private TableView<AllResults> tableResult;
    @FXML
    private TableColumn<AllResults, String> rivalName;
    @FXML
    private TableColumn<AllResults, Integer> teamScored1;
    @FXML
    private TableColumn<AllResults, Integer> teamScored2;
    @FXML
    private TableColumn<AllResults, String> datePlayed;
    @FXML
    private TableColumn<AllResults, String> compName;
    @FXML
    private TableColumn<AllResults, String> season;
    @FXML
    private TableColumn<AllResults, String> wherePlayed;
    @FXML
    private Button addMatchButton;
    @FXML
    private Button updateMatchButton;



    Integer idToManipulate;

    @FXML
    private void updateMatch() {
        Stage updateMatchStage = new Stage();
        Parent root;
        try {
            ControllerUpdateMatch.setData(idToManipulate);
            root = FXMLLoader.load(getClass().getResource("updateMatch.fxml"));
            updateMatchStage.setTitle("Update match");
            updateMatchStage.setResizable(false);
            updateMatchStage.setScene(new Scene(root));
            updateMatchStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) updateMatchButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void deleteMatch() {
        ControllerMatch cm = new ControllerMatch();
        ControllerFirstTeam cft = new ControllerFirstTeam();


        if(idToManipulate > 0){
            cft.deleteFirstTeam(idToManipulate);
            cm.deleteMatch(idToManipulate);
            helpMethod();
        }

    }

    @FXML
    private void addNewMatch() {
        Stage addNewMatchStage = new Stage();
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("addNewMatch.fxml"));
                    addNewMatchStage.setTitle("Add new match");
                    addNewMatchStage.setResizable(false);
                    addNewMatchStage.setScene(new Scene(root));
                    addNewMatchStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        Stage s = (Stage) addMatchButton.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      helpMethod();

        tableResult.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)){

                if(tableResult.getSelectionModel().isEmpty())
                    return;

                idToManipulate = tableResult.getSelectionModel().getSelectedItem().getId();
            }
        });
    }

    private void helpMethod() {
        ControllerAllResults car = new ControllerAllResults();
        List<AllResults> listAllResults = car.getAll();

        final ObservableList<AllResults> resultsModel = FXCollections.observableList(listAllResults);

        rivalName.setCellValueFactory(new PropertyValueFactory<>("rivalName"));
        teamScored1.setCellValueFactory(new PropertyValueFactory<>("goals_scored"));
        teamScored2.setCellValueFactory(new PropertyValueFactory<>("goals_received"));
        datePlayed.setCellValueFactory(new PropertyValueFactory<>("date"));
        compName.setCellValueFactory(new PropertyValueFactory<>("CompatitionName"));
        season.setCellValueFactory(new PropertyValueFactory<>("year"));
        wherePlayed.setCellValueFactory(new PropertyValueFactory<>("home"));

        tableResult.setItems(resultsModel);


    }



}
