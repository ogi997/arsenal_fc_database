package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerManagerContract;
import sample.model.ContractManager;
import sample.model.ManagerContract;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerContractManager implements Initializable {

    @FXML
    private TableView<ManagerContract> tableContractManager;
    @FXML
    private TableColumn<ManagerContract, String> showName;
    @FXML
    private TableColumn<ManagerContract, Date> showBirth;
    @FXML
    private TableColumn<ManagerContract, Date> showSigned;
    @FXML
    private TableColumn<ManagerContract, Date> showExpired;
    @FXML
    private TableColumn<ManagerContract, BigDecimal> showMarketValue;
    @FXML
    private TableColumn<ManagerContract, BigDecimal> showSalary;

    ControllerManagerContract cmc = new ControllerManagerContract();
    List<ManagerContract> listContractManager = cmc.getAll();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showName.setCellValueFactory(new PropertyValueFactory<>("name"));
        showBirth.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        showSigned.setCellValueFactory(new PropertyValueFactory<>("signed"));
        showExpired.setCellValueFactory(new PropertyValueFactory<>("expired"));
        showMarketValue.setCellValueFactory(new PropertyValueFactory<>("market_value"));
        showSalary.setCellValueFactory(new PropertyValueFactory<>("salary_week"));

        tableContractManager.setItems(managerContractModels);
    }

    final ObservableList<ManagerContract> managerContractModels = FXCollections.observableList(listContractManager);
}
