package sample.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAdminPanel {

    @FXML
    private void openMatch() {
        Stage matchStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("match/match.fxml"));
            matchStage.setTitle("Match");
            matchStage.setResizable(false);
            matchStage.setScene(new Scene(root));
            matchStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openPlayers() {
        Stage playerStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("player/player.fxml"));
            playerStage.setTitle("Players");
            playerStage.setResizable(false);
            playerStage.setScene(new Scene(root));
            playerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openUsers() {
        Stage accountStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("account/accounts.fxml"));
            accountStage.setTitle("Accounts");
            accountStage.setResizable(false);
            accountStage.setScene(new Scene(root));
            accountStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openCountry() {
        Stage countryStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("country/country.fxml"));
            countryStage.setTitle("Country");
            countryStage.setResizable(false);
            countryStage.setScene(new Scene(root));
            countryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
