package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerFamousPersons;
import sample.model.FamousPersons;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerFamous implements Initializable {

    @FXML
    private TableView<FamousPersons> tableFamous;
    @FXML
    private TableColumn<FamousPersons, String> nameFamous;
    @FXML
    private TableColumn<FamousPersons, Date> dateBirthFamous;
    @FXML
    private TableColumn<FamousPersons, String> countryFamous;
    @FXML
    private TableColumn<FamousPersons, String> statusFamous;
    @FXML
    private TableColumn<FamousPersons, String> levelFamous;

    ControllerFamousPersons cfp = new ControllerFamousPersons();
    List<FamousPersons> listFamousPersons = cfp.getAll();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameFamous.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateBirthFamous.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        countryFamous.setCellValueFactory(new PropertyValueFactory<>("country"));
        statusFamous.setCellValueFactory(new PropertyValueFactory<>("status"));
        levelFamous.setCellValueFactory(new PropertyValueFactory<>("level"));
        tableFamous.setItems(famousPersonsModel);
    }

    final ObservableList<FamousPersons> famousPersonsModel = FXCollections.observableList(listFamousPersons);
}
