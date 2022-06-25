package sample.admin.player;

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
import sample.controller.*;
import sample.model.AllPlayers;
import sample.model.Country;
import sample.model.Player;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerPla implements Initializable {

    @FXML
    private TableView<AllPlayers> playerTable;
    @FXML
    private TableColumn<AllPlayers, String> name;
    @FXML
    private TableColumn<AllPlayers, Date> dateOfBirth;
    @FXML
    private TableColumn<AllPlayers, String> status;
    @FXML
    private TableColumn<AllPlayers, String> foot;
    @FXML
    private TableColumn<AllPlayers, String> role;
    @FXML
    private TableColumn<AllPlayers, String> position;
    @FXML
    private TableColumn<AllPlayers, String> country;
    @FXML
    private Button addNewPlayerButton;
    @FXML
    private Button updatePlayerButton;

    ControllerAllPlayers cap = new ControllerAllPlayers();
    private Integer idToManipulate;
    AllPlayers playerToUpdate;

    @FXML
    private void updatePlayer() {
        Stage updatePlayerStage = new Stage();
        Parent root;
        ControllerUpdatePla.setData(idToManipulate);
        try {
            root = FXMLLoader.load(getClass().getResource("updatePlayer.fxml"));
            updatePlayerStage.setTitle("UPDATE PLAYER");
            updatePlayerStage.setResizable(false);
            updatePlayerStage.setScene(new Scene(root));
            updatePlayerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) addNewPlayerButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void addNewPlayer() {
        Stage addNewPlayerStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("addNewPlayer.fxml"));
            addNewPlayerStage.setTitle("ADD NEW PLAYER");
            addNewPlayerStage.setResizable(false);
            addNewPlayerStage.setScene(new Scene(root));
            addNewPlayerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage s = (Stage) updatePlayerButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void deletePlayer() {
        ControllerPerson cp = new ControllerPerson();
        cp.deletePerson(idToManipulate);



        helpMethod();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        helpMethod();

        playerTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)){
                if(!playerTable.getSelectionModel().isEmpty()) {
                    idToManipulate = playerTable.getSelectionModel().getSelectedItem().getId();
                    playerToUpdate = playerTable.getSelectionModel().getSelectedItem();
                }
            }
        });


    }

    private void helpMethod() {
        List<AllPlayers> listAllPlayers = cap.getAll();
        List<AllPlayers> filterList = new ArrayList<>();
        for(AllPlayers ap : listAllPlayers) {
            if(ap.getStatus().equals("ACTIVE"))
                filterList.add(ap);
        }

        final ObservableList<AllPlayers> allPlayerModels = FXCollections.observableList(filterList);

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        foot.setCellValueFactory(new PropertyValueFactory<>("description"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        position.setCellValueFactory(new PropertyValueFactory<>("Position"));
        country.setCellValueFactory(new PropertyValueFactory<>("country"));

        playerTable.setItems(allPlayerModels);

    }
}
