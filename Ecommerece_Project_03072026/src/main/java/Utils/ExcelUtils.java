package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public Object[][] getExcelData() 
    {

        Object[][] data = null;

        try 
        {

            // Excel file path
            FileInputStream fis = new FileInputStream("src/test/resources/TestData1.xlsx");

            // Workbook open
            Workbook workbook = new XSSFWorkbook(fis);
            
            //System.out.println("Excel sheet Opened");

            // Sheet open
            Sheet sheet = workbook.getSheet("Sheet1");
            
//            if(sheet == null)
//            {
//                throw new RuntimeException("Sheet not found");
//            }
            
            //System.out.println("Sheet = " + sheet.getSheetName());

            // Total rows (excluding header)
            int totalRows = sheet.getLastRowNum();
           // System.out.println("Rows = "  +totalRows);

            // Total columns
            int totalCols = sheet.getRow(0).getLastCellNum();
           // System.out.println("Columns = "  +totalCols);

            // Object array
            data = new Object[totalRows][totalCols];

            // Read data from Excel
            for (int i = 1; i <= totalRows; i++)
            {

                Row row = sheet.getRow(i);

                for (int j = 0; j < totalCols; j++) 
                {

                    Cell cell = row.getCell(j);

                    data[i - 1][j] = cell.toString();

                }
            }

            workbook.close();
            fis.close();

        }
        catch (IOException e) 
        {

            e.printStackTrace();
        }

        return data;
    }

}