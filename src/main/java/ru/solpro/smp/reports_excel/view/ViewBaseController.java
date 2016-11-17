package ru.solpro.smp.reports_excel.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import ru.solpro.smp.reports_excel.Database;
import ru.solpro.smp.reports_excel.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Администратор on 16.11.2016.
 */
public class ViewBaseController {
    @FXML
    DatePicker dateStartKemtec1GP;
    @FXML
    DatePicker dateEndKemtec1GP;
    @FXML
    Button exportRunKemtec1GP;
    @FXML
    RadioButton radioButtonKemtec1GP1Smen;
    @FXML
    RadioButton radioButtonKemtec1GP2Smen;
    @FXML
    RadioButton radioButtonKemtec1GPPeriod;

    @FXML
    private void initialize() {
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(dateStartKemtec1GP.getValue().plusDays(0))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        dateEndKemtec1GP.setDayCellFactory(dayCellFactory);
        dateStartKemtec1GP.setValue(LocalDate.now());
        dateEndKemtec1GP.setValue(dateStartKemtec1GP.getValue().plusDays(1));
    }

    @FXML
    private void exportRunKemtec1GP() {
        if (DateUtil.validDate(DateUtil.format(dateStartKemtec1GP.getValue())) && DateUtil.validDate(DateUtil.format(dateEndKemtec1GP.getValue()))) {
            System.out.println("exportRun() " + DateUtil.format(dateStartKemtec1GP.getValue()) + ":" + dateEndKemtec1GP.getValue());
            exportRunning("UA#Kemtec_1_GP", dateStartKemtec1GP.getValue().toString(), dateEndKemtec1GP.getValue().toString());
        }
    }

    private void exportRunning(String tableName, String dateStart, String dateEnd) {
        /*
        SELECT    ten_min AS [кол-во], SKU, LastAccess AS [Date/Time]
        FROM      UA#Kemtec_1_GP
        WHERE     (LastAccess >= CONVERT(DATETIME, '2016-05-11 00:00:00', 102)) AND
                  (LastAccess <= CONVERT(DATETIME, '2016-05-12 00:00:00', 102))
        */
        try {
            Database database = new Database();
            database.dbConnect();
            ResultSet resultSet = database.execSQL(
                    "SELECT    ten_min AS [кол-во], SKU, LastAccess AS [Date/Time]\n" +
                    "FROM      "+ tableName +"\n" +
                    "WHERE     (LastAccess >= CONVERT(DATETIME, '"+ dateStart +" 00:00:00', 102)) AND\n" +
                    "          (LastAccess <= CONVERT(DATETIME, '"+ dateEnd + " 00:00:00', 102))");
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i+1) + "\t");
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
            database.dbDisconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
