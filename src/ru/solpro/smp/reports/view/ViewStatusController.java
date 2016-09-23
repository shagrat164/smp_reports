package ru.solpro.smp.reports.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ru.solpro.smp.reports.Database;
import ru.solpro.smp.reports.MainApp;

import java.sql.SQLException;

/**
 * Created by Администратор on 12.09.2016.
 */

public class ViewStatusController {
    @FXML
    private Label stringStatusConnection;

    // Ссылка на главное приложение
    private MainApp mainApp;

    /**
     * Конструктор.
     */
    public ViewStatusController() {

    }

    /**
     * Инициализация.
     */
    @FXML
    private void initialize() {
        stringStatusConnection.setText("Status connection");
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
