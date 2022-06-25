package sample.admin.account;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.ControllerAccount;
import sample.model.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUpdateAccount implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button updateButton;

    private static Account data;
    public static void setData(Account data) {
        ControllerUpdateAccount.data = data;
    }
    ControllerAccount ca = new ControllerAccount();
    @FXML
    private void updateButton() {
        if(username.getText().isEmpty() || password.getText().isEmpty())
            return;

        data.setUsername(username.getText());
        data.setPassword(password.getText());

        ca.update(data);

        Stage updateStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("accounts.fxml"));
            updateStage.setTitle("accounts");
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
        if(data.getIdAccount() > 0){
            username.setText(data.getUsername());
        }
    }
}
