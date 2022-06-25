package sample.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import sample.controller.ControllerSeasone;
import sample.model.Seasone;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerSeasonTransfer implements Initializable {

    @FXML
    ChoiceBox<String> listSeason;
    List<String> filterList;

    @FXML
    private void openTransfersBySeason() {
        String season = listSeason.getValue();
        ControllerSpecTransfers csr = new ControllerSpecTransfers();
        csr.setData(season);

        Stage resultsSpecificStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("specificTransfers.fxml"));
            resultsSpecificStage.setTitle("All transfers for " + season + " season");
            resultsSpecificStage.setResizable(false);
            resultsSpecificStage.setScene(new Scene(root));
            resultsSpecificStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ControllerSeasonTransfer() {
        ControllerSeasone cs = new ControllerSeasone();
        List<Seasone> listS = cs.getAll();
        filterList = new ArrayList<>();
        for(Seasone s : listS) {
            filterList.add(s.getYear());
        }
        seasonModels = FXCollections.observableList(filterList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listSeason.setItems(seasonModels);
    }
    final ObservableList<String> seasonModels;
}
