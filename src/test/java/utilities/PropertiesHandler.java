package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
	
	private String result;
	private Properties property = new Properties();
	
	
	private String dir = System.getProperty("user.dir");
	private String fs = File.separator;
	private String srcTest = dir + fs + "src" + fs + "test";
	private String resources = srcTest + fs + "resources";
	private String configFile = resources + fs + "config.properties";
	
	public String getproperty(String key) throws IOException{
		
		try {
			FileInputStream inputStream = new FileInputStream(configFile);
			property.load(inputStream);
			result = property.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch properties");
		} 
		
		return result;
	}
}
