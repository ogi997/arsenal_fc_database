package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerAllTrophy;
import sample.model.AllPlayers;
import sample.model.AllTrophy;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerTrophy implements Initializable {

    @FXML
    private TableView<AllTrophy> trophyTable;
    @FXML
    private TableColumn<AllTrophy, String> seasoneTrophy;
    @FXML
    private TableColumn<AllTrophy, String> nameTrophy;

    ControllerAllTrophy cat = new ControllerAllTrophy();
    List<AllTrophy> listAllTrophy = cat.getAll();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        seasoneTrophy.setCellValueFactory(new PropertyValueFactory<>("year"));
        nameTrophy.setCellValueFactory(new PropertyValueFactory<>("name"));

        trophyTable.setItems(trophyModels);

    }

    final ObservableList<AllTrophy> trophyModels = FXCollections.observableList(listAllTrophy);
}
