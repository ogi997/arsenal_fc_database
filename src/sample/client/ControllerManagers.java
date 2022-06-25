package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerAllManagers;
import sample.model.AllManagers;
import sample.model.Manager;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerManagers implements Initializable {
    @FXML
    private TableView<AllManagers> managerTable;
    @FXML
    private TableColumn<AllManagers, String> managerName;
    @FXML
    private TableColumn<AllManagers, String> managerDateBirth;
    @FXML
    private TableColumn<AllManagers, String> managerCountry;
    @FXML
    private TableColumn<AllManagers, String> managerWinPercent;
    @FXML
    private TableColumn<AllManagers, String> managerStatus;
    ControllerAllManagers cam = new ControllerAllManagers();
    List<AllManagers> listAllManager = cam.getAll();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        managerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        managerDateBirth.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        managerCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        managerWinPercent.setCellValueFactory(new PropertyValueFactory<>("winPercent"));
        managerStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        managerTable.setItems(managersModels);

    }
    final ObservableList<AllManagers> managersModels = FXCollections.observableList(listAllManager);

}
