package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.controller.ControllerAllDerby;
import sample.model.AllDerby;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerSpecificDerby implements Initializable {

    @FXML
    private TableView<AllDerby> tableDerby;
    @FXML
    private TableColumn<AllDerby, String> nameRival;
    @FXML
    private TableColumn<AllDerby, String> derbyLvl;
    @FXML
    private TableColumn<AllDerby, String> stadiumName;
    @FXML
    private TableColumn<AllDerby, String> capacity;
    @FXML
    private TableColumn<AllDerby, Date> dateBuilt;

    private static String data;

    public void setData(String data) {
        ControllerSpecificDerby.data = data;
    }
    ControllerAllDerby cad = new ControllerAllDerby();
    List<AllDerby> listAllDerby = cad.getDerbyByDerbyLevel(data);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameRival.setCellValueFactory(new PropertyValueFactory<>("RivalName"));
        derbyLvl.setCellValueFactory(new PropertyValueFactory<>("level"));
        stadiumName.setCellValueFactory(new PropertyValueFactory<>("StadiumName"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        dateBuilt.setCellValueFactory(new PropertyValueFactory<>("date_built"));

        tableDerby.setItems(specificDerbyModels);

    }

    final ObservableList<AllDerby> specificDerbyModels = FXCollections.observableList(listAllDerby);
}
