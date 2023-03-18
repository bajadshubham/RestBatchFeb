package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Util {

	public static RequestSpecification request;
	
	public RequestSpecification requestSpecification() throws IOException {

		if(request == null) {
		
		FileOutputStream foutput = new FileOutputStream("logging.txt");

		PrintStream log = new PrintStream(foutput);

		// Request common details
		request = new RequestSpecBuilder().setBaseUri(getGlobalvalue("baseUri"))
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();

		return request;
		}
		return request; // data append
	}

	public static String getGlobalvalue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\YOGA\\eclipse-workspace\\RestFeb\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
