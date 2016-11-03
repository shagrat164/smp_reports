package ru.solpro.smp.reports.view;

/**
 * Created by Администратор on 08.09.2016.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ru.solpro.smp.reports.MainApp;
import ru.solpro.smp.reports.model.FillDataTableView;

public class ViewBaseController {
    @FXML
    private TableView tw1;
    @FXML
    private Button button1;

    public ViewBaseController() {

    }

    @FXML
    private void initialize(){

    }

    @FXML
    private void sendReq() {
        FillDataTableView fillDataTableView = new FillDataTableView();
        fillDataTableView.setSQL("SELECT TOP 5 * FROM dbo.UA#Johnson_Fat");
        fillDataTableView.buildData();
        tw1 = fillDataTableView.getTableView();
    }
}
