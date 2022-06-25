package sample.client;

import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerBestOfTheBest;
import sample.model.BestOfTheBest;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerBest implements Initializable {

    @FXML
    private TableView<BestOfTheBest> tableBest;
    @FXML
    private TableColumn<BestOfTheBest, String> nameBest;
    @FXML
    private TableColumn<BestOfTheBest, Date> dateBirthBest;
    @FXML
    private TableColumn<BestOfTheBest, String> countryBest;
    @FXML
    private TableColumn<BestOfTheBest, String> statusBest;

    ControllerBestOfTheBest cbob = new ControllerBestOfTheBest();
    List<BestOfTheBest> listBest = cbob.getAll();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameBest.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateBirthBest.setCellValueFactory(new PropertyValueFactory<>("date_birth"));
        countryBest.setCellValueFactory(new PropertyValueFactory<>("country"));
        statusBest.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableBest.setItems(bestModels);
    }

    final ObservableList<BestOfTheBest> bestModels = FXCollections.observableList(listBest);
}
