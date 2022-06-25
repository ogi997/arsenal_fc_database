package sample.admin.country;

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
import sample.client.ControllerShowFirstTeam;
import sample.controller.ControllerCountry;
import sample.model.Country;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerCountry2 implements Initializable {

    @FXML
    private TableView<Country> countryTable;
    @FXML
    private TableColumn<Country, String> countryName;
    @FXML
    private Button updateButton;
    @FXML
    private Button addButton;

    private Integer idToManipulate;
    private Country countryToUpdate;
    ControllerCountry cc = new ControllerCountry();


    @FXML
    private void addNewCountry() {
        Stage addNewCountryStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("addCountry.fxml"));
            addNewCountryStage.setTitle("Country to add");
            addNewCountryStage.setResizable(false);
            addNewCountryStage.setScene(new Scene(root));
            addNewCountryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage s = (Stage) addButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void deleteCountry() {
        if(idToManipulate == null)
            return;

       Integer valid = cc.deleteCountryById(idToManipulate);
      if(valid == 1) {

          helpMethod();
      }
    }

    @FXML
    private void updateCountry() {
        if(idToManipulate == null)
            return;

        Stage updateStage = new Stage();
        Parent root;
        try {
            ControllerUpdateCountry.setData(countryToUpdate, countryTable);
            root = FXMLLoader.load(getClass().getResource("update.fxml"));
            updateStage.setTitle("Country to update");
            updateStage.setResizable(false);
            updateStage.setScene(new Scene(root));
            updateStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage s = (Stage) updateButton.getScene().getWindow();
        s.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        helpMethod();


        countryTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)){
                if(!countryTable.getSelectionModel().isEmpty()) {
                    idToManipulate = countryTable.getSelectionModel().getSelectedItem().getIdCountry();
                    countryToUpdate = countryTable.getSelectionModel().getSelectedItem();
                }
            }
        });


    }



    private void helpMethod() {
        List<Country> listCountry = cc.getAll();

        final ObservableList<Country> countryModel = FXCollections.observableList(listCountry);

        countryName.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryTable.setItems(countryModel);

    }
}
