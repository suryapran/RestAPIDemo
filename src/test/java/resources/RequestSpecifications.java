package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {
	public static RequestSpecification reqSpec;// if it static ,the request is cretaed only one time  for all the testcase
	public RequestSpecification RequestSpec() throws IOException
	{
		if(reqSpec==null)//it chk, if request is already created for first test case then no need to create this request again for the next data/testcase for the same request
		{
			PrintStream log = new PrintStream(new File("logging.txt"));//this is used insted of log().all().will store all details of request and response
			
			//RestAssured.baseURI="https://rahulshettyacademy.com";//this is specified in properties file
						
			 reqSpec=new RequestSpecBuilder()
			
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setBaseUri(getGlobalProperties("baseURI"))
			.addQueryParam("key", "qaclick123")
			.setContentType(ContentType.JSON)
			.build();
		}
		
		//if request already created just return the requset
		return reqSpec;
		
	}
	
	public String getGlobalProperties(String propkey) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fi=new FileInputStream("C:\\Users\\Owner\\eclipse-workspace-RestAPI\\RestAPIMaven\\src\\test\\java\\resources\\global.properties");
		prop.load(fi);
		String propval=prop.getProperty(propkey);
		return propval;
	}
	
	public String getJsonPath(Response response,String key )
	{
		String resp=response.asString();
		JsonPath js=new JsonPath(resp);
		System.out.println("js.get(key)--------"+js.get(key));
		return js.get(key);//?toString
	}
	

}
