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
import sample.controller.ControllerDerbyLevel;
import sample.model.DerbyLevel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerDerbyLevel2 implements Initializable {

    @FXML
    private ChoiceBox<String> derbyLevelList;
    List<String> filterList;

    public ControllerDerbyLevel2() {
        ControllerDerbyLevel cdl = new ControllerDerbyLevel();
        List<DerbyLevel> listAllDerbyLevel = cdl.getAll();
        filterList = new ArrayList<>();
        for (DerbyLevel dl : listAllDerbyLevel){

            filterList.add(dl.getLevel());
        }
        derbyLevelModel = FXCollections.observableList(filterList);
    }

    @FXML
    private void openDerbyByDerbyLevel() {
        String derbyLevel = derbyLevelList.getValue();

        ControllerSpecificDerby csd = new ControllerSpecificDerby();
        csd.setData(derbyLevel);

        Stage specificDerbyStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("specificDerby.fxml"));
            specificDerbyStage.setTitle("Derby - " + derbyLevel);
            specificDerbyStage.setResizable(false);
            specificDerbyStage.setScene(new Scene(root));
            specificDerbyStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        derbyLevelList.setItems(derbyLevelModel);
    }

    final ObservableList<String> derbyLevelModel;
}

