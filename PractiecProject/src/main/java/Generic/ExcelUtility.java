package Generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
    
	public String getDatafromeExcel(String Sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantPath.excel_path);
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
	}
}
