package ru.solpro.smp.reports.view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ru.solpro.smp.reports.MainApp;

/**
 * Created by Администратор on 09.09.2016.
 */
public class RootLayoutController {
    @FXML
    private MenuItem connectDB;
    @FXML
    private MenuItem disconnectDB;

    private MainApp mainApp;

    public RootLayoutController() {

    }

    /**
     * Инициализация.
     */
    @FXML
    private void initialize() {
        connectDB.setDisable(false);
        disconnectDB.setDisable(true);
    }

    @FXML
    private void ConnectDB() throws Exception {
        System.out.println("connect db");
        connectDB.setDisable(false);
        disconnectDB.setDisable(true);
    }

    @FXML
    private void DisconnectDB() {
        System.out.println("disconnect db");
        disconnectDB.setDisable(false);
        connectDB.setDisable(true);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
