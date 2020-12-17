package pageFunctions.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWork {

	public Object[][] TestDataFromExcel(String SheetName) throws IOException {

		Map<String, String> map;
		int count = 0;

		String filename = "APT_MCN_CreateAccessCoreDevice_TestData.xlsx";
		File file = new File("src\\com\\colt\\qa\\datalibrary\\APT_MCN_CreateAccessCoreDevice_TestData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtensionName = filename.substring(filename.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}
		Sheet sheet = workbook.getSheet(SheetName);
		int rowCountForMap = 0;
		for (int k = 1; k <= sheet.getLastRowNum(); k++) {
			XSSFRow counter = (XSSFRow) sheet.getRow(k);
			if (counter.getCell(0).toString().equalsIgnoreCase("Yes")) {
				rowCountForMap = rowCountForMap + 1;
			}
		}
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCountForMap][1];
		for (int i = 0; i < rowCount; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			if (sheet.getRow(i + 1).getCell(0).toString().equalsIgnoreCase("Yes")) {
				for (int j = 0; j < colCount; j++) {
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
				}
				obj[count][0] = datamap;
				count++;
			} else {
				////// System.out.println("No changes");
			}
		}
		return obj;
	}

	public void WriteCustomerID(String CustomerID, String PaymentReference) throws IOException {
		
		String path = "src//test//resources//dataSource//CustomerID.xlsx";
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				createFile(path);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		AppendData(path, CustomerID,PaymentReference);
	}

	public void createFile(String Path) throws IOException {
		FileOutputStream fos = new FileOutputStream(Path);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("MoveInCustomerID");
		Row row = sheet.createRow(0);
		Cell cell0 = row.createCell(0);
		cell0.setCellValue("CustomerID");

		Cell cell1 = row.createCell(1);
		cell1.setCellValue("Payment Reference");

		Cell cell2 = row.createCell(2);
		cell2.setCellValue("CreatedDate");
		workbook.write(fos);
		fos.flush();
		fos.close();
	}

	public void AppendData(String Path, String CustomerID, String PaymentReference) throws FileNotFoundException {
		try {

			FileInputStream fis = new FileInputStream(new File(Path));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// XSSFSheet sheet = workbook.
			int i = workbook.getNumberOfSheets();
			System.out.println(i);
			XSSFSheet sheet = workbook.getSheetAt(0);
			int num = sheet.getLastRowNum();
			Row row = sheet.createRow(++num);

			row.createCell(0).setCellValue(CustomerID);
			row.createCell(1).setCellValue(PaymentReference);
			row.createCell(2).setCellValue(CurrentDate());
			fis.close();
			FileOutputStream fos = new FileOutputStream(Path);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String CurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return (formatter.format(date));

	}

}
