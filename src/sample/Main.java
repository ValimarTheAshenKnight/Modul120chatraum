package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    private String username;

    private String password;

    private String ip;

    private TextArea textDisplay;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setResizable(false);
        this.username = "";
        this.password = "";
        this.ip = "";
        BorderPane layout = new BorderPane();
        this.textDisplay = new TextArea();
        this.textDisplay.setMaxSize(400,400);
        layout.setCenter(textDisplay);
        layout.setBottom(send());

        Parent root = layout;

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 575));
        primaryStage.show();
    }


    public GridPane send(){

        GridPane pane = new GridPane();
        TextField message = new TextField();
        message.setMinSize(550,1);
        Button send = new Button("Senden");
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));

        message.setPadding(new Insets(10,0,10,10));
        send.setPadding(new Insets(10));
        pane.add(message,1,0);
        pane.add(send,2,0);

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
