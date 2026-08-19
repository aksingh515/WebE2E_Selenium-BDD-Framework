package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

	public WebDriver driver;

	// ReadJson data method
	public List<HashMap<String, String>> getJsonData() throws IOException {
		String filePath = System.getProperty("user.dir") + "//src//test//java//dataDriven//PurchaseOrder.json";
		// read Json to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap conversion
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public HashMap<String, String> getTestData(int index) throws IOException {

		List<HashMap<String, String>> testData = getJsonData();

		return testData.get(index);
	}

}
