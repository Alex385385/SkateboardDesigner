//Alejandro Millan
//CS2450
//Assignment 2
//3-4-20

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskA extends Application {
    double price = 0.0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label test = new Label();
        ListView<String> decks = new ListView<>();
        decks.setPrefSize(200, 100);
        decks.getItems().addAll(
                "The Master Thrasher $60", "The Dictator $45", "The Street King $50");

        ListView<String> trucks = new ListView<>();
        trucks.setPrefSize(200, 100);
        trucks.getItems().addAll(
                "7.75-inch axle $35", "8-inch axle $40", "8.5-inch axle $45");

        ListView<String> wheels = new ListView<>();
        wheels.setPrefSize(200, 100);
        wheels.getItems().addAll(
                "51 mm $20", "55 mm $22", "58 mm $24", "61 mm $28");

        decks.getSelectionModel().selectedItemProperty().addListener(event -> {
            int index = decks.getSelectionModel().getSelectedIndex();

            if(index == 0) {
                price = 60.0;
            }
            else if(index == 1) {
                price = 45.0;
            }
            else if(index == 2) {
                price = 50.0;
            }

            test.setText(String.format("$%f", price));
        });

        trucks.getSelectionModel().selectedItemProperty().addListener(event -> {
            int index = trucks.getSelectionModel().getSelectedIndex();

            test.setText("index");
        });

        wheels.getSelectionModel().selectedItemProperty().addListener(event -> {
            int index = wheels.getSelectionModel().getSelectedIndex();

            test.setText("index");
        });

        HBox hbox1 = new HBox(10, decks, trucks, wheels);
        VBox vbox1 = new VBox(10, hbox1, test);

        Scene scene = new Scene(vbox1, 500, 450);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
