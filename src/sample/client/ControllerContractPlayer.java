package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerManagerContract;
import sample.controller.ControllerPlayerContract;
import sample.model.ManagerContract;
import sample.model.PlayerContract;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerContractPlayer implements Initializable {
    @FXML
    private TableView<PlayerContract> tableContractPlayer;
    @FXML
    private TableColumn<PlayerContract, String> showName;
    @FXML
    private TableColumn<PlayerContract, Date> showBirth;
    @FXML
    private TableColumn<PlayerContract, Date> showSigned;
    @FXML
    private TableColumn<PlayerContract, Date> showExpired;
    @FXML
    private TableColumn<PlayerContract, BigDecimal> showMarketValue;
    @FXML
    private TableColumn<PlayerContract, BigDecimal> showSalary;

    ControllerPlayerContract cpc = new ControllerPlayerContract();
    List<PlayerContract> listPlayerContract = cpc.getAll();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showName.setCellValueFactory(new PropertyValueFactory<>("name"));
        showBirth.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        showSigned.setCellValueFactory(new PropertyValueFactory<>("signed"));
        showExpired.setCellValueFactory(new PropertyValueFactory<>("expired"));
        showMarketValue.setCellValueFactory(new PropertyValueFactory<>("market_value"));
        showSalary.setCellValueFactory(new PropertyValueFactory<>("salary_week"));

        tableContractPlayer.setItems(playerContractModels);

    }

    final ObservableList<PlayerContract> playerContractModels = FXCollections.observableList(listPlayerContract);
}
