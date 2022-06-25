package sample.admin.country;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.ControllerCountry;
import sample.model.Country;

import java.io.IOException;

public class ControllerAddCountry {

    @FXML
    private TextField nameCountry;
    @FXML
    private Button addCountry;

    Country country = new Country();
    @FXML
    private void addNewCountry() {
        if(nameCountry.getText().isEmpty())
            return;
        country.setName(nameCountry.getText());
        ControllerCountry cc = new ControllerCountry();
        cc.insertCountry(country);

        Stage countryStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("country.fxml"));
            countryStage.setTitle("Country");
            countryStage.setResizable(false);
            countryStage.setScene(new Scene(root));
            countryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) addCountry.getScene().getWindow();
        s.close();
    }
}
