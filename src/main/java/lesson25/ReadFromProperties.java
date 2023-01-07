package lesson25;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src\\main\\java\\lesson25\\demo.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
