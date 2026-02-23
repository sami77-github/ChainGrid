package DemoTests;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenTesting {

	// To read the data from properties file
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:/Desktop/commen_data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));

		// Excel file
		FileInputStream fis1 = new FileInputStream("C:/Desktop/SCM_Smoke_Regression_Test_Cases.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Regression_Test_Cases");
		Row row = sh.getRow(2);
		short cellcount1 = row.getLastCellNum();
		for(int m=0;m<=cellcount1;m++) {
			Cell data = row.getCell(m);
			System.out.print(data+" ");
		}
		
		 Cell create = row.createCell(8);
		 create.setCellType(CellType.STRING);
		 create.setCellValue("sami");
		 
		 FileOutputStream fos = new FileOutputStream("C:/Desktop/SCM_Smoke_Regression_Test_Cases.xlsx");
		 wb.write(fos);
		 wb.close();

		int rowcount = sh.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			row = sh.getRow(i);
			System.out.println();
			short cellcount = row.getLastCellNum();
			for (int j = 0; j <= cellcount; j++) {
				Cell cells = row.getCell(j);
				System.out.print(cells + " ");
			}
		}

	}
}
