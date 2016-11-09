package ru.solpro.smp.reports_excel;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Администратор on 09.11.2016.
 */
public class MainAppExcel extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Проспотр отчётов - СМП");
        this.primaryStage.setMinWidth(1024);
        this.primaryStage.setMinHeight(768);
        this.primaryStage.getIcons().add(new Image("file:resources/images/icon_app.png"));
    }

    @Override
    public void stop() {
        System.out.println("close app");
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
