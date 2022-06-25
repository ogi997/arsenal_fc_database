package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerAllResults;
import sample.model.ShowFirstTeam;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerShowFirstTeam implements Initializable {
    @FXML
    private TableView<ShowFirstTeam> tableFirstTeam;
    @FXML
    private TableColumn<ShowFirstTeam, String> showName;
    @FXML
    private TableColumn<ShowFirstTeam, String> showNumber;
    @FXML
    private TableColumn<ShowFirstTeam, String> showPosition;
    @FXML
    private TableColumn<ShowFirstTeam, String> showRole;
    @FXML
    private TableColumn<ShowFirstTeam, String> showCountry;

    private static Integer data;
    public static void setData(Integer data) {
        ControllerShowFirstTeam.data = data;
    }

    ControllerAllResults car = new ControllerAllResults();
    List<ShowFirstTeam> listFirstTeam = car.getFirstTeamByMatchId(data);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showName.setCellValueFactory(new PropertyValueFactory<>("name"));
        showNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        showPosition.setCellValueFactory(new PropertyValueFactory<>("description"));
        showRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        showCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        tableFirstTeam.setItems(firstTeamModels);
    }

    final ObservableList<ShowFirstTeam> firstTeamModels = FXCollections.observableList(listFirstTeam);

}
