package resources;

import java.io.File;
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
import io.restassured.specification.RequestSpecification;

public class Utils {
	TestData T=new TestData();
	RequestSpecification req;					//If we will not make it as static value will again become null after an iteration is completed
	
	public RequestSpecification requestSpecification(String userName,String password)  throws IOException {
		
		
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt",true));	//inside the constructor we need to
			// pass path of the file where we need the logging//Here we passed the second argument as true such that the file opens in the append mode and data gets logged at each request
	
			req=new RequestSpecBuilder().
				setBaseUri(getGlobalValue("BaseURI")).
				addQueryParam("username",userName).
				addQueryParam("password",password).
				setContentType(ContentType.JSON).
				
				addFilter(RequestLoggingFilter.logRequestTo(log)).				//addFilter works on the object
				addFilter(ResponseLoggingFilter.logResponseTo(log)).
				build();																// that is passed and logs
																		// everything related to it
													//logRequestTo method expects where
	
		return req.log().all();															//logRequestTo method expects where
	}																			// do we need to log everything and it expects object of printStream class
		
	
	public String getGlobalValue(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("E:\\New folder\\API\\src\\test\\java\\resources\\global.properties");
		prop.load(file);
		return prop.getProperty(key);
		
	}
	
}
