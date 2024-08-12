package Generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtiity{

	public String getdatafromeproperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantPath.path_property);
		Properties property=new Properties();
		property.load(fis);
		return property.getProperty(key);
	}
	
}
