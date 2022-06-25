package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerAllTransfers;
import sample.model.AllTransfers;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerTransfers implements Initializable {
    @FXML
    private TableView<AllTransfers> tableTransfer;
    @FXML
    private TableColumn<AllTransfers, String> namePlayer;
    @FXML
    private TableColumn<AllTransfers, Date> birthPlayer;
    @FXML
    private TableColumn<AllTransfers, String> wherePlayer;
    @FXML
    private TableColumn<AllTransfers, String> season;
    @FXML
    private TableColumn<AllTransfers, String> clubName;
    @FXML
    private TableColumn<AllTransfers, BigDecimal> price;

    ControllerAllTransfers cat = new ControllerAllTransfers();
    List<AllTransfers> listAllTransfers = cat.getAll();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        namePlayer.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthPlayer.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        wherePlayer.setCellValueFactory(new PropertyValueFactory<>("description"));
        season.setCellValueFactory(new PropertyValueFactory<>("year"));
        clubName.setCellValueFactory(new PropertyValueFactory<>("club_name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableTransfer.setItems(transferModels);

    }

    final ObservableList<AllTransfers> transferModels = FXCollections.observableList(listAllTransfers);
}
