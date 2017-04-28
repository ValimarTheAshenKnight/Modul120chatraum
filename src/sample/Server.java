package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Buetikofer
 * @version 1.0
 */
public class Server extends Application {

    /**
     * Display of all known users
     */
    private TextArea userDisplay;

    /**
     * User creation dialog
     */
    private Stage createUserWindow;

    /**
     * Storage of all user objects
     */
    private List<User> users;

    /**
     * Main method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane layout = new BorderPane();

        GridPane userDisBox = new GridPane();

        initAddUserDialog(primaryStage);

        this.users = new ArrayList<>();


        this.userDisplay = new TextArea();
        this.userDisplay.setEditable(false);
        this.userDisplay.setMaxSize(200, 400);
        this.userDisplay.setPadding(new Insets(10, 10, 10, 10));
        layout.setLeft(userDisBox);
        layout.setRight(buttons());

        userDisBox.add(userDisplay, 0, 0);

        userDisBox.setPadding(new Insets(10, 10, 10, 10));

        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(layout, 700, 575));
        primaryStage.show();
    }


    /**
     *
     * @return
     */
    private GridPane buttons() {

        GridPane buttonGroup = new GridPane();

        Button create = new Button("User Erstellen");
        Button delete = new Button("User Löschen");
        buttonGroup.setVgap(10);

        create.setOnAction(event -> this.createUserWindow.show());

        buttonGroup.setPadding(new Insets(10));

        buttonGroup.add(create, 0, 0);
        buttonGroup.add(delete, 0, 1);

        return buttonGroup;
    }

    /**
     *
     * @param primaryStage
     */
    private void initAddUserDialog(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        GridPane benutzer = new GridPane();
        Label userLabel = new Label("Enter username: ");
        Label passLabel = new Label("Enter password: ");
        Label confirmLabel = new Label("Confirm password: ");
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        PasswordField confirm = new PasswordField();
        Button ok = new Button("OK");
        TextArea error = new TextArea();

        error.setStyle("-fx-text-fill: red");
        error.setEditable(false);
        ok.setOnAction(event -> addUser(username, password, confirm, error));

        benutzer.setPadding(new Insets(10));
        benutzer.setVgap(10);

        benutzer.add(userLabel, 0, 1);
        benutzer.add(username, 1, 1);
        benutzer.add(passLabel, 0, 2);
        benutzer.add(password, 1, 2);
        benutzer.add(confirmLabel, 0, 3);
        benutzer.add(confirm, 1, 3);
        benutzer.add(ok, 2, 5);
        layout.setBottom(error);
        layout.setCenter(benutzer);

        this.createUserWindow = new Stage();
        this.createUserWindow.setResizable(false);
        this.createUserWindow.initOwner(primaryStage);
        this.createUserWindow.initModality(Modality.WINDOW_MODAL);
        this.createUserWindow.setTitle("User Erstellen");
        this.createUserWindow.setScene(new Scene(layout, 300, 300));


    }

    /**
     *
     * @param userField
     * @param passwordField
     * @param confirmField
     * @param errorArea
     */
    private void addUser(TextField userField, PasswordField passwordField, PasswordField confirmField, TextArea errorArea) {

        List<String> errors = new ArrayList<>();
        String username = userField.getText();
        String password = passwordField.getText();
        String confirm = confirmField.getText();

        errorArea.setText("");

        if (username.equals("")) {
            errors.add("Please enter a username!");
        }

        if (password.equals("")) {
            errors.add("Please enter a password!");
        }

        if (confirm.equals("")) {
            errors.add("Please confirm your password!");
        }

        if (!confirm.equals(password)) {
            errors.add("Passwords don't match!");
        }

        if(Filterer.foundSwearWord(username)){
            errors.add("Watch your language!");
        }

        if(username.equals("Deus Vult")){
            errors.add("No nobus domine");
        }

        if(username.equals("Robbie Rotten")){
            errors.add("We Are Number One! Hey!");
        }

        if (errors.isEmpty()) {
            this.users.add(new User(username, password));
            userField.setText("");
            passwordField.setText("");
            confirmField.setText("");
            this.createUserWindow.close();
        } else {
            errors.forEach(error -> errorArea.appendText(error + "\n"));
        }


        this.userDisplay.setText("");
        this.users.forEach(user -> this.userDisplay.appendText(user.getName() + "\n"));

    }
}
