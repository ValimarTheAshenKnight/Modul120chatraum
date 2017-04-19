package sample;/**
 * Created by d.buetikofer on 10.04.2017.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;


public class Server extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    private TextArea userDisplay;

    private Stage createUserWindow;

    @Override
    public void start(Stage primaryStage) {

        BorderPane layout = new BorderPane();

        GridPane userDisBox = new GridPane();

        createUser(primaryStage,layout);


        this.userDisplay = new TextArea();
        this.userDisplay.setMaxSize(200,400);
        this.userDisplay.setPadding(new Insets(10,10,10,10));
        layout.setLeft(userDisBox);
        layout.setRight(buttons());

        userDisBox.add(userDisplay, 0, 0);

        userDisBox.setPadding(new Insets(10,10,10,10));

        Parent root = layout;

        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 700, 575));
        primaryStage.show();
    }


    public GridPane buttons() {

        GridPane buttonGroup = new GridPane();

        Button create = new Button("User Erstellen");
        Button delete = new Button("User Löschen");
        buttonGroup.setVgap(10);

        create.setOnAction(event -> this.createUserWindow.show());

        buttonGroup.setPadding(new Insets(10));

        buttonGroup.add(create,0,0);
        buttonGroup.add(delete,0,1);

        return buttonGroup;
    }

    public void createUser(Stage primaryStage, BorderPane mainlayout){
        BorderPane layout = new BorderPane();
        FlowPane benutzer = new FlowPane();
        Label label = new Label("Enter username: ");
        TextField feld = new TextField();

        this.createUserWindow = new Stage();
        this.createUserWindow.setResizable(false);
        this.createUserWindow.initOwner(primaryStage);
        this.createUserWindow.initModality(Modality.WINDOW_MODAL);
        this.createUserWindow.setTitle("User Erstellen");
        this.createUserWindow.setScene(new Scene(layout,200,200));

        benutzer.getChildren().addAll(label, feld);
        layout.setCenter(benutzer);

    }
}
