package ru.solpro.smp.reports_excel.model;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;


/**
 * Created by Администратор on 17.11.2016.
 */

public class Excel {
    public static void exportData(String file, ResultSet resultSet) throws IOException, SQLException{
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        Row rowTitle = sheet.createRow(0);
        for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
            Cell cell = rowTitle.createCell(i);
            cell.setCellValue(resultSet.getMetaData().getColumnName(i+1));
        }

        int count = 0;
        while (resultSet.next()) {
            Row rowData = sheet.createRow(++count);
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                if (i == resultSet.getMetaData().getColumnCount()) {
                    Cell cellDate = rowData.createCell(i - 1);
                    cellDate.setCellValue(resultSet.getDate(i));

                    Cell cellTime = rowData.createCell(i);
                    Time time = resultSet.getTime(i);
                    time.setHours(time.getHours() + 3);
                    cellTime.setCellValue(time.toString());
                } else {
                    Cell cell = rowData.createCell(i - 1);
                    cell.setCellValue(resultSet.getString(i));
                }
            }
        }

        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        workbook.write(new FileOutputStream(file));
        workbook.close();
    }
}
