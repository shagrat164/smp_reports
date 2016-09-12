package ru.solpro.smp.reports;

/**
 * Created by Администратор on 06.09.2016.
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.solpro.smp.reports.view.RootLayoutController;
import ru.solpro.smp.reports.view.ViewStatusController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Проспотр отчётов - СМП");
        this.primaryStage.setMinWidth(1024);
        this.primaryStage.setMinHeight(768);
        this.primaryStage.getIcons().add(new Image("file:resources/images/icon_app.png"));
//------
//        this.primaryStage.setFullScreen(true);
//        this.primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

//        this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
//            @Override
//            public void handle(WindowEvent event) {
//                event.consume();
//            }
//        });
//------
        initRootLayout();
        showMainOverview();
        showStatus();
    }

    @Override
    public void stop() {
        System.out.println("close app");
        //db.dbDisconnect();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Передаю ссылку на mainApp
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете ...
     */
    public void showMainOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ViewBase.fxml"));
            AnchorPane mainOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(mainOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведение о статусе соединения.
     */
    public void showStatus() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ViewStatus.fxml"));
            AnchorPane statusOverview = (AnchorPane) loader.load();

            rootLayout.setBottom(statusOverview);

            ViewStatusController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
