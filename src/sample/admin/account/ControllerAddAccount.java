package sample.admin.account;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.ControllerAccount;
import sample.controller.ControllerCountry;
import sample.model.Account;

import java.io.IOException;


public class ControllerAddAccount {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button addButton;

    Account account = new Account();

    @FXML
    private void addAccount() {
        if(username.getText().isEmpty() || password.getText().isEmpty())
            return;
        account.setUsername(username.getText());
        account.setPassword(password.getText());
        ControllerAccount ca = new ControllerAccount();
        ca.save(account);

        Stage accountStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("accounts.fxml"));
            accountStage.setTitle("Accounts");
            accountStage.setResizable(false);
            accountStage.setScene(new Scene(root));
            accountStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) addButton.getScene().getWindow();
        s.close();
    }
}
