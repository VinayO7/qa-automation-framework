package core.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static <T> T readJson(String filePath, Class<T> clazz) {
		try {
			return objectMapper.readValue(new File(filePath), clazz);
		}
		catch(IOException e) {
			throw new RuntimeException("Unable to read JSON file: "+ filePath, e);
		}
	}
}
