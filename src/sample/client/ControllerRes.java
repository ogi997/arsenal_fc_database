package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.controller.ControllerAllResults;
import sample.model.AllResults;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerRes implements Initializable {

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

    ControllerAllResults car = new ControllerAllResults();
    List<AllResults> listAllResults = car.getAll();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        rivalName.setCellValueFactory(new PropertyValueFactory<>("rivalName"));
        teamScored1.setCellValueFactory(new PropertyValueFactory<>("goals_scored"));
        teamScored2.setCellValueFactory(new PropertyValueFactory<>("goals_received"));
        datePlayed.setCellValueFactory(new PropertyValueFactory<>("date"));
        compName.setCellValueFactory(new PropertyValueFactory<>("CompatitionName"));
        season.setCellValueFactory(new PropertyValueFactory<>("year"));
        wherePlayed.setCellValueFactory(new PropertyValueFactory<>("home"));

        tableResult.setItems(resultsModel);

        tableResult.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                ControllerShowFirstTeam.setData(tableResult.getSelectionModel().getSelectedItem().getId());

                Stage allPlayersContract = new Stage();
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("showFirstTeam.fxml"));
                    allPlayersContract.setTitle("First team vs " + tableResult.getSelectionModel().getSelectedItem().getRivalName());
                    allPlayersContract.setResizable(false);
                    allPlayersContract.setScene(new Scene(root));
                    allPlayersContract.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    final ObservableList<AllResults> resultsModel = FXCollections.observableList(listAllResults);
}
