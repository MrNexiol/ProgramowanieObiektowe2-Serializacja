package main;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends Application {

    GridPane gridPane;

    Label nameLabel;
    TextField nameInput;

    Label surnameLabel;
    TextField surnameInput;

    Label birthDateLabel;
    DatePicker datePicker;

    Label addressLabel;

    Label streetNameLabel;
    TextField streetNameInput;

    Label streetNumberLabel;
    TextField streetNumberInput;

    Label houseNumberLabel;
    TextField houseNumberInput;

    Label cityNameLabel;
    TextField cityNameInput;

    Button submitButton;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        nameLabel = new Label("Name: ");
        nameInput = new TextField();

        surnameLabel = new Label("Surname: ");
        surnameInput = new TextField();

        birthDateLabel = new Label("Date of birth: ");
        datePicker = new DatePicker();

        addressLabel = new Label("Address");

        streetNameLabel = new Label("Street name: ");
        streetNameInput = new TextField();

        streetNumberLabel = new Label("Street number: ");
        streetNumberInput = new TextField();

        houseNumberLabel = new Label("House number: ");
        houseNumberInput = new TextField();

        cityNameLabel = new Label("City: ");
        cityNameInput = new TextField();

        submitButton = new Button("Submit");
        submitButton.setOnAction(actionEvent -> {
            String nameValue = nameInput.getText();
            String surnameValue = surnameInput.getText();
            String dateOfBirth = datePicker.getValue().toString();
            String streetName = streetNameInput.getText();
            int streetNumber = Integer.parseInt(streetNumberInput.getText());
            int houseNumber = Integer.parseInt(houseNumberInput.getText());
            String city = cityNameInput.getText();

            Address address = new Address(streetName,streetNumber,houseNumber,city);
            Person person = new Person(nameValue,surnameValue,dateOfBirth,address);

            Gson gson = new Gson();
            String serializedPerson = gson.toJson(person);

            System.out.println(serializedPerson);

            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extensionFilter);

            File file = fileChooser.showSaveDialog(stage);

            if (file != null){
                try {
                    PrintWriter writer = new PrintWriter(file);
                    writer.println(serializedPerson);
                    writer.close();
                }catch (IOException e){
                    System.out.println("Error");
                }
            }
        });

        gridPane = new GridPane();
        gridPane.add(nameLabel,0,0);
        gridPane.add(nameInput,1,0);
        gridPane.add(surnameLabel,0,1);
        gridPane.add(surnameInput,1,1);
        gridPane.add(birthDateLabel,0,2);
        gridPane.add(datePicker,1,2);
        gridPane.add(addressLabel,0,3);
        gridPane.add(streetNameLabel,0,4);
        gridPane.add(streetNameInput,1,4);
        gridPane.add(streetNumberLabel,0,5);
        gridPane.add(streetNumberInput,1,5);
        gridPane.add(houseNumberLabel,0,6);
        gridPane.add(houseNumberInput,1,6);
        gridPane.add(cityNameLabel,0,7);
        gridPane.add(cityNameInput,1,7);
        gridPane.add(submitButton,1,8);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(16);
        gridPane.setHgap(16);

        Scene scene = new Scene(gridPane,400, 400);

        stage.setScene(scene);

        stage.show();
    }
}
