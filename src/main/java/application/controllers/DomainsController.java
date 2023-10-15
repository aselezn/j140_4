package application.controllers;

import application.App;
import application.SceneFactory;
import application.Utils;
import database.dto.PersonCountDomainsDto;
import database.models.Domain;
import database.queries.PersonQueries;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class DomainsController {

    @FXML
    public Button changeStyle;
    public BorderPane borderPaneDomains;
    private String css;
    @FXML
    private Button comeBackButton;

    @FXML
    private TableView<Domain> domainsTable;

    @FXML
    private TableColumn<Domain, Integer> id;

    @FXML
    private TableColumn<Domain, String> webName;

    @FXML
    private TableColumn<Domain, String> domainName;

    @FXML
    private TableColumn<Domain, String> ip;

    @FXML
    private TableColumn<Domain, LocalDateTime> dateReg;

    @FXML
    private TableColumn<Domain, String> countryReg;

    @FXML
    private TableColumn<Domain, Integer> personId;

    public TableView<Domain> getDomainsTable() {
        return domainsTable;
    }

    @FXML
    public void comeBackButtonClick() throws IOException {

        ((Stage)comeBackButton.getScene().getWindow()).setScene(SceneFactory.getPersonsView());
        PersonsController personsController = SceneFactory.getPersonsController();
        ObservableList<PersonCountDomainsDto> observablePersons = Utils.createObservableList(PersonQueries.getPersons());
        personsController.getPersonsTable().setItems(observablePersons);

    };

    @FXML
    public void changeStyle() {

        String css1 = Objects.requireNonNull(App.class.getResource("/domain_style_1.css")).toExternalForm();
        String css2 = Objects.requireNonNull(App.class.getResource("/domain_style_2.css")).toExternalForm();

        if(css!=null && css.equals(css1)){
            css = css2;
        }else {
            css = css1;
        }

        borderPaneDomains.getStylesheets().clear();
        borderPaneDomains.getStylesheets().add(css);
        System.out.println("Applying style: " + css);

    };
}
