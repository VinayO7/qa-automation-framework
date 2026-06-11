package core.config;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
	
	
	private static Properties properties;
	static {
		properties = new Properties();
		
		try {
			InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
			properties.load(inputStream);
			if (inputStream == null) {
				throw new RuntimeException("config.properties not found");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public static int getTimeout() {
	    return Integer.parseInt(
	            properties.getProperty("timeout"));
	}
}
