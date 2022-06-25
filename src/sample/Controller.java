package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.controller.*;
import sample.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //about arsenal fc labels
    @FXML
    private Label clubNameLabel;
    @FXML
    private Label clubNicknameLabel;
    @FXML
    private Label clubOwnerLabel;
    @FXML
    private Label clubFoundLabel;
    @FXML
    private Label clubContactLabel;
    @FXML
    private Label clubCityLabel;
    @FXML
    private Label clubAddressLabel;
    @FXML
    private Label clubValueLabel;

    //about stadium labels
    @FXML
    private Label stadiumNameLabel;
    @FXML
    private Label stadiumBuiltLabel;
    @FXML
    private Label stadiumCapacityLabel;
    @FXML
    private Label stadiumLengthLabel;
    @FXML
    private Label stadiumWidthLabel;

    @FXML
    private void openLogin() {
        Stage loginStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            loginStage.setTitle("LOGIN");
            loginStage.setResizable(false);
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allPlayersContract() {
        Stage allPlayersContract = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/contractPlayer.fxml"));
            allPlayersContract.setTitle("All contract players");
            allPlayersContract.setResizable(false);
            allPlayersContract.setScene(new Scene(root));
            allPlayersContract.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allManagersContract() {
        Stage allManagersContract = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/contractManager.fxml"));
            allManagersContract.setTitle("All contract managers");
            allManagersContract.setResizable(false);
            allManagersContract.setScene(new Scene(root));
            allManagersContract.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allTransfersBySeason() {
        Stage selectSeasonForTransferStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/selectSeasonForTransfers.fxml"));
            selectSeasonForTransferStage.setTitle("All transfers");
            selectSeasonForTransferStage.setResizable(false);
            selectSeasonForTransferStage.setScene(new Scene(root));
            selectSeasonForTransferStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allTransfers() {
        Stage transferStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/transfers.fxml"));
            transferStage.setTitle("All transfers");
            transferStage.setResizable(false);
            transferStage.setScene(new Scene(root));
            transferStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allResultsBySeason() {
        Stage selectSeasonStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/selectSeasoneForResults.fxml"));
            selectSeasonStage.setTitle("Select season");
            selectSeasonStage.setResizable(false);
            selectSeasonStage.setScene(new Scene(root));
            selectSeasonStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allResults() {
        Stage resultsStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/results.fxml"));
            resultsStage.setTitle("All results");
            resultsStage.setResizable(false);
            resultsStage.setScene(new Scene(root));
            resultsStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allDerbyByLevel() {
        Stage derbyLevelStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/derbyLevel.fxml"));
            derbyLevelStage.setTitle("All derby");
            derbyLevelStage.setResizable(false);
            derbyLevelStage.setScene(new Scene(root));
            derbyLevelStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allDerby() {
        Stage derbyStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/derby.fxml"));
            derbyStage.setTitle("All derby");
            derbyStage.setResizable(false);
            derbyStage.setScene(new Scene(root));
            derbyStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allFamousPersons() {
        Stage bestStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/famous.fxml"));
            bestStage.setTitle("All famous persons");
            bestStage.setResizable(false);
            bestStage.setScene(new Scene(root));
            bestStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void bestOfTheBest() {
        Stage bestStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/bestOfTheBest.fxml"));
            bestStage.setTitle("Best Managers & Players");
            bestStage.setResizable(false);
            bestStage.setScene(new Scene(root));
            bestStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allTrophy() {
        Stage trophyStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/trophys.fxml"));
            trophyStage.setTitle("All trophy");
            trophyStage.setResizable(false);
            trophyStage.setScene(new Scene(root));
            trophyStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allPlayers() {
        Stage playerStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/players.fxml"));
            playerStage.setTitle("All players");
            playerStage.setResizable(false);
            playerStage.setScene(new Scene(root));
            playerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void allManagers() {
        Stage managerStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("client/managers.fxml"));
            managerStage.setTitle("All managers");
            managerStage.setResizable(false);
            managerStage.setScene(new Scene(root));
            managerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        pregled info o arsenal FC
        ControllerFootballClub cfb = new ControllerFootballClub();
        ControllerStadium cs = new ControllerStadium();
        ControllerCity cc = new ControllerCity();

        FootballClub fc = cfb.getAll();
        Stadium s = cs.getStadiumById(fc.getStadium_id_for_fc());
        City c = cc.getCityById(fc.getStadium_id_for_fc());

        clubAddressLabel.setText(fc.getAddress());
        clubContactLabel.setText(fc.getContract());
        clubFoundLabel.setText(String.valueOf(fc.getFounded()));
        clubOwnerLabel.setText(fc.getOwner());
        clubNameLabel.setText(fc.getName());
        clubNicknameLabel.setText(fc.getNick_name());
        String[] arr = String.valueOf(fc.getValue()).split("E");
        clubValueLabel.setText("$ " + arr[0] + " billion");
        clubCityLabel.setText(c.getName());

        stadiumNameLabel.setText(s.getName());
        stadiumBuiltLabel.setText(String.valueOf(s.getDate_built()));
        stadiumCapacityLabel.setText(String.valueOf(s.getCapacity()));
        stadiumLengthLabel.setText(String.valueOf(s.getLength()));
        stadiumWidthLabel.setText(String.valueOf(s.getWidth()));


        //get all derbys (rivala)
//        ControllerAllDerby cad = new ControllerAllDerby();
//        List<AllDerby> lad = cad.getAll();
//        for(AllDerby ad : lad) {
//            System.out.println(ad.toString());
//        }



        //get all players
//        ControllerAllPlayers cap = new ControllerAllPlayers();
//        List<AllPlayers> lap = cap.getAll();
//        for(AllPlayers ap : lap){
//            System.out.println(ap.toString());
//        }

        //get all result
//        ControllerAllResults car = new ControllerAllResults();
//        List<AllResults> lar = car.getAll();
//        for(AllResults ar : lar) {
//            System.out.println(ar.toString());
//        }

        //get all transfers
//        ControllerAllTransfers cat = new ControllerAllTransfers();
//        List<AllTransfers> lat = cat.getAll();
//        for(AllTransfers at : lat) {
//            System.out.println(at.toString());
//        }

        //all trophy
//        ControllerAllTrophy cat = new ControllerAllTrophy();
//        List<AllTrophy> lat = cat.getAll();
//        for(AllTrophy at : lat) {
//            System.out.println(at.toString());
//        }

        //best of the best
//        ControllerBestOfTheBest cbob = new ControllerBestOfTheBest();
//        List<BestOfTheBest> lbob = cbob.getAll();
//        for(BestOfTheBest b : lbob){
//            System.out.println(b.toString());
//        }

        //manager contract
//        ControllerManagerContract cmc = new ControllerManagerContract();
//        List<ManagerContract> lmc = cmc.getAll();
//        for(ManagerContract mc : lmc ){
//            System.out.println(mc.toString());
//        }


        //contract player
//        ControllerPlayerContract cpc = new ControllerPlayerContract();
//        List<PlayerContract> lpc = cpc.getAll();
//        for(PlayerContract pc : lpc) {
//            System.out.println(pc.toString());
//        }


//        //famous
//        ControllerFamousPersons cfp = new ControllerFamousPersons();
//        List<FamousPersons> lfp = cfp.getAll();
//        for(FamousPersons fp : lfp) {
//            System.out.println(fp.toString());
//        }

    }
}
