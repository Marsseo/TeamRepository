/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.jdj;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author dongju
 */
public class ElectricChartController implements Initializable {

    @FXML
    private StackPane mainStackPane;
    @FXML
    private AreaChart<?, ?> AreaChart;
    private static StackPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootPane = mainStackPane;
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("월별 전기 요금");
        series1.setData(FXCollections.observableArrayList(
                new XYChart.Data("1월", 69120),
                new XYChart.Data("2월", 59940),
                new XYChart.Data("3월", 42120)
        ));
        AreaChart.getData().add(series1);

        AreaChart.setOnMouseClicked((event) -> {
            handlerAreaChart(event);
        });
    }

    private void handlerAreaChart(MouseEvent event) {

        // AnchorPane rootPane = (AnchorPane) AreaChart.getScene().getRoot();
        //rootPane.getChildren().remove(this);
        try {
            rootPane.getChildren().clear();

            Parent gasScene = FXMLLoader.load(getClass().getResource("electric.fxml"));
            rootPane.getChildren().add(gasScene);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}