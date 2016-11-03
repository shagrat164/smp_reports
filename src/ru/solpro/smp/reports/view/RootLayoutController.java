package ru.solpro.smp.reports.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import ru.solpro.smp.reports.MainApp;

import java.io.IOException;

/**
 * Created by Администратор on 09.09.2016.
 */
public class RootLayoutController {
    @FXML
    private MenuItem connectDB;
    @FXML
    private MenuItem disconnectDB;
    @FXML
    private MenuItem ViewJohnson;

    private MainApp mainApp;

    public RootLayoutController() {

    }

    /**
     * Инициализация.
     */
    @FXML
    private void initialize() {
//        connectDB.setDisable(false);
//        disconnectDB.setDisable(true);
    }

    @FXML
    private void ConnectDB() throws Exception {
        System.out.println("connect db");
//        connectDB.setDisable(false);
//        disconnectDB.setDisable(true);
    }

    @FXML
    private void DisconnectDB() {
        System.out.println("disconnect db");
//        disconnectDB.setDisable(false);
//        connectDB.setDisable(true);
    }

    @FXML
    public void ViewJohnson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ViewJohnson.fxml"));
            AnchorPane statusOverview = (AnchorPane) loader.load();

            mainApp.getRootLayout().setCenter(statusOverview);

            ViewStatusController controller = loader.getController();
            controller.setMainApp(mainApp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
