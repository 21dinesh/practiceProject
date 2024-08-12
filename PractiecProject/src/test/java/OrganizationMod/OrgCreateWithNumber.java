package OrganizationMod;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic.BaseClass;

public class OrgCreateWithNumber extends BaseClass{

	
	@Test
	public void crateWithNumber() throws EncryptedDocumentException, IOException {
		String Orgname=efile.getDatafromeExcel("org", 1, 2);
		org.getOrgmodule().click();
		org.getCraeteorg().click();
		org.getOrgname().sendKeys(Orgname+new Random(231).nextInt());
		org.getSave().click();
	
		//@Run
		
	}
}
