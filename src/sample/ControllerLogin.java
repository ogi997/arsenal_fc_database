package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.ControllerAccount;
import sample.model.Account;

import java.io.IOException;


public class ControllerLogin {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;

    @FXML
    private void login() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if(username.isEmpty() || password.isEmpty()) {
            return;
        }
        Account account = new Account(username, password);
        ControllerAccount ca = new ControllerAccount();
        Account exist = ca.userExist(account);

        try {
            if(exist.getIdAccount() > 0) {
                //zatvori login prozor
                Stage login = (Stage) loginButton.getScene().getWindow();
                login.close();

                Stage adminPanelStage = new Stage();
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("admin/adminPanel.fxml"));
                    adminPanelStage.setTitle("ADMIN PANEL");
                    adminPanelStage.setResizable(false);
                    adminPanelStage.setScene(new Scene(root));
                    adminPanelStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Pogresni podaci");
        }

    }
}
