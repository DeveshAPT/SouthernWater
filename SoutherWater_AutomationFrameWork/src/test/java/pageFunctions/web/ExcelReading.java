package pageFunctions.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading 
{

	public Object[][] TestDataFromExcel(String SheetName) throws IOException
	{
		
		Map<String, String> map;
		int count=0;
		
		String filename = "APT_MCN_CreateAccessCoreDevice_TestData.xlsx";
		File file = new File("src\\com\\colt\\qa\\datalibrary\\APT_MCN_CreateAccessCoreDevice_TestData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtensionName = filename.substring(filename.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) 
		{
			workbook = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) 
		{
			workbook = new HSSFWorkbook(inputStream);
		}
		Sheet sheet = workbook.getSheet(SheetName);
		int rowCountForMap = 0;
        for(int k=1;k<=sheet.getLastRowNum();k++)
        {
            XSSFRow counter=(XSSFRow) sheet.getRow(k);
            if(counter.getCell(0).toString().equalsIgnoreCase("Yes"))
            {
                rowCountForMap=rowCountForMap+1;
            }
        }
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCountForMap][1];
		for (int i = 0; i < rowCount; i++) 
		{
			Map<Object, Object> datamap = new HashMap<Object, Object>();	
			if(sheet.getRow(i + 1).getCell(0).toString().equalsIgnoreCase("Yes")) 
			{	
				for (int j = 0; j < colCount; j++) 
				{
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
				}
				obj[count][0] = datamap;
				count++;
			}
			else 
			{
				//////System.out.println("No changes");
			}
		}
		return obj;
	}
	
}
