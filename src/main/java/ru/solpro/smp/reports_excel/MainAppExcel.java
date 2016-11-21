package ru.solpro.smp.reports_excel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAppExcel extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Экспорт отчётов - СМП");
        this.primaryStage.setMinWidth(1024);
        this.primaryStage.setMinHeight(768);
        this.primaryStage.getIcons().add(new Image("/img/icon_app.png"));

        initRootLayout();
        showMainOverview();
    }

    /**
     * Добавляет в центральную часть основную часть приложения.
     */
    private void showMainOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppExcel.class.getResource("/fxml/ViewBase.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            rootLayout.setCenter(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("close app");
    }

    /**
     * Инициализирует корневой макет.
     * Создаёт сцену.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainAppExcel.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
