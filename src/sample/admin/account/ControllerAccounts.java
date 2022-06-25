package sample.admin.account;

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
import sample.admin.country.ControllerUpdateCountry;
import sample.controller.ControllerAccount;
import sample.model.Account;
import sample.model.Country;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerAccounts implements Initializable {

    @FXML
    private TableView<Account> accountTable;
    @FXML
    private TableColumn<Account, String> nameAccount;
    @FXML
    private Button addNewAccount;
    @FXML
    private Button updateAccount;

    private Integer idToManipulate;
    private Account accountToUpdate;
    ControllerAccount ca = new ControllerAccount();

    @FXML
    private void addNewAccount() {
        Stage addNewAccountStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("addAccount.fxml"));
            addNewAccountStage.setTitle("Account to add");
            addNewAccountStage.setResizable(false);
            addNewAccountStage.setScene(new Scene(root));
            addNewAccountStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage s = (Stage) addNewAccount.getScene().getWindow();
        s.close();
    }

    @FXML
    private void deleteCountry() {
        if(idToManipulate == null)
            return;
        Account account = new Account(idToManipulate);
        Integer valid = ca.deleteAccount(account);
        if(valid == 1) {
            helpMethod();
        }
    }

    @FXML
    private void updateAccount() {
        if(idToManipulate == null)
            return;

        Stage updateStage = new Stage();
        Parent root;
        try {
            ControllerUpdateAccount.setData(accountToUpdate);
            root = FXMLLoader.load(getClass().getResource("updateAccount.fxml"));
            updateStage.setTitle("Country to update");
            updateStage.setResizable(false);
            updateStage.setScene(new Scene(root));
            updateStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage s = (Stage) updateAccount.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        helpMethod();

        accountTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)){
                if(!accountTable.getSelectionModel().isEmpty()) {
                    idToManipulate = accountTable.getSelectionModel().getSelectedItem().getIdAccount();
                    accountToUpdate = accountTable.getSelectionModel().getSelectedItem();
                }
            }
        });
    }

    private void helpMethod() {
        List<Account> listAccount = ca.getAll();

        final ObservableList<Account> accountModels = FXCollections.observableList(listAccount);

        nameAccount.setCellValueFactory(new PropertyValueFactory<>("username"));
        accountTable.setItems(accountModels);

    }
}
