package sample.admin.country;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.ControllerCountry;
import sample.model.Country;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUpdateCountry implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private Button buttonUpdate;
    ControllerCountry cc = new ControllerCountry();

    public static Country data;
    public static TableView<Country> countryTable;
    public static void setData(Country data, TableView<Country> countryTable) {
        ControllerUpdateCountry.data = data;
        ControllerUpdateCountry.countryTable = countryTable;
    }

    @FXML
    private void updateButton() {
       data.setName(nameTextField.getText());
       cc.updateCountry(data);

        Stage updateStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("country.fxml"));
            updateStage.setTitle("Country");
            updateStage.setResizable(false);
            updateStage.setScene(new Scene(root));
            updateStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) buttonUpdate.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(data.getIdCountry() > 0){
            nameTextField.setText(data.getName());
        }
    }
}
