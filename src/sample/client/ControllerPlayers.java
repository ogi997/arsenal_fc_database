package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerAllPlayers;
import sample.model.AllPlayers;


import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerPlayers implements Initializable {
    @FXML
    private TableView<AllPlayers> playerTable;
    @FXML
    private TableColumn<AllPlayers, String> playerName;
    @FXML
    private TableColumn<AllPlayers, Date> playerDateBirth;
    @FXML
    private TableColumn<AllPlayers, String> playerFoot;
    @FXML
    private TableColumn<AllPlayers, String> playerPosition;
    @FXML
    private TableColumn<AllPlayers, String> playerStatus;
    @FXML
    private TableColumn<AllPlayers, String> playerCountry;
    @FXML
    private  TableColumn<AllPlayers, String> playerRole;

    ControllerAllPlayers cap = new ControllerAllPlayers();
    List<AllPlayers> listAllPlayers = cap.getAll();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerDateBirth.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        playerFoot.setCellValueFactory(new PropertyValueFactory<>("description"));
        playerPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        playerStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        playerCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        playerRole.setCellValueFactory(new PropertyValueFactory<>("role"));

        playerTable.setItems(playersModels);

    }

    final ObservableList<AllPlayers> playersModels = FXCollections.observableList(listAllPlayers);
}
