/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.jdj;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author dongju
 */
public class ElectricController implements Initializable {

    @FXML
    private StackPane mainStackPane;
    @FXML
    private TableView<Fee> tableView;
    @FXML
    private Label howManyUseLabel;
    @FXML
    private Label howManyFeeLabel;
    @FXML
    private Button chartButton;

    private static StackPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = mainStackPane;
        TableColumn tc0 = tableView.getColumns().get(0);
        TableColumn tc1 = tableView.getColumns().get(1);
        TableColumn tc2 = tableView.getColumns().get(2);
        TableColumn tc3 = tableView.getColumns().get(3);

        tc0.setCellValueFactory(new PropertyValueFactory<Fee, String>("month"));
        tc1.setCellValueFactory(new PropertyValueFactory<Fee, String>("howManyUse"));
        tc2.setCellValueFactory(new PropertyValueFactory<Fee, String>("fee"));
        tc3.setCellValueFactory(new PropertyValueFactory<Fee, String>("check"));

        tc0.setStyle("-fx-alignment: CENTER;");
        tc1.setStyle("-fx-alignment: CENTER;");
        tc2.setStyle("-fx-alignment: CENTER;");
        tc3.setStyle("-fx-alignment: CENTER;");

        ObservableList<Fee> list2 = FXCollections.observableArrayList();
        LocalDateTime now = LocalDateTime.now();
        int DateDay = now.getDayOfMonth();
        int Hour = now.getHour();
        int Minute = now.getMinute();
        int Second = now.getSecond();
        int feeNumber = (DateDay * 24 * 60 * 60 + Hour * 60 * 60 + Minute * 60 + Second) / 20000;
        String feeMeter = String.valueOf(feeNumber) + "\u33A5";
        String fee = String.valueOf(feeNumber * 300) + "원";
        list2.add(new Fee("1", "128" + "kW", "69120원", "납부완료"));
        list2.add(new Fee("2", "111" + "kW", "59940원", "납부완료"));
        list2.add(new Fee("3", "78" + "kW", "42120원", "납부완료"));

        tableView.setItems(list2);

        howManyUseLabel.setText(feeMeter);
        howManyFeeLabel.setText(fee);

        chartButton.setOnAction((event) -> {
            handlerChartButton(event);
        });
    }

    private void handlerChartButton(ActionEvent event) {
        try {

            rootPane.getChildren().clear();
            Parent gasScene = FXMLLoader.load(getClass().getResource("electricChart.fxml"));
            rootPane.getChildren().add(gasScene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
