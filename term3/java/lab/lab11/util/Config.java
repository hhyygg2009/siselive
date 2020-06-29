package util;
import java.util.Properties;
import java.io.FileInputStream;
public class Config {
	static Properties p;
	static {			
		try {
			p = new Properties();
			p.load(new FileInputStream("src/config/sqlserver.properties"));			
		}catch(Exception e) {
			e.printStackTrace();
		}

	
	}
	public static String getValue(String key) {
		return p.getProperty(key).toString();
	}
}
