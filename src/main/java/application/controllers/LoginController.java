package application.controllers;

import application.SceneFactory;
import application.Utils;
import database.dto.PersonCountDomainsDto;
import database.queries.AuthQueries;
import database.queries.PersonQueries;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    public Label usernameLabel;
    @FXML
    public Label passwordLabel;
    public Label header;
    @FXML
    private Button loginButton;

    @FXML
    private Text resultText;
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    public void handleLoginAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (AuthQueries.authenticateUser(username, password)) {
            ((Stage)loginButton.getScene().getWindow()).setScene(SceneFactory.getPersonsView());
            PersonsController personsController = SceneFactory.getPersonsController();
            ObservableList<PersonCountDomainsDto> observablePersons = Utils.createObservableList(PersonQueries.getPersons());
            personsController.getPersonsTable().setItems(observablePersons);

        } else {
            resultText.setFill(Color.RED);
            resultText.setText("Ошибка аутентификации. Попробуйте снова.");
        }
    }


}
