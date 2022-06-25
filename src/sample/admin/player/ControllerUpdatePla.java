package sample.admin.player;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.controller.*;
import sample.model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerUpdatePla implements Initializable {

    @FXML
    private TextField namePlayer;
    @FXML
    private DatePicker dateBirth;
    @FXML
    private ChoiceBox<String> country;
    @FXML
    private CheckBox bestTeam;
    @FXML
    private TextField number;
    @FXML
    private ChoiceBox<String> foot;
    @FXML
    private ChoiceBox<String> position;
    @FXML
    private ChoiceBox<String> playerRole;
    @FXML
    private Button updateButton;

    ControllerCountry cc = new ControllerCountry();
    ControllerFoot cf = new ControllerFoot();
    ControllerPosition conPos = new ControllerPosition();
    ControllerPlayerRole cpr = new ControllerPlayerRole();

    List<String> filterListCountry = new ArrayList<>();
    List<String> filterListFoot = new ArrayList<>();
    List<String> filterListPosition = new ArrayList<>();
    List<String> filterListPlayerRole = new ArrayList<>();

    public ControllerUpdatePla() {
        List<Country> listCountry = cc.getAll();
        for(Country c : listCountry) {
            filterListCountry.add(c.getName());
        }

        List<Foot> listFoot = cf.getAll();
        for(Foot f : listFoot){
            filterListFoot.add(f.getLevel());
        }

        List<Position> listPosition = conPos.getAll();
        for(Position p : listPosition){
            filterListPosition.add(p.getDescription());
        }

        List<PlayerRole> listPlayerRole = cpr.getAll();
        for(PlayerRole pr : listPlayerRole){
            filterListPlayerRole.add(pr.getRole());
        }
    }

    private static Integer data;
    public static void setData(Integer data) {
        ControllerUpdatePla.data = data;
    }

    @FXML
    private void updatePlayer() {
        if(country.getSelectionModel().isEmpty() || foot.getSelectionModel().isEmpty() || position.getSelectionModel().isEmpty() || playerRole.getSelectionModel().isEmpty())
            return;

        Country c = cc.getIdOfVountry(country.getSelectionModel().getSelectedItem());
        Foot f = cf.getIdByFoot(foot.getSelectionModel().getSelectedItem());
        Position p = conPos.getIdByPosition(position.getSelectionModel().getSelectedItem());
        PlayerRole pr = cpr.getIdByPlayerRole(playerRole.getSelectionModel().getSelectedItem());

        Date localDate = Date.valueOf(dateBirth.getValue());

        ControllerPerson conPer = new ControllerPerson();
        ControllerPlayer conPla = new ControllerPlayer();
        Person person = new Person(data, namePlayer.getText(), localDate, c.getIdCountry(), bestTeam.isSelected() ? (short) 1 : (short)0, "ACTIVE");
        Player player = new Player(person.getIdPerson(), Integer.valueOf(number.getText()), f.getIdFoot(), p.getIdPosition(), pr.getIdPlayerRole());
        conPer.updatePerson(person);
        conPla.updatePlayer(player);

        Stage updatePlayerStage = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("player.fxml"));
            updatePlayerStage.setTitle("PLAYER");
            updatePlayerStage.setResizable(false);
            updatePlayerStage.setScene(new Scene(root));
            updatePlayerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage s = (Stage) updateButton.getScene().getWindow();
        s.close();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        country.setItems(countryModels);
        foot.setItems(footModels);
        position.setItems(positionModels);
        playerRole.setItems(playerRoleModels);

        if(data == null)
            return;

        ControllerPerson cp = new ControllerPerson();
        ControllerPlayer conPla = new ControllerPlayer();

        Person person = cp.getPersonById(data);
        Player player =  conPla.getPlayerById(data);
        Country con = cc.getCountryById(person.getCountry_id_person());
        Foot fo = cf.getFootById(player.getFoot_id());
        Position pos = conPos.getPositionById(player.getPosition_id());
        PlayerRole pr = cpr.getPlayerRoleById(player.getPlayer_role_id());

        namePlayer.setText(person.getName());
        LocalDate localDate = person.getDate_birth().toLocalDate();
        dateBirth.setValue(localDate);
        bestTeam.setSelected(person.getBest_team() == 1);
        number.setText(String.valueOf(player.getNumber()));
        position.getSelectionModel().select(pos.getDescription());
        foot.getSelectionModel().select(fo.getLevel());
        playerRole.getSelectionModel().select(pr.getRole());
        country.getSelectionModel().select(con.getName());

    }

    final ObservableList<String> countryModels = FXCollections.observableList(filterListCountry);
    final ObservableList<String> footModels = FXCollections.observableList(filterListFoot);
    final ObservableList<String> positionModels = FXCollections.observableList(filterListPosition);
    final ObservableList<String> playerRoleModels = FXCollections.observableList(filterListPlayerRole);
}
