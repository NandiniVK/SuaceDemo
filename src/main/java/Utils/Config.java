package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	private static Properties props;
	
	public static void init() {
		props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			props.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return props.getProperty(key);
		
	}
}
