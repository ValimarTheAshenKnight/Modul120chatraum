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

    private Stage optionsWindow;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setResizable(false);
        /*this.username = "";
        this.password = "";
        this.ip = "";*/

        BorderPane layout = new BorderPane();
        createOptions(primaryStage, layout);
        this.textDisplay = new TextArea();
        this.textDisplay.setMaxSize(400,400);
        layout.setCenter(textDisplay);
        layout.setBottom(send());
        layout.setRight(controls());

        Parent root = layout;

        primaryStage.setTitle("Chatroom");
        primaryStage.setScene(new Scene(root, 700, 575));
        primaryStage.show();
    }


    public GridPane send(){

        GridPane pane = new GridPane();
        TextField message = new TextField();
        message.setMinSize(550,1);
        Button send = new Button("Senden");
        send.setOnAction(event -> {
            textDisplay.appendText(message.getText()+"\n");
            message.setText("");
        });
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));

        message.setPadding(new Insets(10,0,10,10));
        send.setPadding(new Insets(10));
        pane.add(message,1,0);
        pane.add(send,2,0);

        return pane;
    }

    public GridPane controls() {

        GridPane pane = new GridPane();
        Button connect = new Button("Connect");
        Button options = new Button("Options");
        options.setOnAction(event -> this.optionsWindow.show());
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        connect.setPadding(new Insets(10));
        options.setPadding(new Insets(10));
        pane.add(connect,1,1);
        pane.add(options, 1,2);

        return pane;
    }

    public void createOptions(Stage primaryStage, BorderPane mainLayout) {
        BorderPane layout = new BorderPane();
        FlowPane buttonGroup = new FlowPane();
        buttonGroup.setPadding(new Insets(70,40,40,40));
        buttonGroup.setHgap(10);
        Button gray = new Button("Gray");
        Button green = new Button("Green");
        Button pink = new Button("pink");
        gray.setMinSize(40,40);
        green.setMinSize(40,40);
        pink.setMinSize(40,40);
        gray.setOnAction(event -> mainLayout.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(0), new Insets(0, 0, 0, 0)))));
        green.setOnAction(event -> mainLayout.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), new Insets(0, 0, 0, 0)))));
        pink.setOnAction(event -> mainLayout.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(0), new Insets(0, 0, 0, 0)))));
        layout.setCenter(buttonGroup);
        this.optionsWindow = new Stage();
        this.optionsWindow.setResizable(false);
        this.optionsWindow.initOwner(primaryStage);
        this.optionsWindow.initModality(Modality.WINDOW_MODAL);
        this.optionsWindow.setTitle("Options");
        this.optionsWindow.setScene(new Scene(layout, 300,200));
        buttonGroup.getChildren().addAll(gray, green, pink);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
