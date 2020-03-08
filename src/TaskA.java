//Alejandro Millan
//CS2450
//Assignment 2
//3-4-20

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskA extends Application {
    double subtotal = 0.0;
    double salesTax = 0.0;
    double total = 0.0;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Label subtotalLBL = new Label();
        Label salesTaxLBL = new Label();
        Label totalLBL = new Label();
        Label decksLBL = new Label("Decks");
        Label wheelsLBL = new Label("Wheels");
        Label trucksLBL = new Label("Trucks");
        Button getPrice = new Button("Calculate Price");

        ListView<String> decks = new ListView<>();
        decks.setPrefSize(200, 110);
        decks.getItems().addAll(
                "The Master Thrasher $60", "The Dictator $45", "The Street King $50");

        ListView<String> trucks = new ListView<>();
        trucks.setPrefSize(200, 110);
        trucks.getItems().addAll(
                "7.75-inch axle $35", "8-inch axle $40", "8.5-inch axle $45");

        ListView<String> wheels = new ListView<>();
        wheels.setPrefSize(200, 110);
        wheels.getItems().addAll(
                "51 mm $20", "55 mm $22", "58 mm $24", "61 mm $28");

        CheckBox gripTape = new CheckBox("Grip Tape: $10");
        CheckBox bearings = new CheckBox("Bearings: $30");
        CheckBox riserPads = new CheckBox("Riser pads: $2");
        CheckBox nutNbolts = new CheckBox("Nuts & bolts kit: $3");

        getPrice.setOnAction(event -> {
            int index = decks.getSelectionModel().getSelectedIndex();
            int index2 = trucks.getSelectionModel().getSelectedIndex();
            int index3 = wheels.getSelectionModel().getSelectedIndex();

            if(index == -1 || index2 == -1 || index3 == -1) {
                System.out.println("Erros");
            }

            if(index == 0) {
                subtotal = 60.0;
            }
            else if(index == 1) {
                subtotal = 45.0;
            }
            else if(index == 2) {
                subtotal = 50.0;
            }

            if(index2 == 0) {
                subtotal += 35.00;
            }
            else if(index2 == 1) {
                subtotal += 40.00;
            }
            else if(index2 == 2) {
                subtotal += 45.00;
            }

            if(index3 == 0) {
                subtotal += 20.00;
            }
            else if(index3 == 1) {
                subtotal += 22.00;
            }
            else if(index3 == 2) {
                subtotal += 24.00;
            }
            else if(index3 == 3) {
                subtotal += 28.00;
            }

            if(gripTape.isSelected()){
                subtotal += 5.00;
            }

            if(bearings.isSelected()){
                subtotal += 5.00;
            }

            if(riserPads.isSelected()){
                subtotal += 5.00;
            }

            if(nutNbolts.isSelected()){
                subtotal += 5.00;
            }

            salesTax = subtotal * 0.07;
            total = subtotal + salesTax;

            subtotalLBL.setText(String.format("Subtotal: $%.2f", subtotal));
            salesTaxLBL.setText(String.format("Sales Tax: $%.2f", salesTax));
            totalLBL.setText(String.format("Total: $%.2f", total));
        });

        VBox vDeck = new VBox(5, decksLBL, decks);
        VBox vTrucks = new VBox(5, trucksLBL, trucks);
        VBox vWheels = new VBox(5, wheelsLBL, wheels);

        HBox hbox1 = new HBox(10, vDeck, vTrucks, vWheels);
        hbox1.setAlignment(Pos.CENTER);

        VBox options = new VBox(10, gripTape, bearings, riserPads, nutNbolts);
        options.setAlignment(Pos.CENTER);

        VBox vbox1 = new VBox(10, hbox1, options, getPrice, subtotalLBL, salesTaxLBL, totalLBL);
        vbox1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox1, 500, 450);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
